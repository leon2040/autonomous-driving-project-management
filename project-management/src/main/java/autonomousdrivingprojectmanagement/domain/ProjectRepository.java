package autonomousdrivingprojectmanagement.domain;

import autonomousdrivingprojectmanagement.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectRepository extends JpaRepository<Project, String> {}
