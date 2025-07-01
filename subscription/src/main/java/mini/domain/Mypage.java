package mini.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Entity
@Table(name = "Mypage_table")
@Data
public class Mypage {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    private Long point;
    private List<String> pointLog;

}