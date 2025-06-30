@RestController
@Transactional
public class BookServiceController {

    private final BookServiceRepository bookServiceRepository;

    @Autowired
    public BookServiceController(BookServiceRepository bookServiceRepository) {
        this.bookServiceRepository = bookServiceRepository;
    }

    @GetMapping("/bookServices")
    public Iterable<BookService> getAllReviews() {
        return bookServiceRepository.findAll();
    }

    @PostMapping("/bookServices")
    public BookService createReview(@RequestBody BookService bookService) {
        return bookServiceRepository.save(bookService);
    }

    // ✅ 찜하기 API 추가
    @PostMapping("/bookServices/{id}/like")
    public BookService addLike(@PathVariable Long id) {
        BookService bookService = bookServiceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));

        bookService.addLike(); // 👍 찜 수 증가 + 이벤트 발행
        return bookServiceRepository.save(bookService);
    }
}
