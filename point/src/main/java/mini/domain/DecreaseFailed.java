package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DecreaseFailed extends AbstractEvent {

    private String userId;
    private Long balance;
    private String history;
    private Date updateAt;

    public DecreaseFailed(Point aggregate) {
        super(aggregate);
    }

    public DecreaseFailed() {
        super();
    }
}
//>>> DDD / Domain Event
