package mini.infra;

import mini.domain.*;
import mini.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscribeViewViewHandler {

//<<< DDD / CQRS
    @Autowired
    private SubscribeViewRepository subscribeViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSubscribeApplicationed_then_CREATE_(@Payload SubscribeApplicationed event) {
        try {
            if (!event.validate()) return;

            // view 객체 생성
            SubscribeView subscribeView = new SubscribeView();

            // 이벤트 값을 뷰 객체에 설정
            subscribeView.setId(event.getSubscriptionId());
            subscribeView.setUserId(event.getSubscriberId());
            subscribeView.setBookId(event.getBookId());

            // 저장
            subscribeViewRepository.save(subscribeView);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}


