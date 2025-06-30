package mini.domain;

import mini.infra.AbstractEvent;

public class ReviewCreated extends AbstractEvent {

    private Long bookServiceId;
    private Long bookId;
    private Long userId;
    private Double rating;
    private String review;
    private int likeCount; // ✅ 찜 수 필드도 포함

    // ✅ 기본 생성자 (JPA 또는 Jackson 직렬화용)
    public ReviewCreated() {
        super();
    }

    // ✅ BookService로부터 이벤트 생성하는 생성자
    public ReviewCreated(BookService aggregate) {
        super(aggregate);
        this.bookServiceId = aggregate.getBookServiceId();
        this.bookId = aggregate.getBookId();
        this.userId = aggregate.getUserId();
        this.rating = aggregate.getRating();
        this.review = aggregate.getReview();
        this.likeCount = aggregate.getLikeCount(); // 찜 수
    }

    // ✅ Getter
    public Long getBookServiceId() {
        return bookServiceId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public int getLikeCount() {
        return likeCount;
    }
}
