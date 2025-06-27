package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import mini.infra.AbstractEvent;

@Data
public class PointDecreased extends AbstractEvent {

    private Integer price;
    private String userId;
    private Long balance;
    private String history;
    private Date updateAt;
}
