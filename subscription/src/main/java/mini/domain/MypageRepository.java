package mini.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MypageRepository 
    extends PagingAndSortingRepository<Mypage, Long> {
        List<Mypage> findByUserId(Long userId);
}