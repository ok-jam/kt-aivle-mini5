package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.AiApplication;
import mini.domain.InformationCreated;
import mini.domain.ResultsReturned;

@Entity
@Table(name = "Ai_table")
@Data
//<<< DDD / Aggregate Root
public class Ai {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private Long writingId;

    private String taskType;

    private String status;

    private Date requestedAt;

    private Date completedAt;

    private String resultImage;

    private String resultsummary;

    @Embedded
    private File resultPdf;

    @PostPersist
    public void onPostPersist() {
        ResultsReturned resultsReturned = new ResultsReturned(this);
        resultsReturned.publishAfterCommit();

        InformationCreated informationCreated = new InformationCreated(this);
        informationCreated.publishAfterCommit();
    }

    public static AiRepository repository() {
        AiRepository aiRepository = AiApplication.applicationContext.getBean(
            AiRepository.class
        );
        return aiRepository;
    }

    //<<< Clean Arch / Port Method
    public static void informationcreate(
        BookInformationRequested bookInformationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Ai ai = new Ai();
        repository().save(ai);

        InformationCreated informationCreated = new InformationCreated(ai);
        informationCreated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookInformationRequested.get???()).ifPresent(ai->{
            
            ai // do something
            repository().save(ai);

            InformationCreated informationCreated = new InformationCreated(ai);
            informationCreated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
