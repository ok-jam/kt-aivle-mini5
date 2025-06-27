package mini.infra;

import javax.transaction.Transactional;
import mini.domain.BookService;
import mini.domain.BookServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
public class BookServiceController {

    private final BookServiceRepository bookServiceRepository;

    // ✅ 생성자 주입
    @Autowired
    public BookServiceController(BookServiceRepository bookServiceRepository) {
        this.bookServiceRepository = bookServiceRepository;
    }

    // 또는 @Autowired 필드 주입을 원한다면 아래처럼만 해도 됩니다:
    // @Autowired
    // BookServiceRepository bookServiceRepository;

    // 예시로 GET API 하나 추가
    @GetMapping("/bookServices")
    public Iterable<BookService> getAllReviews() {
        return bookServiceRepository.findAll();
    }
    @PostMapping("/bookServices")
    public BookService createReview(@RequestBody BookService bookService) {
    return bookServiceRepository.save(bookService);
}

}
