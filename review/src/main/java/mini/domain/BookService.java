package mini.domain;

import javax.persistence.*;
import lombok.Data;
import mini.ReviewApplication;
import mini.domain.ReviewCreated;

@Entity
@Table(name = "BookService_table")
@Data
public class BookService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookServiceId;

    private Long bookId;
    private Long userId;
    private Double rating;
    private String review;

    // 명시적 getter 추가
    public Long getBookServiceId() { return this.bookServiceId; }
    public Long getBookId() { return this.bookId; }
    public Long getUserId() { return this.userId; }
    public Double getRating() { return this.rating; }
    public String getReview() { return this.review; }

    @PostPersist
    public void onPostPersist() {
        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();
    }

    public static BookServiceRepository repository() {
        return ReviewApplication.applicationContext.getBean(BookServiceRepository.class);
    }
}
