package mini.infra;

import java.util.Optional;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import mini.domain.*;
import mini.domain.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping(value = "/subscribers")
@Transactional
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SubscriberController {

    private final SubscriberRepository subscriberRepository;
    private final SubscribeRepository subscribeRepository;
    
    // 구독자 등록 API
    @PostMapping
    public Subscriber register(@RequestBody Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }
    @GetMapping
    public Iterable<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subscriber getSubscriber(@PathVariable Long id) {
        return subscriberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subscriber not found"));
    }


    // 월 구독 신청 API
    @PostMapping("/{id}/purchase-monthly")
    public Subscriber purchaseMonthly(@PathVariable Long id) {
        Subscriber subscriber = subscriberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Subscriber not found"));

        subscriber.purchaseMonthlySubscription(); // 도메인 메서드 호출

        return subscriberRepository.save(subscriber); // DB 반영
    }

    // 로그인 API
    @PostMapping("/login")
    public Subscriber login(@RequestBody LoginRequest loginRequest) {
        Subscriber subscriber = subscriberRepository.findByEmail(loginRequest.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found with email: " + loginRequest.getEmail()));

        if (!subscriber.getPassword().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return subscriber;
    }

    
}

