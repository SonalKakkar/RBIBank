package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(css = "div.header-logo a")
    private WebElement headerLogoButton;
    @FindBy(css = "input[id*='search--input-header']")
    private WebElement searchInput;
    @FindBy(css = "nav[id='main-navigation'] ul.navbar-nav")
    private WebElement navigationBar
    @FindBy(xpath = "//a[contains(text(),'Bausparen')]")
    private WebElement bausparen;
    @FindBy(xpath = "(//input[contains(@placeholder,'What are you looking for?')])[1]")
    private WebElement searchProductLink;



    public boolean defaultHomePageIsDisplayed() {
        headerLogoButton.isDisplayed();
        searchInput.isDisplayed();
        navigationBar.isDisplayed();
        return true;
    }

    public void clickBausparenLink() {
        bausparen.isEnabled();
        bausparen.click();
    }

    public void setSearchInput(String product) {
        searchInput.isEnabled();
        searchInput.click();
        searchInput.sendKeys(product);
    }

    public String getSearchProductLink() {
        searchProductLink.isDisplayed();
        return searchProductLink.getText();
    }

    public void searchProductData(String product) {
        setSearchInput(product);
        searchInput.sendKeys(Keys.ENTER);
    }
}
