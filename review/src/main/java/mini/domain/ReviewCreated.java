package mini.domain;

import mini.infra.AbstractEvent;

public class ReviewCreated extends AbstractEvent {

    private Long bookServiceId;
    private Long bookId;
    private Long userId;
    private Double rating;
    private String review;

    public ReviewCreated(BookService aggregate) {
        super(aggregate);
        this.bookServiceId = aggregate.getBookServiceId();
        this.bookId = aggregate.getBookId();
        this.userId = aggregate.getUserId();
        this.rating = aggregate.getRating();
        this.review = aggregate.getReview();
    }

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
}
