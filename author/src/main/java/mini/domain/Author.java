package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.AuthorApplication;
import mini.domain.AuthorApproved;
import mini.domain.AuthorDeleted;
import mini.domain.AuthorDisapproved;

@Entity
@Table(name = "Author_table")
@Data
//<<< DDD / Aggregate Root
public class Author {

    @Id
    private Long id;

    private String name;

    private String bio;

    private String portfolioUrl;

    private String status;

    private Date createdAt;

    private Date updateAt;

    @PostPersist
    public void onPostPersist() {
    }

    public static AuthorRepository repository() {
        AuthorRepository authorRepository = AuthorApplication.applicationContext.getBean(
            AuthorRepository.class
        );
        return authorRepository;
    }
}
//>>> DDD / Aggregate Root
