package w3School.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import w3School.POM.W3SchoolApplication;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class W3SchoolTest {
    W3SchoolApplication app;

    @BeforeAll
    void launchBrowser() {
        app = new W3SchoolApplication();
    }

    @AfterAll
    void closeBrowser() {
        app.close();
    }

    @Test
    public void clickToLinkTest() {
        app.codeEditorPage().navigate();
        app.codeEditorPage().clickOnW3SchoolLink();
        assertTrue(app.w3SchoolsHomePage().isCodeEditorPageOpened());
    }
}
