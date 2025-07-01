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

// <<< DDD / CQRS
    private final SubscribeViewRepository subscribeViewRepository;

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SubscribeApplicationed'"
    )
    public void whenSubscribeApplicationed_then_CREATE_(@Payload SubscribeApplicationed subscribeApplicationed) {
        try {
            if (!event.validate()) return;

            // view 객체 생성
            SubscribeView subscribeView = new SubscribeView();

            // 이벤트 값을 뷰 객체에 설정
            subscribeView.setSubscriptionId(subscribeApplicationed.getSubscriptionId());
            subscribeView.setUserId(subscribeApplicationed.getSubscriberId());
            subscribeView.setBookId(subscribeApplicationed.getBookId());
            subscribeView.setStatus("PENDING");


            // 저장
            subscribeViewRepository.save(subscribeView);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReadingRequested'"
    )
    public void when_then_UPDATE_ (@Payload ReadingRequested readingRequested) {
        try {

            if (!readingRequested.validate()) return;

            // view 객체 생성
            subscribeViewRepository.findByBookId(readingRequested.getId()).ifPresent(subscribeView->{
                subscribeView.setTitle(readingRequested.getTitle());
                subscribeView.setCoverImageUrl(readingRequested.getCoverImageUrl());
                subscribeViewRepository.save(subscribeView);
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // @StreamListener(
    //     value = KafkaProcessor.INPUT,
    //     condition = "headers['type']=='SubscribeApplicationed'"
    // )    
    // public void whenSubscribeApplicationed_then_CREATE_1(
    //     @Payload SubscribeApplicationed subscribeApplicationed
    // ) {
    //     try {
    //         if (!subscribeApplicationed.validate()) return;

    //         // view 객체 생성
    //         Mypage mypage = new Mypage();
    //         // view 객체에 이벤트의 Value 를 set 함
    //         mypage.setSubscriptionId(
    //             subscribeApplicationed.getSubscriptionId()
    //         );
    //         mypage.setUserId(subscribeApplicationed.getSubscriberId());
    //         mypage.setBookId(subscribeApplicationed.getBookId());
    //         mypage.setStartDate()
    //         mypage.setEndDate()
    //         mypage.setPoint()
    //         // view 레파지 토리에 save
    //         mypageRepository.save(mypage);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    //>>> DDD / CQRS
}


