package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import mini.BookApplication;
import mini.domain.BestsellerRegistered;
import mini.domain.BookRegistered;
import mini.domain.ReadingRequested;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String summary;

    private Long authorId;

    private String coverImageUrl;

    private String content;

    private Date createdAt;

    private Date publishedAt;

    private Long viewcount;

    private String category;

    private Integer subscriberBill;

    @PostPersist
    public void onPostPersist() {
        BestsellerRegistered bestsellerRegistered = new BestsellerRegistered(
            this
        );
        bestsellerRegistered.publishAfterCommit();

        BookRegistered bookRegistered = new BookRegistered(this);
        bookRegistered.publishAfterCommit();

        ReadingRequested readingRequested = new ReadingRequested(this);
        readingRequested.publishAfterCommit();
    }

    public static BookRepository repository() {
        BookRepository bookRepository = BookApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public static void bookRegistration(
        RegistrationRequested registrationRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookRegistered bookRegistered = new BookRegistered(book);
        bookRegistered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(registrationRequested.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookRegistered bookRegistered = new BookRegistered(book);
            bookRegistered.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void readingRequest(PointDecreased pointDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        ReadingRequested readingRequested = new ReadingRequested(book);
        readingRequested.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(pointDecreased.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            ReadingRequested readingRequested = new ReadingRequested(book);
            readingRequested.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
