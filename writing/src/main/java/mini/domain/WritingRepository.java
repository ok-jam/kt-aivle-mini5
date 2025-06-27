package mini.domain;

import mini.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "writings", path = "writings")
public interface WritingRepository
    extends PagingAndSortingRepository<Writing, String> {}
