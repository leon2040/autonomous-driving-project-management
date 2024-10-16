package autonomousdrivingprojectmanagement.common;

import autonomousdrivingprojectmanagement.DevelopmentGuideApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DevelopmentGuideApplication.class })
public class CucumberSpingConfiguration {}
