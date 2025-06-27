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
    private Long subcriberId;

    public SubscribeApplicationed(Subscribe aggregate) {
        super(aggregate);
    }

    public SubscribeApplicationed() {
        super();
    }
}
//>>> DDD / Domain Event
