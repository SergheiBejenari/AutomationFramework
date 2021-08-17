package swagLabs.POM;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import swagLabs.POM.pages.HomePage;
import swagLabs.POM.pages.LogInPage;
import utils.BrowserFactory;

public class SwagLabsApplication {
    static Browser browser;
    BrowserFactory browserFactory = new BrowserFactory();
    Page page;
    BrowserContext context;
    private LogInPage logInPage;
    private HomePage homePage;

    public SwagLabsApplication() {
        browser = browserFactory.getBrowser();
        context = browser.newContext();
        page = context.newPage();
    }

    public LogInPage logInPage() {
        if (logInPage == null) {
            logInPage = new LogInPage(page);
        }
        return logInPage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(page);
        }
        return homePage;
    }

    public void close() {
        browserFactory.close();
    }
}
