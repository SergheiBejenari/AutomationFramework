package POM.swagLabs.pages;

import POM.PageBase;
import com.microsoft.playwright.Page;

public class HomePage extends PageBase {

    private final Page page;
    private final String burgerMenu = "#react-burger-menu-btn";
    private final String logOutButton = "#logout_sidebar_link";
    private final String url = "https://www.saucedemo.com/inventory.html";

    public HomePage(Page page) {
        this.page = page;
    }

    public String getUrl() {
        return url;
    }

    public void logOut() {
        page.click(burgerMenu);
        page.click(logOutButton);
    }

}
