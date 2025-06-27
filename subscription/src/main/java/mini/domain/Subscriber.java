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
import mini.domain.LikeAdded;
import mini.domain.SignupCompleted;
import mini.domain.SubscriptionPurchased;

@Entity
@Table(name = "Subscriber_table")
@Data
//<<< DDD / Aggregate Root
public class Subscriber {

    private Long subscriberId;

    private String name;

    private String email;

    private String password;

    private Boolean kttelecom;

    private Date joinedAt;

    private Boolean subscriptionType;

    private Long jjim;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviews;

    @PostPersist
    public void onPostPersist() {
        SignupCompleted signupCompleted = new SignupCompleted(this);
        signupCompleted.publishAfterCommit();

        LikeAdded likeAdded = new LikeAdded(this);
        likeAdded.publishAfterCommit();

        SubscriptionPurchased subscriptionPurchased = new SubscriptionPurchased(
            this
        );
        subscriptionPurchased.publishAfterCommit();
    }

    public static SubscriberRepository repository() {
        SubscriberRepository subscriberRepository = SubscriptionApplication.applicationContext.getBean(
            SubscriberRepository.class
        );
        return subscriberRepository;
    }
}
//>>> DDD / Aggregate Root
