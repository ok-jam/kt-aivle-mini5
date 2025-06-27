package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BestsellerRegistered extends AbstractEvent {

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
 public BestsellerRegistered(Book aggregate) {
        super(aggregate);
    }

    public BestsellerRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
