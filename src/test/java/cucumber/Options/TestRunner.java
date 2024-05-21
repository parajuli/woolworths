package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/SearchApi.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/report/cucumber.html", "json:target/report/cucumber.json"}
)
public class TestRunner {
	
}