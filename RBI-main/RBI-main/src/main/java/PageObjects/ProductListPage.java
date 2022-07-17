package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Wait;

import java.util.List;

public class ProductListPage {

    private final WebDriver webDriver;

    public ProductListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 25), this);
    }

    @FindBy(css = "div.list-search input.form-control")
    private WebElement searchTextBox;

    @FindBy(xpath = "//font[contains(text(),'Home office: Health aspects')]")
    private WebElement firstResult;

    @FindBy(css = "rwm-automated-list ul.results")
    private List<WebElement> allProductList;


    public boolean searchResultPageIsDisplayed() {
        Wait.untilPageReadyState(webDriver, 5L);
        searchTextBox.isDisplayed();
        firstResult.isDisplayed();
        return true;
    }

    public String getResultTitle() {
        firstResult.isDisplayed();
        return firstResult.getText();
    }

}
