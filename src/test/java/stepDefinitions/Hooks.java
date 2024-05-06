package stepDefinitions;

import config.BaseConfig;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.driver.driverManager.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Hooks {
    public static WebDriver driver;

    @Before()
    public void chromeSetUp(Scenario scenario) {
        String browser = BaseConfig.getInstance().getBrowser();
        Driver.getInstance().setDriver(browser);
        driver = Driver.getInstance().getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void takeScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            Object driver = Driver.getInstance().getDriver();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            String timestamp = dtf.format(now);
            String screenshotName = scenario.getName()+ "-" + timestamp + ".png";
            String screenshotFolderPath = "screenshots/";
            createFolder(screenshotFolderPath);
            String screenshotPath = screenshotFolderPath + screenshotName;
            saveScreenshot(screenshot, screenshotPath);
            Allure.addAttachment("Page Screenshot: ", FileUtils.openInputStream(screenshot));
        }
        Driver.getInstance().getDriver().quit();
    }

    private void createFolder(String folderPath) {
        try {
            Path path = Paths.get(folderPath);
            Files.createDirectories(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveScreenshot(File screenshot, String screenshotPath) {
        try {
            Files.write(Paths.get(screenshotPath), Files.readAllBytes(screenshot.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeStep()
    public void actionBeforeEachStep() {
    }


    @AfterStep()
    public void actionPostEachStep() {
    }
}
