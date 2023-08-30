package pl.coderslab.task2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopNewProductDetailsPage {
    private final WebDriver driver;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement sizeBtn;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;

    @FindBy(css = "button.btn.btn-primary.add-to-cart")
    private WebElement addToCartBtn;

    public ShopNewProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseSize(String size) {
        Select sizeSelect = new Select(sizeBtn);
        sizeSelect.selectByVisibleText(size);
    }

    public void chooseQuantity(String quantity) {
        quantityField.click();
        quantityField.sendKeys(Keys.BACK_SPACE);
        quantityField.sendKeys("5");

        addToCartBtn.click();
    }
}
