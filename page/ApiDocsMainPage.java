package Homework.Module8.page;

import Homework.Module8.patterns.factorymethod.Driver;
import Homework.Module8.patterns.singleton.WebDriverSingleton;
import Homework.Module8.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApiDocsMainPage extends ApiDocsAbstractPage {

    private static final String API_LINK = "//a[@class='category-api-item ng-binding'][contains(text(),'/news-subscriptions')]";

    @FindBy(xpath = API_LINK)
    private WebElement apiLink;

    @FindBy(xpath = "//a[@class='category-api-item ng-binding'][contains(text(),'/definitions')]")
    private WebElement apiList;

    public ApiDocsMainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchItemDisplayed() {
        new WebDriverWait(WebDriverSingleton.getWebDriverInstance(), 50).until(ExpectedConditions.visibilityOf(apiLink));
        return apiLink.isDisplayed();
    }

    public void DocsRequest(String apiName){

        Utils.highlightElement(apiList);
        this.apiList.click();
    }
}
