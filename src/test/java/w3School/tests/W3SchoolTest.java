package w3School.tests;

import org.junit.jupiter.api.*;
import w3School.POM.W3SchoolApplication;

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
        app.codeEditorPage().clickW3SchoolLink();
        app.getTabByIndex(1);
        Assertions.assertTrue(app.w3SchoolsHomePage().isW3SchoolPageOpened());
        app.getTabByIndex(0);
        app.codeEditorPage().clickW3SchoolLink();
        Assertions.assertTrue(app.w3SchoolsHomePage().isW3SchoolPageOpened());
        Assertions.assertEquals(app.getNumberOfTabs(), 3);
    }

}
