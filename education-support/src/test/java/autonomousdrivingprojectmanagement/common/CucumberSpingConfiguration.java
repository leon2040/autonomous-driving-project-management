package autonomousdrivingprojectmanagement.common;

import autonomousdrivingprojectmanagement.EducationSupportApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { EducationSupportApplication.class })
public class CucumberSpingConfiguration {}
