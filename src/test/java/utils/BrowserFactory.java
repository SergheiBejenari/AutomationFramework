package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    Playwright playwright;

    public Browser getBrowser() {
        String browserName = System.getProperty("browser", "chrome");
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                return playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            case "firefox":
                return playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            default:
                throw new RuntimeException("ATF is not configured for " + browserName);
        }
    }

    public void close() {
        playwright.close();
    }

}
