package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.driver.driverManager.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageHelper {

    static Actions actions = new Actions(Driver.getInstance().getDriver());
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        PageHelper.driver = driver;
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public static void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public static String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public static String getAttribute(By locator, String attributeName) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attributeName);
    }

    public static boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public static void swipeElement(By locator, int xOffset, int yOffset) {
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
    }

    public static void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement sourceElement = driver.findElement(sourceLocator);
        WebElement targetElement = driver.findElement(targetLocator);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();
    }

    public static void doubleClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.doubleClick(element).build().perform();
    }

    public static void rightClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        actions.contextClick(element).build().perform();
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getInstance().getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void scrollDownJavascript(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance().getDriver();
        js.executeScript("window.scrollBy", x, y);
    }

    public static void pageDown() {
        actions = new Actions(Driver.getInstance().getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
}
