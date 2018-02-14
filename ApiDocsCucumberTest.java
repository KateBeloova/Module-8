package Homework.Module8;


import Homework.Module8.patterns.singleton.WebDriverSingleton;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, tags = "@smokeTest", features = "src/test/resources/cucumber_features/github_basic.feature", glue = {
        "com.epam.byta.frameworks.demo.steps" })

public class ApiDocsCucumberTest extends AbstractTestNGCucumberTests {
    private static WebDriver driver = WebDriverSingleton.getWebDriverInstance();

    @BeforeClass(description = "Start browser, add implicit wait and maximize window")
    public void startBrowser() {
        // set a certain implicit wait timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Maximize browser window
        driver.manage().window().maximize();
    }
}