package utils.driver.driverManager;

import utils.driver.browserManager.BrowserManager;
import org.openqa.selenium.WebDriver;

public class Driver {
    private static Driver INSTANCE;

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {

    }

    public static synchronized Driver getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new Driver();

        }
        return INSTANCE;
    }

    public void setDriver(String browser) {
        driver.set(BrowserManager.getDriver(browser));
    }

    public WebDriver getDriver() {
        return driver.get();
    }

}
