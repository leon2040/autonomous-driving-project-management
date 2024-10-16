package autonomousdrivingprojectmanagement.infra;

import autonomousdrivingprojectmanagement.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeveloperGuideHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeveloperGuide>> {

    @Override
    public EntityModel<DeveloperGuide> process(
        EntityModel<DeveloperGuide> model
    ) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
