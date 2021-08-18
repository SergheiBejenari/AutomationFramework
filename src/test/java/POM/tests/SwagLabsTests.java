package POM.tests;

import POM.WebBrowser;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SwagLabsTests {

    private final String userName = "standard_user";
    private final String password = "secret_sauce";
    WebBrowser browser;

    @BeforeAll
    void launchBrowser() {
        browser = new WebBrowser();
    }

    @AfterAll
    void closeBrowser() {
        browser.close();
    }

    @Test
    public void logInTest() {
        browser.swagLabs().logInPage().navigate();
        browser.swagLabs().logInPage().logIn(userName, password);
        Assertions.assertTrue(browser.isDisplayed(browser.swagLabs().homePage().getUrl()));
    }

    @Test
    public void logOutTest() {
        browser.swagLabs().logInPage().navigate();
        browser.swagLabs().logInPage().logIn(userName, password);
        browser.swagLabs().homePage().logOut();
        Assertions.assertTrue(browser.isDisplayed(browser.swagLabs().logInPage().getUrl()));
    }
}
