package mini.domain;

import mini.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "포인트", path = "포인트")
public interface 포인트Repository
    extends PagingAndSortingRepository<포인트, String> {}
