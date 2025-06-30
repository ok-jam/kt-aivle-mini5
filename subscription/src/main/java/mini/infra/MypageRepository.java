package mini.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MypageRepository 
    extends PagingAndSortingRepository<Mypage, Long> {

}