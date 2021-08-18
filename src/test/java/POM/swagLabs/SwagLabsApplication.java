package POM.swagLabs;

import POM.swagLabs.pages.HomePage;
import POM.swagLabs.pages.LogInPage;
import com.microsoft.playwright.Page;

public class SwagLabsApplication {
    Page page;
    private LogInPage logInPage;
    private HomePage homePage;

    public SwagLabsApplication(Page page) {
        this.page = page;
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

}
