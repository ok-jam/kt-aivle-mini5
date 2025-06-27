package mini.domain;

import java.util.Date;
import java.util.List;
import mini.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "subscribers",
    path = "subscribers"
)
public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{
    List<Subscriber> findBySubscriptionType(String type);

    @Query("SELECT s FROM Subscriber s WHERE s.ktTelecom = true")
    List<Subscriber> findKtSubscribers();

}
