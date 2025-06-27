package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionPurchased extends AbstractEvent {

    private Long reviews;
    private Long subscriberId;
    private String name;
    private String email;
    private String password;
    private Boolean kttelecom;
    private Date joinedAt;
    private Boolean subscriptionType;
    private Long jjim;

    public SubscriptionPurchased(Subscriber subscriber) {
        super(subscriber);
        this.subscriberId = subscriber.getId();
        this.name = subscriber.getName();
        this.email = subscriber.getEmail();
        this.password = subscriber.getPassword();  // 보안상 실제로는 안 보내는 게 좋음
        this.kttelecom = subscriber.getKtTelecom();
        this.joinedAt = subscriber.getJoinedAt();
        this.subscriptionType = "MONTHLY".equalsIgnoreCase(subscriber.getSubscriptionType());
        this.jjim = 0L;
        this.reviews = 0L;
    }

    public SubscriptionPurchased() {
        super();
    }
}
//>>> DDD / Domain Event
