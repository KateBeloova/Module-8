package Homework.Module8.patterns.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

public class ChromeDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver createDriver() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File("D:\\ATM\\Homework\\chromedriver.exe")).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver(service);
        return driver;
    }
}
