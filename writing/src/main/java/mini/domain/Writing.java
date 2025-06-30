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
    @Column(length = 9999)
    private String imageUrl;

    private String category;

    private Integer subscriberBill;
    @Column(length = 9999)
    private String summary;
    @Column(length = 9999)
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

        repository().findById(resultsReturned.getWritingId()).ifPresent(writing->{
            
            writing.setImageUrl(resultsReturned.getResultImage());
            writing.setSummary(resultsReturned.getResultsummary());
            writing.setPdf(resultsReturned.getResultPdf());
            repository().save(writing);


         });
  

    }

    public void requestRegistration() {
        RegistrationRequested event = new RegistrationRequested(this);
        event.publishAfterCommit();
    }
    //>>> Clean Arch / Port Metho  d

}
//>>> DDD / Aggregate Root
