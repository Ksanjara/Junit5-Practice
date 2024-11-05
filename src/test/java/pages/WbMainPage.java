package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WbMainPage {
    private SelenideElement searchField = $("#searchInput"),
            listOfCards = $(".product-card-list"),
            mainPageContent = $(".main-page__content");


    public WbMainPage openMainPage() {
        open("");
        mainPageContent.shouldBe(visible);

        return this;
    }

    public WbMainPage searchSomething(String searchText) {
        searchField.setValue(searchText).pressEnter();

        return this;
    }

    public WbMainPage checkThatResultsNotEmpty() {
        listOfCards.shouldNotBe(empty);

        return this;
    }

    public WbMainPage checkProductIsFoundByBrand(String brandName) {
        listOfCards.shouldHave(text(brandName));

        return this;
    }
}
