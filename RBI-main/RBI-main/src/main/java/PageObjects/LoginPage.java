package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "div.d-flex h1.text-nowrap font font")
    private WebElement loginHeaderTitle;

    @FindBy(css = "div.rds-select-value span.rds-select-placeholder")
    private WebElement bankField;

    @FindBy(xpath = "(//div[contains(@class, 'rds-select-arrow-wrapper')])[2]")
    private WebElement bankDropdown;

    @FindBy(xpath = "(//input[contains(@class,'rds-input-element')])[1]")
    private WebElement signatoryNumber;

    @FindBy(xpath = "(//input[contains(@class,'rds-input-element')])[2]")
    private WebElement pinNumber;

    @FindBy(css = "div button[disabled='true']")
    private WebElement continueButton;


    public boolean loginPageIsDisplayed() {
        loginHeaderTitle.isDisplayed();
        bankField.isDisplayed();
        signatoryNumber.isDisplayed();
        pinNumber.isDisplayed();
        continueButton.isDisplayed();
        return true;
    }

    public String getLoginHeaderTitle() {
        loginHeaderTitle.isDisplayed();
        return loginHeaderTitle.getText();
    }

    public void selectBank(String bankName) {
        bankDropdown.isEnabled();
        bankDropdown.click();
        bankDropdown.sendKeys(bankName);
        bankDropdown.sendKeys(Keys.ENTER);
    }

    public void fillSignatoryNumber(String number) {
        signatoryNumber.isEnabled();
        signatoryNumber.clear();
        signatoryNumber.sendKeys(number);
    }

    public void fillPinNumber(String pnumber) {
        pinNumber.isEnabled();
        pinNumber.clear();
        pinNumber.sendKeys(pnumber);
    }

    public void clickContinueButton() {
        continueButton.isEnabled();
        continueButton.click();
    }
}
