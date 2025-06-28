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

    private Long subscriberId;
    private String name;
    private String email;
    private Boolean subscriptionType;

    public SubscriptionPurchased(Subscriber subscriber) {
        super(subscriber);
        this.subscriberId = subscriber.getSubscriberId();
        this.name = subscriber.getName();
        this.email = subscriber.getEmail();
        this.subscriptionType = subscriber.getSubscriptionType();
    }

    public SubscriptionPurchased() {
        super();
    }
}
//>>> DDD / Domain Event
