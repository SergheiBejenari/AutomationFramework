package swagLabs.tests;

import org.junit.jupiter.api.*;
import swagLabs.POM.SwagLabsApplication;

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
        Assertions.assertTrue(app.homePage().isHomePageOpened());
    }

    @Test
    public void logOutTest() {
        app.logInPage().navigate();
        app.logInPage().logIn(userName, password);
        app.homePage().logOut();
        Assertions.assertTrue(app.logInPage().isLogInPageOpened());
    }

}