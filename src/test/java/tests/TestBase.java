package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.WbMainPage;

public class TestBase {
    WbMainPage wbMainPage = new WbMainPage();

    @BeforeAll
    static void preconditionsForAllTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://wildberries.ru/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }
}
