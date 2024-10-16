package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateDeveloperGuideCommand {

    private String guideId;
    private String guideTitle;
    private String guideContent;
}
