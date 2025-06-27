package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RegistrationRequested extends AbstractEvent {

    private Long authorId;
    private String content;
    private String status;
    private Date permitSaveAt;
    private String imageUrl;
    private String category;
    private Integer subscriberBill;
    private String title;
    private String writingId;

    public RegistrationRequested(Writing aggregate) {
        super(aggregate);
    }

    public RegistrationRequested() {
        super();
    }
}
//>>> DDD / Domain Event
