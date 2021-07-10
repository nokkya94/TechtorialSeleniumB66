package HomeworkSelenium_Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features2/espocrm.feature",
glue = "HomeworkSelenium_Cucumber",
tags = "@acceptance_criteria2",
dryRun = false

)
public class runnerClass {
}
