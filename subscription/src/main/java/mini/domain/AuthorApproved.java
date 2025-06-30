package mini.domain;

import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

@Data
@ToString
public class AuthorApproved extends AbstractEvent {

    private Long id;
    private String name;
    private String bio;
    private String portfolioUrl;
    private String status;
    private Date createdAt;
    private Date updateAt;
}
