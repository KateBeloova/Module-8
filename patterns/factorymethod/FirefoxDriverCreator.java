package Homework.Module8.patterns.factorymethod;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class FirefoxDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver createDriver() {
        FirefoxBinary binary = new FirefoxBinary(new File("c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
        FirefoxOptions options = new FirefoxOptions().setBinary(binary);
        FirefoxProfile profile = new FirefoxProfile(new File(
                "c:\\Users\\User_Name\\Documents\\FF_custom_profile\\"));
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        return driver;
    }
}
