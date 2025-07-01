package mini.infra;

import lombok.RequiredArgsConstructor;
import mini.domain.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/authors")
@Transactional
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    // 작가 등록
    @PostMapping
    public Author register(@RequestBody Author author) {
        author.setStatus("PENDING");
        author.setCreatedAt(new Date());
        author.setUpdateAt(new Date());
        Author saved = authorRepository.save(author);

        new AuthorRegistered(saved).publishAfterCommit();
        return saved;
    }

    // 작가 전체 조회
    @GetMapping
    public List<Author> list() {
    return StreamSupport.stream(authorRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    // 작가 승인
    @PutMapping("/{id}/approve")
    public Author approve(@PathVariable Long id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setStatus("APPROVED");
        author.setUpdateAt(new Date());
        Author saved = authorRepository.save(author);

        new AuthorApproved(saved).publishAfterCommit();
        return saved;
    }

    // 작가 반려
    @PutMapping("/{id}/reject")
    public Author disapprove(@PathVariable Long id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setStatus("REJECTED");
        author.setUpdateAt(new Date());
        Author saved = authorRepository.save(author);

        new AuthorDisapproved(saved).publishAfterCommit();
        return saved;
    }

    // 작가 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Author not found"));

        authorRepository.delete(author);
        new AuthorDeleted(author).publishAfterCommit();
    }
}
