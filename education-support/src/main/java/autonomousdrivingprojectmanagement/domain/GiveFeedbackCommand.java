package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GiveFeedbackCommand {

    private String educationId;
    private String feedback;
}
