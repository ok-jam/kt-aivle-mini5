package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscribeApplicationed extends AbstractEvent {

    private Boolean subscriptionType;
    private Integer price;
    private Long subscriptionId;
    private Long subscriberId;

    public SubscribeApplicationed(Subscribe subscribe) {
        super(subscribe);
        this.subscriptionId = subscribe.getSubscriptionId();
        this.subscriberId = subscribe.getSubscriberId();
        this.price = subscribe.getPrice();
    }
    public SubscribeApplicationed() {
        super();
    }
}
//>>> DDD / Domain Event
