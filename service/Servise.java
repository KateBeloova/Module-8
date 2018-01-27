package Homework.Module8.service;

import Homework.Module8.business_objects.User;
import Homework.Module8.core.Driver;
import Homework.Module8.page.ApiDocsLoginPage;


public class Servise {

    public boolean loginToMail(User user) throws Exception {
        ApiDocsLoginPage screen = new ApiDocsLoginPage (Driver.getWebDriverInstance());
        return screen.login(user).isSearchItemDisplayed();
    }
}
