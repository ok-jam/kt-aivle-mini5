package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscribeFailed extends AbstractEvent {

    private Long id;

    public SubscribeFailed(Subscribe subscribe) {
        super(subscribe);
    }

    public SubscribeFailed() {
        super();
    }
}
//>>> DDD / Domain Event
