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
    private String resultPdf;
    private Long taskId;
    private Long writingId;

}
