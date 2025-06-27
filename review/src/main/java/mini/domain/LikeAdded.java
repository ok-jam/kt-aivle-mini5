package mini.domain;

import mini.infra.AbstractEvent;
import javax.persistence.*;

public class LikeAdded extends AbstractEvent {

    private Long bookServiceId;

    public LikeAdded(BookService aggregate) {
        super(aggregate);
        this.bookServiceId = aggregate.getBookServiceId();
    }

    public Long getBookServiceId() {
        return bookServiceId;
    }
}
