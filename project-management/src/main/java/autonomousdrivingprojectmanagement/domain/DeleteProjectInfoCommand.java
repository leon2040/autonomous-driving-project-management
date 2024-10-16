package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteProjectInfoCommand {

    private String projectId;
}
