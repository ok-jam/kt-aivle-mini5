package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewCreated extends AbstractEvent {

    private Long bookServiceId;
    private Long bookId;
    private Long userId;
    private Double rating;
    private String review;

    public ReviewCreated(BookService aggregate) {
        super(aggregate);
    }

    public ReviewCreated() {
        super();
    }
}
//>>> DDD / Domain Event
