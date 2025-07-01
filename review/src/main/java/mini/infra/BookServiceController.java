import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import mini.domain.BookService;
import mini.domain.BookServiceRepository;

@RestController
@RequestMapping(value="/bookServices")
@Transactional
public class BookServiceController {

    private final BookServiceRepository bookServiceRepository;

    @Autowired
    public BookServiceController(BookServiceRepository bookServiceRepository) {
        this.bookServiceRepository = bookServiceRepository;
    }

    // @GetMapping("/bookServices")
    public Iterable<BookService> getAllReviews() {
        return bookServiceRepository.findAll();
    }

    // @PostMapping("/bookServices")
    public BookService createReview(@RequestBody BookService bookService) {
        return bookServiceRepository.save(bookService);
    }

}
