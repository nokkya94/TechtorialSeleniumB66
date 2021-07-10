package cucumber_class.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/OpeMRS.feature",
        glue = "cucumber_class/stepDefinition",
        tags = "@negativeLogIn",
        dryRun = false,
        plugin = {"pretty","html:target/mrs.html","json:target/mrs.json","junit:target/mrs.xml"}
        )

public class OpenMRSRunner {

}
