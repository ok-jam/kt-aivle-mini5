package mini.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mini.infra.AbstractEvent;

//<<< EDA / CQRS
@Entity
@Table(name = "SubscribeView_table")
@Data
public class SubscribeView {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long subscriptionId;
    private Long userId;
    private Long bookId;
    private String status;
    private String title;
    private String coverImageUrl;
    private Date startDate;
    private Date endDate;

}
