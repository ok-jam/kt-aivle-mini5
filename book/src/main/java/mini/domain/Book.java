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
import mini.infra.AbstractEvent;


@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    // ──────────────── 기본 필드 ────────────────
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    @Column(length = 9999)
    private String summary;
    @Column(length = 9999)
    private String pdf;
    private Long authorId;
    @Column(length = 9999)
    private String coverImageUrl;
    @Column(length = 9999)
    private String content;
    private Date createdAt;
    private Date publishedAt;
    private Long viewcount;
    private String category;
    private Integer subscriberBill;
    private Boolean bestCheck;

    // ──────────────── 이벤트 발행 (예: 직접 등록 INSERT 시) ────────────────
    @PostPersist
    public void onPostPersist() {
        // 필요에 따라 초기 이벤트 발행 (원한다면 유지, 아니면 주석 처리)
        BookRegistered bookRegistered = new BookRegistered(this);
        bookRegistered.publishAfterCommit();
    }

    // ──────────────── 레포지토리 헬퍼 ────────────────
    public static BookRepository repository() {
        return BookApplication.applicationContext.getBean(BookRepository.class);
    }

    // ──────────────── Port Method #1 : 책 등록 ────────────────
    public static void bookRegistration(RegistrationRequested event) {

        Book book = new Book();
        // ID를 외부에서 주입받지 않는다면 setId 제거!
        book.setTitle(event.getTitle());
        book.setAuthorId(event.getAuthorId());
        book.setCreatedAt(new Date());
        book.setCategory(event.getCategory());
        book.setContent(event.getContent());
        book.setCoverImageUrl(event.getImageUrl());
        book.setSummary(event.getSummary());
        book.setSubscriberBill(event.getSubscriberBill());
        book.setPdf(event.getPdf());
        book.setViewcount(0L);

        repository().save(book);

        // BookRegistered bookRegistered = new BookRegistered(book);
        // bookRegistered.publishAfterCommit();
    }

    // ──────────────── Port Method #2 : 열람 요청 처리 ────────────────
    public static void readingRequest(PointDecreased event) {

        repository().findById(event.getBookId()).ifPresent(book -> {

            // ① 조회수 증가
            long current = book.getViewcount() == null ? 0 : book.getViewcount();
            book.setViewcount(current + 1);
            repository().save(book);

            // ③ 베스트셀러 조건 판단 (5회 이상)
            if (book.getViewcount() >= 5) {
                book.setBestCheck(true);
                BestsellerRegistered bestsellerRegistered = new BestsellerRegistered(book);
                bestsellerRegistered.publishAfterCommit();
            }

            // ② 열람요청됨 이벤트 발행
            ReadingRequested readingRequested = new ReadingRequested(book);
            readingRequested.publishAfterCommit();
        });
    }

    // ──────────────── Port Method #3 : 베스트셀러 등록 요청 ────────────────
    public static void registerBestseller(Long bookId) {
        repository().findById(bookId).ifPresent(book -> {
            if (book.getViewcount() != null && book.getViewcount() >= 5) {
                BestsellerRegistered event = new BestsellerRegistered(book);
                event.publishAfterCommit();
            }
        });
    }
}
//>>> DDD / Aggregate Root
