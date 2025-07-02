package mini.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import mini.domain.Book;
import mini.domain.BookRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList; // ✅ 반드시 필요
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookRepository repo;

    // @GetMapping
    // public List<Book> getBooks() {
    //     Iterable<Book> it = repo.findAll(Sort.by(Sort.Direction.DESC, "viewcount"));
    //     List<Book> list = new ArrayList<>();
    //     it.forEach(list::add);
    //     return list;
    // }

    // 책 전체 조회
    @GetMapping
    public List<Book> list() {
    return StreamSupport.stream(repo.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }
}



// package mini.infra;

// import java.util.Optional;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.transaction.Transactional;
// import mini.domain.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// //<<< Clean Arch / Inbound Adaptor

// @RestController
// @RequestMapping(value="/books")
// @Transactional
// public class BookController {

//     @Autowired
//     BookRepository bookRepository;
// }
// //>>> Clean Arch / Inbound Adaptor
