package mini.domain;

import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

@Data
@ToString
public class SubscribeApplicationed extends AbstractEvent {

    private Boolean subscriptionType;
    private Integer price;
    private Long subscriptionId;
    private Long subscriberId;
    private Long bookId;
}
