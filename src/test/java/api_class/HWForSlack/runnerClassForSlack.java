package api_class.HWForSlack;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features2/slackMessage.feature",
glue = "api_class/HWForSlack",
tags = "@PositiveTestingMessagesSlack",
dryRun = false)
public class runnerClassForSlack {
}
