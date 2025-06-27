package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LikeAdded extends AbstractEvent {

    private Long reviews;
    private Long subscriberId;
    private String name;
    private String email;
    private String password;
    private Boolean kttelecom;
    private Date joinedAt;
    private Boolean subscriptionType;
    private Long jjim;

    public LikeAdded(Subscriber aggregate) {
        super(aggregate);
    }

    public LikeAdded() {
        super();
    }
}
//>>> DDD / Domain Event
