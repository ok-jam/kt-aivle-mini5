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
    private Long writingId;
    private String summary;
    private String pdf;

    public RegistrationRequested(Writing aggregate) {
        super(aggregate);
        this.authorId = aggregate.getAuthorId();
        this.category = aggregate.getCategory();
        this.content = aggregate.getContent();
        this.imageUrl = aggregate.getImageUrl();
        this.pdf = aggregate.getPdf();
        this.permitSaveAt = aggregate.getPermitSaveAt();
        this.subscriberBill = aggregate.getSubscriberBill();
        this.title = aggregate.getTitle();
        this.writingId = aggregate.getWritingId();
        this.summary = aggregate.getSummary();
    }

    public RegistrationRequested() {
        super();
    }
}
//>>> DDD / Domain Event
