package pages;

import config.BaseConfig;
import org.openqa.selenium.support.PageFactory;
import utils.driver.driverManager.Driver;


public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
    }

    public void HomePage(){
        String url = System.getProperty("base.url") != null ? System.getProperty("base.url") : BaseConfig.getInstance().getUrl();
        Driver.getInstance().getDriver().get(url);
    }

}