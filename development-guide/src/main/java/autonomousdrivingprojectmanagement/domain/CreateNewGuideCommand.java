package autonomousdrivingprojectmanagement.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateNewGuideCommand {

    private String guideId;
    private String guideTitle;
    private String guideContent;
}