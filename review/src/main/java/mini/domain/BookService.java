package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.ReviewApplication;
import mini.domain.ReviewCreated;

@Entity
@Table(name = "BookService_table")
@Data
//<<< DDD / Aggregate Root
public class BookService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookServiceId;

    private Long bookId;

    private Long userId;

    private Double rating;

    private String review;

    @PostPersist
    public void onPostPersist() {
        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();
    }

    public static BookServiceRepository repository() {
        BookServiceRepository bookServiceRepository = ReviewApplication.applicationContext.getBean(
            BookServiceRepository.class
        );
        return bookServiceRepository;
    }
}
//>>> DDD / Aggregate Root
