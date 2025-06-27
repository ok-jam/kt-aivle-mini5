package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorDeleted extends AbstractEvent {

    private Long id;
    private String name;
    private String bio;
    private String portfolioUrl;
    private String status;
    private Date createdAt;
    private Date updateAt;

    public AuthorDeleted(Author aggregate) {
        super(aggregate);
    }

    public AuthorDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
