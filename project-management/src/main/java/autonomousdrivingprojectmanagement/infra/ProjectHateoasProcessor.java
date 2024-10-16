package autonomousdrivingprojectmanagement.infra;

import autonomousdrivingprojectmanagement.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProjectHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Project>> {

    @Override
    public EntityModel<Project> process(EntityModel<Project> model) {
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );
        model.add(
            Link.of(model.getRequiredLink("self").getHref() + "/").withRel("")
        );

        return model;
    }
}
