package Homework.Module8.util;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class Utils {

    private static WebElement driver;
    private static final String RESP ="//textarea[@class='textarea-viewer ng-binding']";

    public static String convertBasic64(String str){
        byte[] bytesEncoded = Base64.encodeBase64(str .getBytes());
        return new String(bytesEncoded);
    }

    public static void noErrorinResponse() throws JSONException {

        WebElement element = driver.findElement(By.xpath(RESP));
        JSONObject jsonObject = new JSONObject(element.getText());

        String valueToCheck = jsonObject.get("ErrorCode").toString();
        //Assert.assertEquals(valueToCheck, null);
    }

    public static void highlightElement(WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "green" + "'", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);

    }

}

