package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SearchProductTests extends TestBase {

    @ValueSource(strings = {
            "роботы", "робот игрушка", "игрушка мальчикам"
    })
    @ParameterizedTest(name = "For search query {0} robot is found")
    void searchResultContainRobotInFirst50Places(String searchQuery) {
        String brandName = "RoboGoog";
        wbMainPage.openMainPage()
                .searchSomething(searchQuery)
                .checkProductIsFoundByBrand(brandName);
    }

    @CsvSource(value = {
            "рюкзак для детей , Hits for Kids",
            "радиоуправляемый робот , RoboGoog"
    })
    @ParameterizedTest(name = "For search query {0} product {1} is found")
    void searchResultContainParticularBrand(String searchQuery, String expectedBrand) {
        wbMainPage.openMainPage()
                .searchSomething(searchQuery)
                .checkProductIsFoundByBrand(expectedBrand);
    }

    @CsvFileSource(resources = "/test_data/searchQueryAndBrandName.csv")
    @ParameterizedTest(name = "Для поискового запроса {0} в результате поиска должен быть бренд {1}")
    void searchResultContainParticularBrandFromCsv(String searchQuery, String expectedBrand) {
        wbMainPage.openMainPage()
                .searchSomething(searchQuery)
                .checkProductIsFoundByBrand(expectedBrand);
    }

}
