package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ManageEducationScheduleCommand {

    private String educationId;
    private String schedule;
}
