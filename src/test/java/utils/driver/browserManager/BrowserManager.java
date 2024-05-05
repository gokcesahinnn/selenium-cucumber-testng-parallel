package utils.driver.browserManager;

import config.BaseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManager {

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                if (BaseConfig.getInstance().getHeadless()) ops.addArguments("--headless");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(ops);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                ChromeOptions defaultOps = new ChromeOptions();
                defaultOps.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(defaultOps);
        }
    }

}
