package mini.infra;

import mini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class WritingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Writing>> {

    @Override
    public EntityModel<Writing> process(EntityModel<Writing> model) {
        return model;
    }
}
