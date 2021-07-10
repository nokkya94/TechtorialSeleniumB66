package cucumber_class.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/amazonSumPhones.feature",
glue = "cucumber_class/stepDefinition",
tags = "@results or @prices",
snippets = CucumberOptions.SnippetType.CAMELCASE)
public class amazonRunner {
}
