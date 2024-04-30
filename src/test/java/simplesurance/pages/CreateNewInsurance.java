package simplesurance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import simplesurance.utilities.Driver;

import java.util.List;

public class CreateNewInsurance extends BasePage{


    @FindBy(id = "country-select")
    public WebElement countryDropdown;

    @FindBy(id = "product-name-select")
    public WebElement productNameDropdown;

    @FindBy(id = "tariff-name-select")
    public WebElement tariffDropdown;

    @FindBy(id = "category-name-select")
    public WebElement categoryNameDropdown;

    @FindBy(id = "duration-select")
    public WebElement periodDropdown;

    @FindBy(id = "frequency-select")
    public WebElement frequencyDropdown;

    @FindBy(id = "class-name-select")
    public WebElement classSelectDropdown;

    @FindBy(id = "input-createCertificate_serialNumber")
    public WebElement serialNumberInput;

    @FindBy(id = "input-createCertificate_deviceName")
    public WebElement deviceNameInput;
    @FindBy(id = "input-createCertificate_invoiceNumber")
    public WebElement invoiceNumberInput;

    @FindBy(xpath = "//button[span='Weiter']")
    public WebElement nextBtn;

    @FindBy(id = "input-createCertificate_firstName")
    public WebElement firstName;

    @FindBy(id = "input-createCertificate_lastName")
    public WebElement lastName;

    @FindBy(id = "input-createCertificate_email")
    public WebElement email;
    @FindBy(id = "input-createCertificate_streetName")
    public WebElement streetName;

    @FindBy(xpath = "//input[@data-testid='input-createCertificate_streetNumber']")
    public WebElement houseNumber;

    @FindBy(id = "input-createCertificate_zip")
    public WebElement postalCode;

    @FindBy(id = "input-createCertificate_city")
    public WebElement city;

    @FindBy(id = "input-createCertificate_country")
    public WebElement country;

    @FindBy(id = "input-createCertificate_taxCode")
    public WebElement taxCode;

    @FindBy(xpath = "//input[@data-indeterminate='false']")
    public List<WebElement> checkboxes;

    @FindBy(xpath = "//button[span='Versicherung erstellen']" )
    public WebElement createInsurance;

    public WebElement findCountryByName(String countryName){
        return Driver.get().findElement(By.xpath("//li[span='" + countryName + "']"));
    }

    public WebElement selectProduct(String productName){
        return Driver.get().findElement(By.xpath("//li[@data-value='" + productName + "']"));
    }

    public WebElement selectTariff(String tariffName){
        return Driver.get().findElement(By.xpath("//li[@data-value='" + tariffName + "']"));
    }

    public WebElement selectCategory(String categoryName){
        return Driver.get().findElement(By.xpath("//li[@data-value='" + categoryName + "']"));
    }

    public WebElement selectPeriod(String period){
        return Driver.get().findElement(By.xpath("//li[@data-value='" + period + "']"));
    }

    public WebElement selectFrequency(String frequency){
        return Driver.get().findElement(By.xpath("//li[span='" + frequency + "']"));
    }
    public WebElement selectClass(String className){
        return Driver.get().findElement(By.xpath("//li[@data-value='" + className + "']"));
    }
}
