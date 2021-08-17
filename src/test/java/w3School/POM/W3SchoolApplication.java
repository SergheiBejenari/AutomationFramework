package w3School.POM;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import utils.BrowserFactory;
import w3School.POM.pages.CodeEditorPage;
import w3School.POM.pages.W3SchoolsHomePage;

public class W3SchoolApplication {
    static Browser browser;
    BrowserFactory browserFactory = new BrowserFactory();
    Page page;
    BrowserContext context;
    private W3SchoolsHomePage w3SchoolsHomePage;
    private CodeEditorPage codeEditorPage;

    public W3SchoolApplication() {
        browser = browserFactory.getBrowser();
        context = browser.newContext();
        page = context.newPage();
    }

    public W3SchoolsHomePage w3SchoolsHomePage() {
        if (w3SchoolsHomePage == null) {
            w3SchoolsHomePage = new W3SchoolsHomePage(page);
        }
        return w3SchoolsHomePage;
    }

    public CodeEditorPage codeEditorPage() {
        if (codeEditorPage == null) {
            codeEditorPage = new CodeEditorPage(page);
        }
        return codeEditorPage;
    }

    public void close() {
        browserFactory.close();
    }

    public int getNumberOfTabs() {
        return context.pages().size();
    }

    public void clickLink(String link) {
        page = context.waitForPage(() -> {
            page.click(link);
        });
    }

    public void getPreviousTab() {
        page.bringToFront();
        page = context.pages().get(0);
    }
}
