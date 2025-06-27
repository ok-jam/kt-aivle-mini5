package mini.domain;

import lombok.*;
import mini.infra.AbstractEvent;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AuthorApproved extends AbstractEvent {

    private Long id;
    private String name;
    private String bio;
    private String portfolioUrl;
    private String status;

    public AuthorApproved(Author author) {
        super(author); // AbstractEvent에 있는 생성자
        this.id = author.getId();
        this.name = author.getName();
        this.bio = author.getBio();
        this.portfolioUrl = author.getPortfolioUrl();
        this.status = author.getStatus();
    }
}
