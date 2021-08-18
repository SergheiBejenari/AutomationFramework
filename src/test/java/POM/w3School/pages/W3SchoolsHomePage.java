package POM.w3School.pages;

import com.microsoft.playwright.Page;

public class W3SchoolsHomePage {
    private final String url = "https://www.w3schools.com/";
    private final Page page;

    public W3SchoolsHomePage(Page page) {
        this.page = page;
    }

    public String getUrl() {
        return url;
    }

}
