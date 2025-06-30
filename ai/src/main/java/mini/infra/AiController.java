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

import java.util.List;
//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping("/ai")
// @RequestMapping(value="/ais")
@Transactional
public class AiController {

    @Autowired
    AiRepository aiRepository;

    @PostMapping("/create")
    public void create(@RequestBody BookInformationRequested dto) {
        Ai.informationcreate(dto);
    }

    @GetMapping("/all")
    public Iterable<Ai> getAllResults() {
        return aiRepository.findAll();
    }
}
//>>> Clean Arch / Inbound Adaptor
