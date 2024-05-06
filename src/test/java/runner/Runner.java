package runner;

import config.BaseConfig;
import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.annotations.*;

@CucumberOptions(features = "src/test/resources",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "rerun:target/failed.txt"})
public class Runner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
    }

    @AfterSuite
    public void afterSuite() {
    }

    @BeforeClass
    public void beforeClass(ITestContext context) {
        String threadCount = BaseConfig.getInstance().getThreadCount();
        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.parseInt(threadCount));
    }

    @AfterClass
    public void afterClass() {
    }
}
