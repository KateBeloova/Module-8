package Homework.Module8.steps;

import Homework.Module8.business_objects.User;
import Homework.Module8.page.ApiDocsLoginPage;
import Homework.Module8.page.ApiDocsMainPage;
import Homework.Module8.patterns.singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApiDocsLoginSteps {
    private static WebDriver driver = WebDriverSingleton.getWebDriverInstance();
    private static final String START_URL = "https://amers1.apps.cp.reutest.com/Apps/APIDocs/1.726.1/#/";

    @Given("^user navigates to ApiDocs home page$")
    public void apiDocsLoginPage() {
        driver.get(START_URL);
    }

    @When("^enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void enter_user_credentials() {
        new ApiDocsLoginPage(driver).login(User);

    }

    @Then("^ApiDocs main page is displayed$")
    public void login_succesfully() {
        Assert.assertTrue(new ApiDocsMainPage(driver).isSearchItemDisplayed(), "Authentication is failed");
        System.out.println("Login was completed correctly.");

    }
}