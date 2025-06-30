package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.PointApplication;
import mini.domain.DecreaseFailed;
import mini.domain.PointDecreased;
import mini.domain.PointIncreased;
import mini.domain.SignupCompleted;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    private Long balance;

    private String history;

    private Date updateAt;


    public static PointRepository repository() {
        PointRepository PointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return PointRepository;
    }

    //<<< Clean Arch / Port Method
    
    // 2. 구독 신청시 포인트 차감 요청
    public static void pointDecreaseRequeset(
        SubscribeApplicationed subscribeApplicationed
    ) {
        //implement business logic here:
        
        // 유저 ID를 기준으로 포인트 조회
        repository().findById(String.valueOf(subscribeApplicationed.getSubscriberId())).ifPresent(point -> {
            Long price = subscribeApplicationed.getPrice().longValue();

            // 포인트가 충분하면 차감
            if (point.getBalance() >= price) {
                point.setBalance(point.getBalance() - price);
                point.setHistory("Subscription: -" + price + "P");
                point.setUpdateAt(new Date());

                repository().save(point);

                PointDecreased pointDecreased = new PointDecreased(point);
                pointDecreased.setBookId(subscribeApplicationed.getBookId());
                pointDecreased.setPrice(subscribeApplicationed.getPrice());
                pointDecreased.publishAfterCommit();
            }
            
            // 포인트 충분하지 않으면
            else {
                DecreaseFailed decreaseFailed = new DecreaseFailed(point);
                decreaseFailed.setSubscriptionId(subscribeApplicationed.getSubscriptionId());
                decreaseFailed.publishAfterCommit();
        }
    });
}



    // 1. 회원가입 완료 이벤트 수신 + 초기 포인트 지급
    public static void signup(SignupCompleted signupCompleted) {
        //implement business logic here:

        Point point = new Point();

        point.setUserId(String.valueOf(signupCompleted.getSubscriberId())); // or signupCompleted.getEmail()
        point.setBalance(1000L);  // 기본 지급 포인트
        point.setHistory("Sign-up: + 1000P");
        point.setUpdateAt(new Date());

        repository().save(point);

        SignUpCompletion signUpCompletion = new SignUpCompletion(point);
        signUpCompletion.publishAfterCommit();
    }
}


