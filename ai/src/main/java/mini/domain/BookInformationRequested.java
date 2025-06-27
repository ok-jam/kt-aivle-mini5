package mini.domain;

import java.util.*;
import lombok.*;
import mini.domain.*;
import mini.infra.AbstractEvent;

@Data
@ToString
public class BookInformationRequested extends AbstractEvent {

    private Long writingId;
    private String title;
    private String content;
    private String category;

}
