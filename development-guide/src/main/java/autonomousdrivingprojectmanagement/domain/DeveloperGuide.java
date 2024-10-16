package autonomousdrivingprojectmanagement.domain;

import autonomousdrivingprojectmanagement.DevelopmentGuideApplication;
import autonomousdrivingprojectmanagement.domain.DeveloperGuideDeleted;
import autonomousdrivingprojectmanagement.domain.DeveloperGuideRegistered;
import autonomousdrivingprojectmanagement.domain.NewGuideCreated;
import autonomousdrivingprojectmanagement.domain.QuestionAnswered;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "DeveloperGuide_table")
@Data
//<<< DDD / Aggregate Root
public class DeveloperGuide {

    @Id
    private String guideId;

    private String guideTitle;

    private String guideContent;

    @PostPersist
    public void onPostPersist() {
        DeveloperGuideRegistered developerGuideRegistered = new DeveloperGuideRegistered(
            this
        );
        developerGuideRegistered.publishAfterCommit();

        DeveloperGuideDeleted developerGuideDeleted = new DeveloperGuideDeleted(
            this
        );
        developerGuideDeleted.publishAfterCommit();

        NewGuideCreated newGuideCreated = new NewGuideCreated(this);
        newGuideCreated.publishAfterCommit();

        QuestionAnswered questionAnswered = new QuestionAnswered(this);
        questionAnswered.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static DeveloperGuideRepository repository() {
        DeveloperGuideRepository developerGuideRepository = DevelopmentGuideApplication.applicationContext.getBean(
            DeveloperGuideRepository.class
        );
        return developerGuideRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateDeveloperGuide(
        UpdateDeveloperGuideCommand updateDeveloperGuideCommand
    ) {
        //implement business logic here:

        DeveloperGuideUpdated developerGuideUpdated = new DeveloperGuideUpdated(
            this
        );
        developerGuideUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
