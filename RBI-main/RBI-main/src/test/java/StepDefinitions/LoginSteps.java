package stepdefinitions;

import pageobjects.LoginPage;
import utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    TestContext testContext;
    LoginPage loginPage;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Then("Login page is displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(loginPage.loginPageIsDisplayed());

        String actualLoginHeaderTitle = loginPage.getLoginHeaderTitle();
        Assert.assertEquals(" Please log in ", actualLoginHeaderTitle);

    }

    @When("Input {string} as bank name, {number} as signatory number, {number} as PIN number")
    public void inputAsBankAsSignatoryAsPINType(String bankName, String number, String pnumber) {
        System.out.println("---" + bankName);
        System.out.println("---" + number);
        System.out.println("---" + pnumber);
    }

    @When("Click continue button")
    public void clickContinueButton() {
        loginPage.clickContinueButton();
    }
}
