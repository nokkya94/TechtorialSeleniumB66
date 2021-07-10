package cucumber_class.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features2/GotApiTitleSize.feature",
glue = "cucumber_class/stepDefinition",
tags = "@GetSize",
dryRun = false)
public class APItestRunner {
}
