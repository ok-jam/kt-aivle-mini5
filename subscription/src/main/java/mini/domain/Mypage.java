package mini.domain;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name = "Mypage_table")
@Data
public class Mypage {
    @Id
    @Column(name = "subscription_id")
    private Long subscriptionId;

    private Long userId;
    private String bookId;
    private String status;
    private Date startDate;
    private Date endDate;
    private Long point;
    private String pointLog;
    private String title;
    private String coverImageUrl;
}