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
import java.util.Date;
import java.util.Map;

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping(value="/point")
@Transactional
public class PointController {

    @Autowired
    PointRepository pointRepository;

    @PostMapping("/charge/{id}")
    public String chargePoint(@PathVariable("id") String userId, @RequestBody Map<String, Object> body) {
        Long amount = Long.valueOf(body.get("amount").toString());

        Optional<Point> optionalPoint = pointRepository.findById(userId);

        if (optionalPoint.isPresent()) {
            Point point = optionalPoint.get();
            Long newBalance = point.getBalance() + amount;

            point.setBalance(newBalance);
            point.setHistory("Charge: +" + amount + "P");
            point.setUpdateAt(new Date());

            pointRepository.save(point);
            return "충전 완료: 현재 잔액 = " + newBalance + "P";
        } else {
            return "해당 유저의 포인트 정보가 없습니다.";
        }
    }
}

//>>> Clean Arch / Inbound Adaptor
