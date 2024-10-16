package autonomousdrivingprojectmanagement.infra;

import autonomousdrivingprojectmanagement.domain.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/developerGuides")
@Transactional
public class DeveloperGuideController {

    @Autowired
    DeveloperGuideRepository developerGuideRepository;

    @RequestMapping(
        value = "developerGuides/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DeveloperGuide updateDeveloperGuide(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateDeveloperGuideCommand updateDeveloperGuideCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /developerGuide/updateDeveloperGuide  called #####"
        );
        Optional<DeveloperGuide> optionalDeveloperGuide = developerGuideRepository.findById(
            id
        );

        optionalDeveloperGuide.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        DeveloperGuide developerGuide = optionalDeveloperGuide.get();
        developerGuide.updateDeveloperGuide(updateDeveloperGuideCommand);

        developerGuideRepository.save(developerGuide);
        return developerGuide;
    }
}
//>>> Clean Arch / Inbound Adaptor
