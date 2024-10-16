package autonomousdrivingprojectmanagement.domain;

import autonomousdrivingprojectmanagement.domain.*;
import autonomousdrivingprojectmanagement.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PerformanceChecked extends AbstractEvent {

    private String projectId;
}
