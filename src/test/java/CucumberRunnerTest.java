import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestExecutionListeners;
import spring.CustomTestExecutionListener;

@RunWith(Cucumber.class)
@TestExecutionListeners(value = CustomTestExecutionListener.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = "steps",
		plugin = {
				"pretty", 
				"html:target/cucumber"
		}) 
public class CucumberRunnerTest {

}
