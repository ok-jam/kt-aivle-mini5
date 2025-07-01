package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.SubscriptionApplication;
import mini.domain.SignupCompleted;
import mini.domain.SubscriptionPurchased;
import mini.infra.AbstractEvent;

@Entity
@Table(name = "Subscriber_table")
@Data
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriberId;

    private String name;
    private String email;
    private String password;
    private Boolean kttelecom;         // KT 통신사 여부
    private Date joinedAt;             // 가입 일시
    private Boolean subscriptionType;  // 월 정액 여부
    private Long reviews;              // 작성 리뷰 수
    private Boolean isAuthor;


    public void purchaseMonthlySubscription() {
        this.subscriptionType = true;

        SubscriptionPurchased event = new SubscriptionPurchased(this);
        event.publishAfterCommit();
    }

    public static SubscriberRepository repository() {
        SubscriberRepository subscriberRepository = SubscriptionApplication.applicationContext.getBean(
            SubscriberRepository.class
        );
        return subscriberRepository;
    }
    
    @PrePersist
    public void onPrePersist() {
        this.joinedAt = new Date();         // 가입일 자동 설정
        this.subscriptionType = false;      // 기본값: 월정액 미가입
        this.reviews = 0L;
        this.isAuthor =false;
    }

    @PostPersist
    public void onPostPersist() {
        SignupCompleted event = new SignupCompleted(this);
        event.publishAfterCommit();   // 트랜잭션 커밋 후에만 발행
    }

    public static void authorApproved(AuthorApproved authorApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscriber subscriber = new Subscriber();
        repository().save(subscriber);

        */

  
        

        repository().findById(authorApproved.getId()).ifPresent(subscriber->{
            
            subscriber.setIsAuthor(true); // do something
            repository().save(subscriber);


         });
    

    }

}
//>>> DDD / Aggregate Root
