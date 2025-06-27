package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookInformationRequested extends AbstractEvent {

    private String writingId;
    private String title;
    private String content;
    private String category;
    private Long authorId;
    private String status;
    private Date permitSaveAt;
    private String imageUrl;
    private Integer subscriberBill;

    public BookInformationRequested(Writing aggregate) {
        super(aggregate);
    }

    public BookInformationRequested() {
        super();
    }
}
//>>> DDD / Domain Event
