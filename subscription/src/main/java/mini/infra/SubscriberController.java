package mini.infra;

import java.util.Optional;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import mini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping(value="/subscribers")
@Transactional
public class SubscriberController {

    @Autowired
    SubscriberRepository subscriberRepository;
    
    //회원가입 API

    @PostMapping
    public Subscriber register(@RequestBody Subscriber subscriber) {
        subscriber.setJoinedAt(new Date());
        subscriber.setSubscriptionType("NONE"); // 기본값

        // DB에 저장
        Subscriber saved = subscriberRepository.save(subscriber);

        // Kafka 이벤트 발행
        SignupCompleted event = new SignupCompleted(saved);
        event.publish();  // AbstractEvent에서 제공하는 publish()

        return saved;
    }
    // 월 구독 신청 API
     @PostMapping("/{id}/monthly-subscription")
    public Subscriber applyMonthlySubscription(@PathVariable Long id) {

        Subscriber subscriber = subscriberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("해당 구독자가 없습니다."));

        subscriber.setSubscriptionType(true);    // 월 구독 신청 시
        Subscriber saved = subscriberRepository.save(subscriber);

        SubscriptionPurchased event = new SubscriptionPurchased(saved);
        event.publish();  // Kafka 전파

        return saved;
    }
}
//>>> Clean Arch / Inbound Adaptor
