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

    private Long subcriberId;

    private Long bookId;

    @Embedded
    private 구독자Id 구독자Id;

    @PostPersist
    public void onPostPersist() {
        SubscribeApplicationed subscribeApplicationed = new SubscribeApplicationed(
            this
        );
        subscribeApplicationed.publishAfterCommit();

        SubscribeCanceled subscribeCanceled = new SubscribeCanceled(this);
        subscribeCanceled.publishAfterCommit();

        SubscribeFailed subscribeFailed = new SubscribeFailed(this);
        subscribeFailed.publishAfterCommit();
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

        /** Example 2:  finding and process
        

        repository().findById(decreaseFailed.get???()).ifPresent(subscribe->{
            
            subscribe // do something
            repository().save(subscribe);

            SubscribeFailed subscribeFailed = new SubscribeFailed(subscribe);
            subscribeFailed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
