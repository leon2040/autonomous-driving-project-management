package autonomousdrivingprojectmanagement.domain;

import autonomousdrivingprojectmanagement.ProjectManagementApplication;
import autonomousdrivingprojectmanagement.domain.FeedbackProvided;
import autonomousdrivingprojectmanagement.domain.PerformanceChecked;
import autonomousdrivingprojectmanagement.domain.ProjectInfoDeleted;
import autonomousdrivingprojectmanagement.domain.ProjectInfoRegistered;
import autonomousdrivingprojectmanagement.domain.ProjectProgressMonitored;
import autonomousdrivingprojectmanagement.domain.TeamAssignmentCreated;
import autonomousdrivingprojectmanagement.domain.TeamAssignmentDeleted;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "Project_table")
@Data
//<<< DDD / Aggregate Root
public class Project {

    @Id
    private String projectId;

    private String projectName;

    private String projectInfo;

    @ElementCollection
    private List<String> teamMembers;

    private List<TaskAssignment> taskAssignments;

    @PostPersist
    public void onPostPersist() {
        ProjectInfoRegistered projectInfoRegistered = new ProjectInfoRegistered(
            this
        );
        projectInfoRegistered.publishAfterCommit();

        ProjectInfoDeleted projectInfoDeleted = new ProjectInfoDeleted(this);
        projectInfoDeleted.publishAfterCommit();

        TeamAssignmentCreated teamAssignmentCreated = new TeamAssignmentCreated(
            this
        );
        teamAssignmentCreated.publishAfterCommit();

        TeamAssignmentDeleted teamAssignmentDeleted = new TeamAssignmentDeleted(
            this
        );
        teamAssignmentDeleted.publishAfterCommit();

        ProjectProgressMonitored projectProgressMonitored = new ProjectProgressMonitored(
            this
        );
        projectProgressMonitored.publishAfterCommit();

        PerformanceChecked performanceChecked = new PerformanceChecked(this);
        performanceChecked.publishAfterCommit();

        FeedbackProvided feedbackProvided = new FeedbackProvided(this);
        feedbackProvided.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ProjectRepository repository() {
        ProjectRepository projectRepository = ProjectManagementApplication.applicationContext.getBean(
            ProjectRepository.class
        );
        return projectRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateProjectInfo(
        UpdateProjectInfoCommand updateProjectInfoCommand
    ) {
        //implement business logic here:

        ProjectInfoUpdated projectInfoUpdated = new ProjectInfoUpdated(this);
        projectInfoUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void updateTaskAssignment(
        UpdateTaskAssignmentCommand updateTaskAssignmentCommand
    ) {
        //implement business logic here:

        TeamAssignmentUpdated teamAssignmentUpdated = new TeamAssignmentUpdated(
            this
        );
        teamAssignmentUpdated.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
