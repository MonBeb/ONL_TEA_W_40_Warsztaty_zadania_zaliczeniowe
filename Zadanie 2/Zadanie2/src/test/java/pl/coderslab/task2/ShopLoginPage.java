package pl.coderslab.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopLoginPage {
    private static WebDriver driver;

    public ShopLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.id("field-email"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.className("hidden-sm-down"));
        return userName.getText();
    }
}
