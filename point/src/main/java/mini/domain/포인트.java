package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.PointApplication;
import mini.domain.DecreaseFailed;
import mini.domain.PointDecreased;
import mini.domain.PointIncreased;
import mini.domain.SignUpCompletion;

@Entity
@Table(name = "포인트_table")
@Data
//<<< DDD / Aggregate Root
public class 포인트 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;

    private Long balance;

    private String history;

    private Date updateAt;

    public static 포인트Repository repository() {
        포인트Repository 포인트Repository = PointApplication.applicationContext.getBean(
            포인트Repository.class
        );
        return 포인트Repository;
    }

    //<<< Clean Arch / Port Method
    public static void pointDecreaseRequeset(
        SubscribeApplicationed subscribeApplicationed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        포인트 포인트 = new 포인트();
        repository().save(포인트);

        DecreaseFailed decreaseFailed = new DecreaseFailed(포인트);
        decreaseFailed.publishAfterCommit();
        PointDecreased pointDecreased = new PointDecreased(포인트);
        pointDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if subscribeApplicationed.subscriberId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> subscribeMap = mapper.convertValue(subscribeApplicationed.getSubscriberId(), Map.class);

        repository().findById(subscribeApplicationed.get???()).ifPresent(포인트->{
            
            포인트 // do something
            repository().save(포인트);

            DecreaseFailed decreaseFailed = new DecreaseFailed(포인트);
            decreaseFailed.publishAfterCommit();
            PointDecreased pointDecreased = new PointDecreased(포인트);
            pointDecreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void signup(SignupCompleted signupCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        포인트 포인트 = new 포인트();
        repository().save(포인트);

        SignUpCompletion signUpCompletion = new SignUpCompletion(포인트);
        signUpCompletion.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(signupCompleted.get???()).ifPresent(포인트->{
            
            포인트 // do something
            repository().save(포인트);

            SignUpCompletion signUpCompletion = new SignUpCompletion(포인트);
            signUpCompletion.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
