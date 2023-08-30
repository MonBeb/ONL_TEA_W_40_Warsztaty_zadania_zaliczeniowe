package pl.coderslab.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopNewAddressPage {
    private final WebDriver driver;
    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement zipInput;

    @FindBy(id = "field-id_country")
    private WebElement countryList;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement submitBtn;

    public ShopNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterNewAddressData(String alias, String address, String city, String zip, String country, String phone) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        zipInput.clear();
        zipInput.sendKeys(zip);

        if (!countryList.toString().equals("United Kingdom")) {
            Select countrySelect = new Select(countryList);
            countrySelect.selectByVisibleText("United Kingdom");
        }

        phoneInput.clear();
        phoneInput.sendKeys(phone);
        submitBtn.click();
    }
}
