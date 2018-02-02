package Homework.Module8.patterns.factorymethod;

import Homework.Module8.core.UnknownDriverTypeException;
import Homework.Module8.core.WebDriverTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class Driver {

    private static final String DEFAULT_WEB_DRIVER = "DEFAULT_WEB_DRIVER";

    private static WebDriverTypes defaultDriverType = WebDriverTypes.CHROME;

    private static HashMap<String, WebDriver> instances;


    static {
        instances = new HashMap<String, WebDriver>();
    }

    public WebDriver createDriver(String name, WebDriverTypes type) throws Exception {
        WebDriver driver;
        if (!instances.containsKey(name)) {
            switch (type) {
                case FIREFOX: {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    WebDriverCreator creator = new FirefoxDriverCreator();
                    driver = creator.createDriver();
                    break;
                }
                case CHROME: {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                    WebDriverCreator creator = new ChromeDriverCreator();
                    driver = creator.createDriver();
                    break;
                }
                default:
                    throw new UnknownDriverTypeException("Unknown web driver specified: " + type);
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            instances.put(name, driver);
        } else {
            driver = instances.get(name);
        }
        return driver;
    }

    public static WebDriver getWebDriverInstance(String name) throws Exception {
        return getWebDriverInstance(name, defaultDriverType);
    }

    public static WebDriver getWebDriverInstance(String name, WebDriverTypes defaultDriverType) throws Exception {
        return getWebDriverInstance(DEFAULT_WEB_DRIVER, Driver.defaultDriverType);
    }

    public static void setDefaultWebDriverType(WebDriverTypes type) {
        defaultDriverType = type;
    }

}
