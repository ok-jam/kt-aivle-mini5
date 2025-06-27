package mini.domain;

import mini.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "point", path = "point")
public interface PointRepository
    extends PagingAndSortingRepository<Point, String> {}
