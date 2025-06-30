package mini.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import mini.config.kafka.KafkaProcessor;
import mini.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mini.infra.AbstractEvent;
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
        Subscribe.subscribefail(event);
        
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AuthorApproved'"
    )
    public void wheneverAuthorApproved_AuthorApproved(
        @Payload AuthorApproved authorApproved
    ) {
        AuthorApproved event = authorApproved;
        System.out.println(
            "\n\n##### listener AuthorApproved : " + authorApproved + "\n\n"
        );

        // Sample Logic //
        Subscriber.authorApproved(event);
    }
}

