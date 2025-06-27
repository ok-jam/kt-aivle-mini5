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
public class MypageViewHandler {

//<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSubscribeApplicationed_then_CREATE_1 (@Payload SubscribeApplicationed subscribeApplicationed) {
        try {

            if (!subscribeApplicationed.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setSubscriptionid(subscribeApplicationed.getSubscriptionId());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointDecreased_then_UPDATE_1(@Payload PointDecreased pointDecreased) {
        try {
            if (!pointDecreased.validate()) return;
                // view 객체 조회
            Optional<Mypage> mypageOptional = mypageRepository.findBySubscriptionid(Long.valueOf(pointDecreased.getUserId()));

            if( mypageOptional.isPresent()) {
                 Mypage mypage = mypageOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setPointlog(List<String>.valueOf(pointDecreased.getPrice()));    
                // view 레파지 토리에 save
                 mypageRepository.save(mypage);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


//>>> DDD / CQRS
}

