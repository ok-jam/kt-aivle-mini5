package mini.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import mini.config.kafka.KafkaProcessor;
import mini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Autowired
    SubscribeRepository subscribeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DecreaseFailed'"
    )
    public void wheneverDecreaseFailed_Subscribefail(
        @Payload DecreaseFailed decreaseFailed
    ) {
        DecreaseFailed event = decreaseFailed;
        System.out.println(
            "\n\n##### listener Subscribefail : " + decreaseFailed + "\n\n"
        );

        // Comments //
        //1. 포인트 부족 알람
        // 2. 서버 오류

        // Sample Logic //
        Subscribe.subscribefail(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
