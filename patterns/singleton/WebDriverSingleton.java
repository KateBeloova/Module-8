package Homework.Module8.patterns.singleton;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\ATM\\Homework\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
