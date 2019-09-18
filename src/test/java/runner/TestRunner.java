package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json" }, 
				features = "src/test/resources/database-tests", 
				glue = {"rest.a" }, 
				tags = { "@db-test" }, 
				dryRun = false)

public class TestRunner {

}
