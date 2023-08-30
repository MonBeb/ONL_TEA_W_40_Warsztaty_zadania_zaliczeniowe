package pl.coderslab.task2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ShopAccountShoppingSteps {
    private WebDriver driver;

    private ShopClothesWindowPage clothesWindowPage;

    private ShopNewProductDetailsPage newProductDetailsPage;

    private ShopPersonalInformationPage personalInformationPage;

    @Given("I'm on shop main page")
    public void ImOnShopMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @When("I sign in")
    public void isSignIn() {
        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
    }

    @And("I login using {string} and {string}")
    public void iLoginUsingAnd(String email, String password) {
        ShopLoginPage loginPage = new ShopLoginPage(driver);
        loginPage.loginAs("hnntbubjozeqduwrcw@cazlg.com", "superhaslo");
    }

    @And("I go to the clothes window")
    public void iGoToTheClothesWindow() {
        ShopMyAccountPage myAccountPage = new ShopMyAccountPage(driver);
        myAccountPage.goToTheClothesWindowPage();
        clothesWindowPage = new ShopClothesWindowPage(driver);
    }

    @Then("I choose new product")
    public void iChooseNewProduct() {
        clothesWindowPage.chooseNewProduct();
    }

    @And("I choose the size {string} number of pieces {string} and add products to the basket")
    public void iChooseSizeAndQuantity(String size, String quantity) {
        ShopNewProductDetailsPage newProductDetailsPage = new ShopNewProductDetailsPage(driver);
        newProductDetailsPage.chooseSize(size);
        newProductDetailsPage.chooseQuantity(quantity);
    }

    @And("I go to basket to proceeded to checkout")
    public void iGoToBasketToProceedToCheckOut() {
        ShopProceedToCheckPage proceedToCheckPage = new ShopProceedToCheckPage(driver);
        proceedToCheckPage.proceedToCheckOut();
        proceedToCheckPage.finalCheckOut();
    }

    @When("I confirm address, method of delivery and payment and complete the order")
    public void iConfirmPersonalInformation() {
        ShopPersonalInformationPage personalInformationPage = new ShopPersonalInformationPage(driver);
        personalInformationPage.addresses();
        personalInformationPage.shippingMethod();
        personalInformationPage.shippingMethodNext();
        personalInformationPage.paymentMethod();
        personalInformationPage.termsAndRules();
        personalInformationPage.placeOrder();
    }

    @Then("I take a screenshot with confirmed message")
    public void iTakeScreenshotWithConfirmedMessage() {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Users\\Monika\\Desktop\\CODERSLAB\\Zadania zaliczeniowe\\Zadanie 2\\screenshots\\screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }
}



