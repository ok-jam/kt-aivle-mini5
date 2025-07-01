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
import org.springframework.http.ResponseEntity;
import java.util.Date;

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

    @PostMapping("/register")
    public Writing register(@RequestBody Writing writing) {
        Writing saved = writingRepository.save(writing);

        RegistrationRequested event = new RegistrationRequested(saved);
        event.publishAfterCommit();

        return saved;
    }

    @GetMapping("/{id}/register")
    public ResponseEntity<?> register(@PathVariable Long id) {
        Optional<Writing> optionalWriting = writingRepository.findById(id);
        if (!optionalWriting.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Writing writing = optionalWriting.get();

        RegistrationRequested event = new RegistrationRequested(writing);
        event.publishAfterCommit();

        return ResponseEntity.ok("등록 요청 이벤트 발행됨");
    }

    @PutMapping("/writings/{id}")
    public ResponseEntity<?> tempSave(
        @PathVariable Long id,
        @RequestBody Writing request
    ) {
        Writing writing = Writing.repository().findById(id)
            .orElseThrow(() -> new RuntimeException("해당 집필이 존재하지 않습니다."));

        // 필요한 필드만 덮어쓰기
        writing.setTitle(request.getTitle());
        writing.setContent(request.getContent());
        writing.setCategory(request.getCategory());
        writing.setSummary(request.getSummary());
        writing.setImageUrl(request.getImageUrl());
        writing.setPdf(request.getPdf());
        writing.setSubscriberBill(request.getSubscriberBill());

        writing.setStatus("TEMP");
        writing.setPermitSaveAt(new Date());

        Writing.repository().save(writing);

        return ResponseEntity.ok("임시 저장되었습니다.");
    }
}
//>>> Clean Arch / Inbound Adaptor
