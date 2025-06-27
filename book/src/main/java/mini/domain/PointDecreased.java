package mini.domain;

import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

@Data
@ToString
public class PointDecreased extends AbstractEvent {

    private Integer price;
    private String userId;
    private Long balance;
    private String history;
    private Date updateAt;
}
