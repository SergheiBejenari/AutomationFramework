package w3School.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import w3School.POM.W3SchoolApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void changeTabs() {
        app.codeEditorPage().navigate();
//        app.codeEditorPage().clickW3SchoolLink();
        app.clickLink(app.codeEditorPage().getW3SchoolLink());
        assertTrue(app.w3SchoolsHomePage().isW3SchoolPageOpened());
        app.getPreviousTab();
        app.clickLink(app.codeEditorPage().getW3SchoolLink());
//        app.codeEditorPage().clickW3SchoolLink();
        assertTrue(app.w3SchoolsHomePage().isW3SchoolPageOpened());
        assertEquals(app.getNumberOfTabs(), 3);
    }

}
