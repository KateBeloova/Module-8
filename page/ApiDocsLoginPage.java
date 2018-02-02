package Homework.Module8.page;

import Homework.Module8.business_objects.User;
import Homework.Module8.patterns.decorator.CustomDriverDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ApiDocsLoginPage extends ApiDocsAbstractPage {

    @FindBy(name = "IDToken1")
    private WebElement login;

    @FindBy(name = "IDToken2")
    private WebElement password;

    @FindBy(xpath = "//div[@class='button_img button_75 button_75_enabled'][contains(text(),'Sign In')]")
    private WebElement tryBtn;

    public ApiDocsLoginPage(WebDriver driver) {
        super(driver);
    }

    public ApiDocsMainPage login(User user) throws InterruptedException {

        driver = new CustomDriverDecorator(driver);
        driver.findElement(By.name("IDToken1"));
        login.sendKeys(user.getLogin());
        password.sendKeys(user.getPassword());
        tryBtn.click();
        tryBtn.click();

        return new ApiDocsMainPage(driver);
    }
}
