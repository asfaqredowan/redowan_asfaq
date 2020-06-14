package Day17_06132020.Cucumber.Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Day17_06132020/Cucumber/Features/Google_Test.feature"},
        glue = {"Day17_06132020.Cucumber.Step_Definitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
)//Array of arguments you are passing

public class GoogleRunner {

    /** this os gonna be empty */

}
