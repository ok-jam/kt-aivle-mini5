package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscribeCanceled extends AbstractEvent {

    private Long id;

    public SubscribeCanceled(Subscribe subscribe) {
        super(subscribe);
    }

    public SubscribeCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
