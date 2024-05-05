package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed.txt",
        glue = {"stepDefinitions", "hooks"},
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class FailedRunner extends AbstractTestNGCucumberTests {
}
