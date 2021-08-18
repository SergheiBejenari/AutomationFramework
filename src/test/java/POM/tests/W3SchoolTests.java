package POM.tests;

import POM.WebBrowser;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class W3SchoolTests {
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
    public void changeTabs() {
        browser.w3School().codeEditorPage().navigate();
        browser.w3School().codeEditorPage().clickW3SchoolLink();
        browser.switchToTab(1);
        Assertions.assertTrue(browser.isDisplayed(browser.w3School().w3SchoolsHomePage().getUrl()));
        browser.switchToTab(0);
        browser.w3School().codeEditorPage().clickW3SchoolLink();
        Assertions.assertTrue(browser.isDisplayed(browser.w3School().w3SchoolsHomePage().getUrl()));
        Assertions.assertEquals(browser.getNumberOfTabs(), 3);
    }
}
