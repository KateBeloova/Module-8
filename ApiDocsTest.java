package Homework.Module8;

import Homework.Module8.business_objects.User;
import Homework.Module8.patterns.singleton.WebDriverSingleton;
import Homework.Module8.service.Servise;
import Homework.Module8.util.Utils;
import Homework.pagefactory.ApiDocsMainPage;
import Homework.pagefactory.RequestDocsPage;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ApiDocsTest {

    private static final String APIDOCS_URL = "https://amers1.apps.cp.reutest.com/Apps/APIDocs/1.726.1/#/";
    private static final String DOCSAPI = "//a[@class='category-api-item ng-binding'][contains(text(),'/definitions')]";
    private static final String TRYITBTN = "//span[@id='coral-button_label']/b[contains(text(),'Try it!')]";
    private static final String API_LINK = "//a[@class='category-api-item ng-binding'][contains(text(),'/news-subscriptions')]";

    @FindBy(xpath = API_LINK)
    private WebElement apiLink;

    @FindBy(xpath = TRYITBTN)
    private WebElement trybtn;

    private User user;
    private Servise servise = new Servise();

    public WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() throws Exception  {

        WebDriverSingleton.getWebDriverInstance().navigate().to(APIDOCS_URL);
    }

    @Test(description = "Start browser", priority = 1)
    public void LogintoApiDocs() throws Exception{

        user = new User("emqa16@thomsonreuters.com", "Secret123");
        //user.setLogin("emqa16@thomsonreuters.com");
        //user.setPassword("Secret123");

       Assert.assertTrue(servise.loginToMail(user));
    }

    @Test(description = "Sent request to Docs API", priority = 2)
    public void DocsReq() throws InterruptedException, JSONException {

        ApiDocsMainPage apiDocsMainPage= new ApiDocsMainPage(driver);
        apiDocsMainPage.DocsRequest(DOCSAPI);

        RequestDocsPage requestDocsPage = new RequestDocsPage(driver);
        assertTrue(requestDocsPage.isButtonDisplayed());
        Utils.noErrorinResponse();

    }

    @AfterClass(description = "Stop Browser", enabled = false)
    public void stopBrowser() {
        driver.quit();
        System.out.println("Browser was successfully quited.");
    }


}
