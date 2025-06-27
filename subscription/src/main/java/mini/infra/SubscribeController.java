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
// @RequestMapping(value="/subscribes")
@Transactional
public class SubscribeController {

    @Autowired
    SubscribeRepository subscribeRepository;
    @PostMapping
    public Subscribe apply(@RequestBody Subscribe request) {

        request.setStatus("APPLIED");
        request.setStartDate(new Date());

        // 단일 열람: 3일 정도로 설정
        Date endDate = new Date(System.currentTimeMillis() + 3L * 24 * 60 * 60 * 1000);
        request.setEndDate(endDate);

        Subscribe saved = subscribeRepository.save(request);

        // 이벤트 발행
        SubscribeApplicationed event = new SubscribeApplicationed(saved);
        event.publish();

        return saved;
    }
}
//>>> Clean Arch / Inbound Adaptor
