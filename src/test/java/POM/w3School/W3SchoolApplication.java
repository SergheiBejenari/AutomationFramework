package POM.w3School;

import POM.w3School.pages.CodeEditorPage;
import POM.w3School.pages.W3SchoolsHomePage;
import com.microsoft.playwright.Page;

public class W3SchoolApplication {
    Page page;
    private W3SchoolsHomePage w3SchoolsHomePage;
    private CodeEditorPage codeEditorPage;

    public W3SchoolApplication(Page page) {
        this.page = page;
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

}
