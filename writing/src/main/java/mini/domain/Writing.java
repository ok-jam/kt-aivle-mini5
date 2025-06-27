package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.WritingApplication;
import mini.domain.BookInformationRequested;
import mini.domain.RegistrationRequested;
import mini.domain.SaveBooked;

@Entity
@Table(name = "Writing_table")
@Data
//<<< DDD / Aggregate Root
public class Writing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long writingId;

    private Long authorId;

    private String title;

    private String content;

    private String status;

    private Date permitSaveAt;

    private String imageUrl;

    private String category;

    private Integer subscriberBill;

    private String summary;

    private String pdf;

    @PostPersist
    public void onPostPersist() {

    }

    public static WritingRepository repository() {
        WritingRepository writingRepository = WritingApplication.applicationContext.getBean(
            WritingRepository.class
        );
        return writingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void bookupdate(ResultsReturned resultsReturned) {
        //implement business logic here:

        /** Example 1:  new item 
        Writing writing = new Writing();
        repository().save(writing);

        */

        /** Example 2:  finding and process
        
        // if resultsReturned.aiGptId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> aiMap = mapper.convertValue(resultsReturned.getAiGptId(), Map.class);
        
        */
        repository().findById(resultsReturned.getWritingId().toString()).ifPresent(writing->{
            
            writing.setImageUrl(resultsReturned.getResultImage());
            writing.setSummary(resultsReturned.getResultsummary());
            writing.setPdf(resultsReturned.getResultPdf());
            repository().save(writing);


         });
  

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
