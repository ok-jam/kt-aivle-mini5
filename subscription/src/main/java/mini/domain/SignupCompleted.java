package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SignupCompleted extends AbstractEvent {

    private Long subscriberId;
    private String name;
    private String email;
    private String password;
    private Boolean kttelecom;
    private java.util.Date joinedAt;
    private Boolean subscriptionType;
    private Boolean jjim;
    private Long reviews;

    public SignupCompleted(Subscriber subscriber) {
        super(subscriber);
        this.subscriberId = subscriber.getSubscriberId();
        this.name = subscriber.getName();
        this.email = subscriber.getEmail();
        this.password = subscriber.getPassword();
        this.kttelecom = subscriber.getKttelecom();
        this.joinedAt = subscriber.getJoinedAt();
        this.subscriptionType = subscriber.getSubscriptionType();
        this.reviews = subscriber.getReviews();
    }

    public SignupCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
