package Homework.Module8.service;

import Homework.Module8.business_objects.User;

import Homework.Module8.page.ApiDocsLoginPage;
import Homework.Module8.patterns.factorymethod.ChromeDriverCreator;
import Homework.Module8.patterns.factorymethod.WebDriverCreator;
import Homework.Module8.patterns.singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;


public class Servise {

    public boolean loginToMail(User user) throws Exception {
        WebDriverCreator creator = new ChromeDriverCreator();
        WebDriver driver = creator.createDriver();
        ApiDocsLoginPage screen = new ApiDocsLoginPage (WebDriverSingleton.getWebDriverInstance());
        return screen.login(user).isSearchItemDisplayed();
    }
}
