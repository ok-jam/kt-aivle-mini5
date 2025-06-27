package mini.infra;

import mini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BookServiceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<BookService>> {

    @Override
    public EntityModel<BookService> process(EntityModel<BookService> model) {
        return model;
    }
}
