package POM;

import POM.swagLabs.SwagLabsApplication;
import POM.w3School.W3SchoolApplication;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebBrowser {

    static com.microsoft.playwright.Browser browser;
    Playwright playwright;
    Page page;
    BrowserContext context;
    private SwagLabsApplication swagLabs;
    private W3SchoolApplication w3School;

    public WebBrowser() {
        browser = getBrowser();
        context = browser.newContext();
        page = context.newPage();
    }

    public com.microsoft.playwright.Browser getBrowser() {
        String browserName = System.getProperty("browser", "chrome");
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                return playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            case "firefox":
                return playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            default:
                throw new RuntimeException("ATF is not configured for " + browserName);
        }
    }

    public W3SchoolApplication w3School() {
        if (w3School == null) {
            w3School = new W3SchoolApplication(page);
        }
        return w3School;
    }

    public SwagLabsApplication swagLabs() {
        if (swagLabs == null) {
            swagLabs = new SwagLabsApplication(page);
        }
        return swagLabs;
    }

    public void close() {
        playwright.close();
    }

    public int getNumberOfTabs() {
        return context.pages().size();
    }

    public void switchToTab(int index) {
        page = context.pages().get(index);
    }

    public boolean isDisplayed(String url) {
        return page.url().equals(url);
    }
}
