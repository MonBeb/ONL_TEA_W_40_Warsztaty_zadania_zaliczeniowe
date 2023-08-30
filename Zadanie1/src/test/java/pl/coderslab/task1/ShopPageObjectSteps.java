package pl.coderslab.task1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShopPageObjectSteps {
    private WebDriver driver;
    private ShopMyAddressesPage myAddressesPage;

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

    @When("I go to my addresses")
    public void iGoToMyAddressesPage() {
        ShopMyAccountPage myAccountPage = new ShopMyAccountPage(driver);
        myAccountPage.goToMyAddressesPage();
        myAddressesPage = new ShopMyAddressesPage(driver);
    }

    @And("I add new address")
    public void iAddNewAddress() {
        myAddressesPage.addNewAddress();
    }

    @And("I enter new address alias {string} address {string} city {string} zip {string} country {string} phone {string}")
    public void iEnterNewAddress(String alias, String address, String city, String zip, String country, String phone) {
        ShopNewAddressPage newAddressPage = new ShopNewAddressPage(driver);
        newAddressPage.enterNewAddressData(alias, address, city, zip, country, phone);
    }

    @Then("I can see message {string}")
    public void iCanSeeMessage(String alertText) {
        myAddressesPage.verifyAlert(alertText);
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }

    @And("I remove the address")
    public void iRemoveTheAddress() {
        myAddressesPage.removeAddresses();
    }
}

