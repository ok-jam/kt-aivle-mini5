package mini.infra;

import mini.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class 포인트HateoasProcessor
    implements RepresentationModelProcessor<EntityModel<포인트>> {

    @Override
    public EntityModel<포인트> process(EntityModel<포인트> model) {
        return model;
    }
}
