package mini.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import mini.config.kafka.KafkaProcessor;
import mini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;


    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SignUpCompletion'"
    )    
    public void whenSubscribeApplicationed_then_CREATE_1(
        @Payload SignUpCompletion signUpCompletion
    ) {
        try {
            if (!signUpCompletion.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
         
            mypage.setUserId(signUpCompletion.getUserId());
            mypage.setPoint(signUpCompletion.getBalance());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointDecreased'"
    )    
    public void whenSubscribeApplicationed_then_UPDATE_1(
        @Payload PointDecreased pointDecreased
    ) {
        try {
            if (!pointDecreased.validate()) return;

            mypageRepository.findById(pointDecreased.getUserId()).ifPresent(mypage->{
                mypage.setPoint(pointDecreased.getBalance());
                mypageRepository.save(mypage);
            });
         
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointIncreased'"
    )    
    public void whenSubscribeApplicationed_then_UPDATE_2(
        @Payload PointIncreased pointIncreased
    ) {
        try {
            if (!subscribeApplicationed.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setSubscriptionId(
                subscribeApplicationed.getSubscriptionId()
            );
            mypage.setUserId(subscribeApplicationed.getSubscriberId());
            mypage.setBookId(subscribeApplicationed.getBookId());
            mypage.setStartDate();
            mypage.setEndDate();
            mypage.setPoint();
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointDecreased'"
    )
    public void whenPointDecreased_then_UPDATE_1(
        @Payload PointDecreased pointDecreased
    ) {
        try {
            if (!pointDecreased.validate()) return;
            // view 객체 조회

            List<Mypage> mypageList = mypageRepository.findByUserId(
                Long.valueOf(pointDecreased.getUserId())
            );
            for (Mypage mypage : mypageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                mypage.setPoingLog(String.valueOf(pointDecreased.getPrice()));
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
            });
         
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    



    //>>> DDD / CQRS
}
