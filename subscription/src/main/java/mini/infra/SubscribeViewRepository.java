package mini.infra;

import java.util.List;
import java.util.Optional;

import mini.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "subscribeViews",
    path = "subscribeViews"
)
public interface SubscribeViewRepository
    extends PagingAndSortingRepository<SubscribeView, Long> {
        Optional<SubscribeView> findByBookId(Long bookId);
        Optional<SubscribeView> findBySubscriptionId(Long subscriptionId);
    }
