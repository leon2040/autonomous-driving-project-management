package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateTaskAssignmentCommand {

    private String projectId;
    private String taskId;
    private String developer;
    private String task;
}
