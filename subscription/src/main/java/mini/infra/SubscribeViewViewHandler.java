package mini.infra;

import mini.domain.*;
import mini.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SubscribeViewViewHandler {

//<<< DDD / CQRS
    @Autowired
    private SubscribeViewRepository subscribeViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_CREATE_ (@Payload  ) {
        try {

            if (!.validate()) return;

            // view 객체 생성
            SubscribeView subscribeView = new SubscribeView();
            // view 객체에 이벤트의 Value 를 set 함
            subscribeView.set();
            // view 레파지 토리에 save
            subscribeViewRepository.save(subscribeView);

        }catch (Exception e){
            e.printStackTrace();
        }
    }




//>>> DDD / CQRS
}

