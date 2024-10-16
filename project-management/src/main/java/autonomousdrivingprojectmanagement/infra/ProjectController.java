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
// @RequestMapping(value="/projects")
@Transactional
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(
        value = "projects/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Project updateProjectInfo(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateProjectInfoCommand updateProjectInfoCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /project/updateProjectInfo  called #####");
        Optional<Project> optionalProject = projectRepository.findById(id);

        optionalProject.orElseThrow(() -> new Exception("No Entity Found"));
        Project project = optionalProject.get();
        project.updateProjectInfo(updateProjectInfoCommand);

        projectRepository.save(project);
        return project;
    }

    @RequestMapping(
        value = "projects/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Project updateTaskAssignment(
        @PathVariable(value = "id") String id,
        @RequestBody UpdateTaskAssignmentCommand updateTaskAssignmentCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /project/updateTaskAssignment  called #####");
        Optional<Project> optionalProject = projectRepository.findById(id);

        optionalProject.orElseThrow(() -> new Exception("No Entity Found"));
        Project project = optionalProject.get();
        project.updateTaskAssignment(updateTaskAssignmentCommand);

        projectRepository.save(project);
        return project;
    }
}
//>>> Clean Arch / Inbound Adaptor
