package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AuthorRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private String bio;
    private String portfolioUrl;
    private String status;
    private Date createdAt;
    private Date updateAt;

    public AuthorRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
