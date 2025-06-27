package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ResultsReturned extends AbstractEvent {

    private String resultImage;
    private String resultsummary;
    private File resultPdf;
    private Long taskId;
    private Long writingId;
    private String taskType;
    private String status;
    private Date requestedAt;
    private Date completedAt;

    public ResultsReturned(Ai aggregate) {
        super(aggregate);
    }

    public ResultsReturned() {
        super();
    }
}
//>>> DDD / Domain Event
