package pl.coderslab.task1;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;
import java.util.List;

public class ShopMyAddressesPage {
    private final WebDriver driver;

    @FindBy(xpath = "//address")
    private List<WebElement> addresses;

    @FindBy(xpath = "//span[contains(text(),'Create new address')]")
    private WebElement newAddressBtn;

    @FindBy(xpath = "//li[contains(text(),'Address successfully added!')]")
    private WebElement alert;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/div[1]/div[1]/section[1]/section[1]/div[2]/article[1]/div[2]/a[2]/span[1]")
    private WebElement removeAddressesBtn;

    public ShopMyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress() {
        newAddressBtn.click();
    }

    public boolean addressIsVisible() {
        return addresses.size() > 0;
    }

    public void verifyAlert(String alertText) {
        Assertions.assertTrue(addressIsVisible(), "Created address should be visible");
        Assertions.assertEquals(alertText, alert.getText());
    }

    public void removeAddresses() {
        removeAddressesBtn.click();
    }
}




