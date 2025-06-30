package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InformationCreated extends AbstractEvent {

    private Long id;
    private String title;
    private String content;
    private String category; 

    public InformationCreated(Ai aggregate) {
        super(aggregate);
    }

    public InformationCreated() {
        super();
    }
}
//>>> DDD / Domain Event
