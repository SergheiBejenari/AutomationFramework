package swagLabs.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import swagLabs.POM.SwagLabsApplication;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SwagLabsTests {
    private final String userName = "standard_user";
    private final String password = "secret_sauce";
    SwagLabsApplication app;

    @BeforeAll
    void launchBrowser() {
        app = new SwagLabsApplication();
    }

    @AfterAll
    void closeBrowser() {
        app.close();
    }

    @Test
    public void logInTest() {
        app.logInPage().navigate();
        app.logInPage().logIn(userName, password);
        assertTrue(app.homePage().isHomePageOpened());
    }

    @Test
    public void logOutTest() {
        app.logInPage().navigate();
        app.logInPage().logIn(userName, password);
        app.homePage().logOut();
        assertTrue(app.logInPage().isLogInPageOpened());
    }

}