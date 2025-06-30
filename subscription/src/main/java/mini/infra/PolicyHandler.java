package mini.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import mini.config.kafka.KafkaProcessor;
import mini.domain.SubscribeApplicationed;
import mini.domain.Subscribe;
import mini.domain.SubscribeRepository;
import mini.domain.SubscriberRepository;
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
    private final SubscriberRepository subscriberRepository;
    
    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DecreaseFailed'"
    )
    public void wheneverDecreaseFailed_MarkSubscribeAsFailed(@Payload DecreaseFailed event) {
        if (event.getSubscriptionId() == null) return;

        log.info(" 포인트 차감 실패 감지: {}", event.getSubscriptionId());

        subscribeRepository.findById(event.getSubscriptionId()).ifPresent(subscribe -> {
            subscribe.markAsFailed(); // 구독 상태 실패로 변경
            subscribeRepository.save(subscribe);
        });
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AuthorApproved'"
    )
    public void wheneverAuthorApproved_MarkAsAuthor(@Payload AuthorApproved eventData) {
        if (!eventData.containsKey("id")) return;

        Long subscriberId = Long.valueOf(eventData.get("id").toString());

        log.info("작가 승인 이벤트 수신: {}", subscriberId);

        subscriberRepository.findById(subscriberId).ifPresent(subscriber -> {
            subscriber.setIsAuthor(true); // Boolean 필드
            subscriberRepository.save(subscriber);
        });
    }

}

