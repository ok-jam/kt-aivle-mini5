package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookRegistered extends AbstractEvent {

    private Long id;
    private String title;
    private String summary;
    private Long authorId;
    private String coverImageUrl;
    private String content;
    private Date createdAt;
    private Date publishedAt;
    private Long viewcount;
    private String category;
    private Integer subscriberBill;

    public BookRegistered(Book aggregate) {
        super(aggregate);
    }

    public BookRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
