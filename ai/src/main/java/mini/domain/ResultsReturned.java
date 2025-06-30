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
    private String resultPdf;
    private Long writingId;

    public ResultsReturned(Ai aggregate) {
        super(aggregate);
        this.writingId = aggregate.getWritingId();
        this.resultImage = aggregate.getResultImage();
        this.resultsummary = aggregate.getResultsummary();
        this.resultPdf = aggregate.getResultPdf();
    }

    public ResultsReturned() {
        super();
    }
}
//>>> DDD / Domain Event
