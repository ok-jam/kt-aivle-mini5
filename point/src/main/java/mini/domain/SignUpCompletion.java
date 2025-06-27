package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SignUpCompletion extends AbstractEvent {

    private String userId;
    private Long balance;
    private String history;
    private Date updateAt;

    public SignUpCompletion(Point aggregate) {
        super(aggregate);
        this.userId = aggregate.getUserId();
        this.balance = aggregate.getBalance();
        this.history = aggregate.getHistory();
        this.updateAt = aggregate.getUpdateAt();
    }

    public SignUpCompletion() {
        super();
    }
}
//>>> DDD / Domain Event
