package autonomousdrivingprojectmanagement.domain;

import autonomousdrivingprojectmanagement.EducationSupportApplication;
import autonomousdrivingprojectmanagement.domain.EducationScheduleManaged;
import autonomousdrivingprojectmanagement.domain.FeedbackGiven;
import autonomousdrivingprojectmanagement.domain.LearningMaterialsProvided;
import autonomousdrivingprojectmanagement.domain.LearningProgressAssessed;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "Education_table")
@Data
//<<< DDD / Aggregate Root
public class Education {

    @Id
    private String educationId;

    private String schedule;

    @ElementCollection
    private List<String> materials;

    private String progress;

    @PostPersist
    public void onPostPersist() {
        EducationScheduleManaged educationScheduleManaged = new EducationScheduleManaged(
            this
        );
        educationScheduleManaged.publishAfterCommit();

        LearningMaterialsProvided learningMaterialsProvided = new LearningMaterialsProvided(
            this
        );
        learningMaterialsProvided.publishAfterCommit();

        LearningProgressAssessed learningProgressAssessed = new LearningProgressAssessed(
            this
        );
        learningProgressAssessed.publishAfterCommit();

        FeedbackGiven feedbackGiven = new FeedbackGiven(this);
        feedbackGiven.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static EducationRepository repository() {
        EducationRepository educationRepository = EducationSupportApplication.applicationContext.getBean(
            EducationRepository.class
        );
        return educationRepository;
    }
}
//>>> DDD / Aggregate Root
