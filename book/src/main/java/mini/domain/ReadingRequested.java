package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReadingRequested extends AbstractEvent {

    private String title;
    private Long id;
    private String summary;
    private Long authorId;
    private String coverImageUrl;
    private String content;
    private Date createdAt;
    private Date publishedAt;
    private Long viewcount;
    private String category;
    private Integer subscriberBill;

    public ReadingRequested(Book aggregate) {
        super(aggregate);
    }

    public ReadingRequested() {
        super();
    }
}
//>>> DDD / Domain Event
