package POM.swagLabs.pages;

import com.microsoft.playwright.Page;

public class LogInPage {
    private final Page page;
    private final String userNameField = "#user-name";
    private final String passwordField = "#password";
    private final String loginButton = "#login-button";
    private final String url = "https://www.saucedemo.com/";

    public LogInPage(Page page) {
        this.page = page;
    }

    public String getUrl() {
        return url;
    }

    public void navigate() {
        page.navigate(url);
    }

    public void logIn(String userName, String password) {
        page.fill(userNameField, userName);
        page.fill(passwordField, password);
        page.click(loginButton);
    }
}
