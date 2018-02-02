package Homework.Module8.patterns.factorymethod;


import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {
    protected WebDriver driver;

    public abstract WebDriver createDriver();
}

