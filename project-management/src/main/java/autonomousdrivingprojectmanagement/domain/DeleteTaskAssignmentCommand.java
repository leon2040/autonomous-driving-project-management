package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteTaskAssignmentCommand {

    private String projectId;
    private String taskId;
}
