package mini.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import mini.config.kafka.KafkaProcessor;
import mini.domain.SubscribeApplicationed;
import mini.domain.Subscribe;
import mini.domain.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mini.infra.AbstractEvent;
import mini.domain.DecreaseFailed;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PolicyHandler {
    private final SubscribeRepository subscribeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSubscribeApplicationed_RequestPointDecrease(@Payload SubscribeApplicationed event) {
        if (!event.validate()) return;

        log.info(" 포인트 차감 요청 전송: {}", event);

        // 예시: 포인트 도메인에 REST API 요청 (또는 Kafka 발행도 가능)
        Map<String, Object> request = new HashMap<>();
        request.put("subscriberId", event.getSubscriberId());
        request.put("amount", event.getPrice());
        request.put("subscriptionId", event.getSubscriptionId());  // 실패 대응 위해 추가

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(
                "http://POINTING:8080/points/decrease",  // 포인트 도메인의 엔드포인트 주소
                request,
                String.class
            );
        } catch (Exception e) {
            log.error(" 포인트 차감 요청 실패: {}", e.getMessage());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDecreaseFailed_MarkSubscribeAsFailed(@Payload DecreaseFailed event) {
        if (event.getSubscriptionId() == null) return;

        log.info(" 포인트 차감 실패 감지: {}", event.getSubscriptionId());

        subscribeRepository.findById(event.getSubscriptionId()).ifPresent(subscribe -> {
            subscribe.markAsFailed(); // 구독 상태 실패로 변경
            subscribeRepository.save(subscribe);
        });
    }
}

