package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterProjectInfoCommand {

    private String projectId;
    private String projectName;
    private String projectInfo;
}
