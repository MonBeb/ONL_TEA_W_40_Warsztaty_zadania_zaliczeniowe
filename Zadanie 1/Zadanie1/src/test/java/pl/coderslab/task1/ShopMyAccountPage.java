package pl.coderslab.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopMyAccountPage {
    private final WebDriver driver;

    public ShopMyAccountPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getUserName() {
        return driver.findElement(By.className("hidden-sm-down")).getText();
    }

    public void goToMyAddressesPage() {
        driver.findElement(By.id("addresses-link")).click();
    }
}
