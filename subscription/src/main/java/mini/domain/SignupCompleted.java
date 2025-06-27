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

    public SignupCompleted(Subscriber aggregate) {
        super(aggregate);
    }

    public SignupCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
