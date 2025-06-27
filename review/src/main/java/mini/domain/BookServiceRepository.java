package mini.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "bookServices",
    path = "bookServices"
)
public interface BookServiceRepository extends PagingAndSortingRepository<BookService, Long> {
}
//>>> PoEAA / Repository
