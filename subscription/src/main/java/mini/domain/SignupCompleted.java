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
    private Boolean kttelecom;
    private Boolean subscriptionType;
    private String name;
    private String email;
    private String password;
    private Date joinedAt;
    private Long jjim;
    private Long reviews;

    public SignupCompleted(Subscriber subscriber) {
        super(subscriber);
        this.subscriberId = subscriber.getId();
        this.ktTelecom = subscriber.getKtTelecom();
        this.subscriptionType = subscriber.getSubscriptionType();
        this.name = subscriber.getName();
        this.email = subscriber.getEmail();
        this.joinedAt = subscriber.getJoinedAt();

    }

    public SignupCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
