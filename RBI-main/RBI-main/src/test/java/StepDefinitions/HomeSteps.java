package stepdefinitions;

import pageobjects.HomePage;
import utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {

    HomePage homePage;
    TestContext testContext;

    public HomeSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("Home page of the given website")
    public void homePageWithoutAuthorizations() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
    }

    @Then("application is successfully launched and main home page is loaded with all sections")
    public void homePageIsDisplayed() {
        Assert.assertTrue(homePage.clickBausparenLink());
    }
}
