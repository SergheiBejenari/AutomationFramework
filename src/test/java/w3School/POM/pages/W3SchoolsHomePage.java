package w3School.POM.pages;

import com.microsoft.playwright.Page;

public class W3SchoolsHomePage {
    private final String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target";
    private final Page page;

    public W3SchoolsHomePage(Page page) {
        this.page = page;
    }

    public boolean isCodeEditorPageOpened() {
        return page.url().equals(url);
    }

}
