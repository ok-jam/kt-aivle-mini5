package mini.domain;

import java.util.Date;
import java.util.List;
import mini.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel="sub", path="sub")
public interface SubscribeRepository
    extends PagingAndSortingRepository<Subscribe, Long> {
        
    }
