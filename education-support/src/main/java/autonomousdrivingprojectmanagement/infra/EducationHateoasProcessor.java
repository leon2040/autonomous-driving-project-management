package autonomousdrivingprojectmanagement.infra;

import autonomousdrivingprojectmanagement.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class EducationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Education>> {

    @Override
    public EntityModel<Education> process(EntityModel<Education> model) {
        return model;
    }
}
