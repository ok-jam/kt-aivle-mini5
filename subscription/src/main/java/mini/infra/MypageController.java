package mini.infra;

import mini.domain.Mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageRepository repo;

    /** 특정 구독자(userId)의 모든 구독 이력 조회 */
    @GetMapping("/user/{userId}")
    public List<Mypage> getByUserId(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    
    }
}