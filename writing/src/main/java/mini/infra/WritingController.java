package mini.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import mini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping(value="/writings")
@Transactional
public class WritingController {

    @Autowired
    WritingRepository writingRepository;

    @PostMapping("/bookinfo")
    public Writing requestBookInfo(@RequestBody Writing writing) {
        Writing saved = writingRepository.save(writing);

        BookInformationRequested bookInformationRequested = new BookInformationRequested(saved);
        bookInformationRequested.publishAfterCommit();

        return saved;
    }


    @PostMapping("/savebooked")
    public Writing saveBooked(@RequestBody Writing writing) {
        Writing saved = writingRepository.save(writing);

        SaveBooked saveBooked = new SaveBooked(saved);
        saveBooked.publishAfterCommit();

        return saved;
    }

    @PostMapping("/register")
    public Writing register(@RequestBody Writing writing) {
        Writing saved = writingRepository.save(writing);

        return saved;
    }
}
//>>> Clean Arch / Inbound Adaptor
