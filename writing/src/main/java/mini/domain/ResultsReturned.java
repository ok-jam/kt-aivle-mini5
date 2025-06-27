package mini.domain;

import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

@Data
@ToString
public class ResultsReturned extends AbstractEvent {

    private String resultImage;
    private String resultsummary;
    private Object resultPdf;
    private Long taskId;
    private Long writingId;
    private String taskType;
    private String status;
    private Date requestedAt;
    private Date completedAt;
}
