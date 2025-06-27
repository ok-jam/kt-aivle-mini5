package mini.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import mini.infra.AbstractEvent;

@Data
public class SubscribeApplicationed extends AbstractEvent {

    private Boolean subscriptionType;
    private Integer price;
    private Long subscriptionId;
    private Long subcriberId;
}
