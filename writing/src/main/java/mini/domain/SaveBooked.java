package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SaveBooked extends AbstractEvent {

    private String writingId;
    private Long authorId;
    private String title;
    private String content;
    private String status;
    private Date permitSaveAt;
    private String imageUrl;
    private String category;
    private Integer subscriberBill;

    public SaveBooked(Writing aggregate) {
        super(aggregate);
    }

    public SaveBooked() {
        super();
    }
}
//>>> DDD / Domain Event
