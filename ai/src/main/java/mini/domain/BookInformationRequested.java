package mini.domain;

import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

@Data
@ToString
public class BookInformationRequested extends AbstractEvent {

    private String writingId;
    private String title;
    private String content;
    private String category;
    private Long authorId;
    private String status;
    private Date permitSaveAt;
    private String imageUrl;
    private Integer subscriberBill;
}
