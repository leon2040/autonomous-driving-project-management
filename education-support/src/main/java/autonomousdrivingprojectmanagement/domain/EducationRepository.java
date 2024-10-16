package autonomousdrivingprojectmanagement.domain;

import autonomousdrivingprojectmanagement.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "educations",
    path = "educations"
)
public interface EducationRepository extends JpaRepository<Education, String> {}
