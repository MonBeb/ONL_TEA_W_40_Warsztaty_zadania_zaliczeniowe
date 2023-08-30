package pl.coderslab.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopMyAccountPage {
    private final WebDriver driver;

    public ShopMyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return driver.findElement(By.className("hidden-sm-down")).getText();
    }

    public void goToTheClothesWindowPage() {
        driver.findElement(By.id("category-3")).click();
    }
}
