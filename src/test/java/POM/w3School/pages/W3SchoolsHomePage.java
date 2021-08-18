package POM.w3School.pages;

import com.microsoft.playwright.Page;

public class W3SchoolsHomePage {
    private final String title = "//h1[text()='HTML']";
    private final Page page;

    public W3SchoolsHomePage(Page page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }
}
