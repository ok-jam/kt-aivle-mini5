package mini.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import mini.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping("/subscribes")
@RequiredArgsConstructor
public class SubscribeController {

    private final SubscribeRepository subscribeRepository;

    @PostMapping
    public Subscribe apply(@RequestBody Subscribe subscribe) {
        return subscribeRepository.save(subscribe);
    }
}
//>>> Clean Arch / Inbound Adaptor
