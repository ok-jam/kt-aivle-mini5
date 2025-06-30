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

    // ✅ 찜 수 필드 추가
    private int likeCount = 0;

    // ===== Getter =====
    public Long getBookServiceId() { return this.bookServiceId; }
    public Long getBookId() { return this.bookId; }
    public Long getUserId() { return this.userId; }
    public Double getRating() { return this.rating; }
    public String getReview() { return this.review; }
    public int getLikeCount() { return this.likeCount; }

    // ===== Review 등록 시 이벤트 발행 =====
    @PostPersist
    public void onPostPersist() {
        ReviewCreated reviewCreated = new ReviewCreated(this);
        reviewCreated.publishAfterCommit();
    }

    // ✅ 찜 추가 메서드 및 이벤트 발행
    public void addLike() {
        this.likeCount += 1;

        ReviewCreated event = new ReviewCreated(this);
        event.publishAfterCommit(); // 또는 publish(), publishImmediately()
    }

    // ===== Repository 접근 메서드 =====
    public static BookServiceRepository repository() {
        return ReviewApplication.applicationContext.getBean(BookServiceRepository.class);
    }
}
