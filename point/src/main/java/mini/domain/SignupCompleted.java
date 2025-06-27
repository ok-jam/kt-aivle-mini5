package mini.domain;

import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

@Data
@ToString
public class SignupCompleted extends AbstractEvent {

    private Long subscriberId;
    private Boolean kttelecom;
    private Boolean subscriptionType;
    private String name;
    private String email;
    private String password;
    private Date joinedAt;
    private Long jjim;
    private Long reviews;
}
