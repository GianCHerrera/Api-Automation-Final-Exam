package base;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * The type Cucumber suite test.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = "classpath:steps",
        features = "classpath:features"
)
public class CucumberSuiteTest {

}
