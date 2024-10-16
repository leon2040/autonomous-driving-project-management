package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteDeveloperGuideCommand {

    private String guideId;
}
