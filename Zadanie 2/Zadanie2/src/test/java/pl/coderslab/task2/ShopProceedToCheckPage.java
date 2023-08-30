package pl.coderslab.task2;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopProceedToCheckPage {
    private final WebDriver driver;

    @FindBy(xpath = "//body/div[@id='blockcart-modal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/i[1]")
    private WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    private WebElement finalCheckOutBtn;

    public ShopProceedToCheckPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckOut() {
        proceedToCheckOutBtn.click();
    }

    public void finalCheckOut() {
        finalCheckOutBtn.click();
    }
}

