package stepdefinitions;

import enums.Context;
import pageobjects.HomePage;
import pageobjects.ProductListPage;
import utilities.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchSteps {

    TestContext testContext;
    HomePage homePage;
    ProductListPage productListPage;

    public SearchSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        productListPage = testContext.getPageObjectManager().getProductListPage();
    }

    @When("User clicks on search box and types any keyword")
    public void inputDataSearch(String data) {
        homePage.setSearchInput(data);
    }

    @Then("Search product link with {string} data is displayed")
    public void searchProductLinkWithDataIsDisplayed(String data) {
        String dataLowerCase = data.toLowerCase();
        String actualSearchProductLink = homePage.getSearchProductLink().toLowerCase();

        Assert.assertEquals("What are you looking for? " + dataLowerCase, actualSearchProductLink);
    }

    @When("Search product with {string} keyword")
    public void searchProductWithKeyword(String productName) {
        homePage.searchProductData(productName);
        testContext.scenarioContext.setContext(Context.EXPECTED_DATA, productName);
    }

    @Then("relevant results regarding searched keyword are displayedd")
    public void productListIsDisplayed() {
        Assert.assertTrue(productListPage.searchResultPageIsDisplayed());

        String actualResultTitle = productListPage.getResultTitle().toLowerCase();
        String expectedProductName = testContext.scenarioContext.getContext(Context.EXPECTED_DATA).toString().toLowerCase();

        Assert.assertEquals(expectedProductName, actualResultTitle);

    }

}
