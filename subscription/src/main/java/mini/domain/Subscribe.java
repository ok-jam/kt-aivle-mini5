package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.SubscriptionApplication;
import mini.domain.SubscribeApplicationed;
import mini.domain.SubscribeCanceled;
import mini.domain.SubscribeFailed;
import mini.infra.AbstractEvent;

@Entity
@Table(name = "Subscribe_table")
@Data
//<<< DDD / Aggregate Root
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;
    private String status;
    private Date startDate;
    private Date endDate;
    private Integer price;
    private Long subscriberId;
    private Long bookId;

    @PostPersist
    public void onPostPersist() {
        this.status = "신청됨";
        this.startDate = new Date();
        // 임의로 7일 구독 기간 부여
        this.endDate = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7));
        this.price = 1000;

        SubscribeApplicationed event = new SubscribeApplicationed(this);
        event.publishAfterCommit(); // 이벤트 발행
    }

    

    public void cancel() {
        SubscribeCanceled event = new SubscribeCanceled(this);
        event.publishAfterCommit();
    }

    public void markAsFailed() {
        this.status = "실패";  // 상태만 바꿔줌
    }

    public static SubscribeRepository repository() {
        SubscribeRepository subscribeRepository = SubscriptionApplication.applicationContext.getBean(
            SubscribeRepository.class
        );
        return subscribeRepository;
    }


    //<<< Clean Arch / Port Method
    public static void subscribefail(DecreaseFailed decreaseFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscribe subscribe = new Subscribe();
        repository().save(subscribe);

        SubscribeFailed subscribeFailed = new SubscribeFailed(subscribe);
        subscribeFailed.publishAfterCommit();
        */

        repository().findById(decreaseFailed.getSubscriptionId()).ifPresent(subscribe->{
            
    
            repository().delete(subscribe);

         });
        

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
