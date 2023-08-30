package pl.coderslab.task2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPersonalInformationPage {
    private final WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement addressesContinueBtn;

    @FindBy(className = "col-sm-1")
    private WebElement pickUpInStoreCheckbox;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement shippingMethodNextBtn;

    @FindBy(id = "payment-option-1")
    private WebElement payByCheckCheckbox;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//button[contains(text(),'Place order')]")
    private WebElement placeOrderBtn;

    public ShopPersonalInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addresses() {
        addressesContinueBtn.click();
    }

    public void shippingMethod() {
        if (!pickUpInStoreCheckbox.isSelected())
            pickUpInStoreCheckbox.click();
    }

    public void shippingMethodNext() {
        shippingMethodNextBtn.click();
    }

    public void paymentMethod() {
        if (!payByCheckCheckbox.isSelected())
            payByCheckCheckbox.click();
    }

    public void termsAndRules() {
        if (!agreeCheckbox.isSelected())
            agreeCheckbox.click();
    }

    public void placeOrder() {
        placeOrderBtn.click();
    }
}
