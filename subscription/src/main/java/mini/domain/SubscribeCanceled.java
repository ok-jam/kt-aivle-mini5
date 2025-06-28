package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
public class SubscribeCanceled extends AbstractEvent {

    private Long subscriptionId;
    private Long subscriberId;
    private Long bookId;
    private String status;

    public SubscribeCanceled(Subscribe subscribe) {
        super(subscribe);
        this.subscriptionId = subscribe.getSubscriptionId();
        this.subscriberId = subscribe.getSubscriberId();
        this.bookId = subscribe.getBookId();
        this.status = subscribe.getStatus();
    }

    public SubscribeCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
