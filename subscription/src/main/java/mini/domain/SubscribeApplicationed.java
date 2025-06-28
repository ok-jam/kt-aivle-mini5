package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
public class SubscribeApplicationed extends AbstractEvent {

    private Long subscriptionId;
    private Long subscriberId;
    private Long bookId;
    private String status;
    private Integer price;
    private Date startDate;
    private Date endDate;

    // 생성자
    public SubscribeApplicationed(Subscribe subscribe) {
        super(subscribe);
        this.subscriptionId = subscribe.getSubscriptionId();
        this.subscriberId = subscribe.getSubscriberId();
        this.bookId = subscribe.getBookId();
        this.status = subscribe.getStatus();
        this.price = subscribe.getPrice();
        this.startDate = subscribe.getStartDate();
        this.endDate = subscribe.getEndDate();
    }

    // 기본 생성자
    public SubscribeApplicationed() {
        super();
    }

    //생성자 밖에 validate 메서드 정의
    public boolean validate() {
        return subscriptionId != null && subscriberId != null && price != null;
    }
}
//>>> DDD / Domain Event
