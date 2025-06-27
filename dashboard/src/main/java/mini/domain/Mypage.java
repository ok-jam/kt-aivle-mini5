package mini.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;
import java.time.LocalDate;


//<<< EDA / CQRS
@Entity
@Table(name="Mypage_table")
@Data
public class Mypage {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long subscriptionid;
        private String boodId;
        private List&lt;String&gt; pointlog;


}
