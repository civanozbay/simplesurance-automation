package simplesurance.tests;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import simplesurance.pages.CheckoutPage;
import simplesurance.pages.CreateNewInsurance;
import simplesurance.pages.InsuranceHomePage;
import simplesurance.utilities.ConfigurationReader;
import simplesurance.utilities.Driver;


public class CreateInsuranceTest extends Hooks{

    @Test
    public void createInsurance() {
        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        insuranceHomePage.newBtn.click();

        CreateNewInsurance createNewInsurance = new CreateNewInsurance();
        createNewInsurance.countryDropdown.click();
        createNewInsurance.findCountryByName("Portugal").click();

        createNewInsurance.productNameDropdown.click();
        createNewInsurance.selectProduct("Nokia_v1Allianz_global").click();

        createNewInsurance.tariffDropdown.click();
        createNewInsurance.selectTariff("1-34-Nokia_v1Allianz_global-D-EUR-v1-Accidental_damage").click();

        createNewInsurance.categoryNameDropdown.click();
        createNewInsurance.selectCategory("CATEGORY_SMARTPHONE").click();

        createNewInsurance.periodDropdown.click();
        createNewInsurance.selectPeriod("12 month(s)").click();

        createNewInsurance.frequencyDropdown.click();
        createNewInsurance.selectFrequency("Einmalig").click();

        createNewInsurance.classSelectDropdown.click();
        createNewInsurance.selectClass("PDCODE677395").click();

        createNewInsurance.serialNumberInput.sendKeys("SER-1111");
        createNewInsurance.deviceNameInput.sendKeys("DEV-1111");
        createNewInsurance.invoiceNumberInput.sendKeys("INV-1111");

        createNewInsurance.nextBtn.click();

        createNewInsurance.firstName.sendKeys("test");
        createNewInsurance.lastName.sendKeys("user");
        createNewInsurance.email.sendKeys("test@test.com");
        createNewInsurance.streetName.sendKeys("Karlsbad");
        createNewInsurance.houseNumber.sendKeys("16");
        createNewInsurance.postalCode.sendKeys("10785");
        createNewInsurance.city.sendKeys("Berlin");
        createNewInsurance.country.sendKeys("DE");
        createNewInsurance.taxCode.sendKeys("12345");

        createNewInsurance.nextBtn.click();

        for (WebElement checkbox : createNewInsurance.checkboxes) {
            checkbox.click();
        }

        createNewInsurance.createInsurance.click();

        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertTrue(checkoutPage.checkoutSteps.isDisplayed());
        Assert.assertEquals(checkoutPage.totalAmount.getText(), "21,95 €");

        checkoutPage.creditCard.click();
        checkoutPage.continuePaymentBtn.click();

        Driver.get().switchTo().frame(checkoutPage.cardNumberIframe);
        checkoutPage.cardNumberInput.sendKeys(
                ConfigurationReader.get("test_credit_card_number")+
                ConfigurationReader.get("test_mm_aa")+
                ConfigurationReader.get("test_cvc"));
        Driver.get().switchTo().defaultContent();

        checkoutPage.placeOrderBtn.click();

        Assert.assertTrue(checkoutPage.certificateNumber.isDisplayed());

        String certificateNum = checkoutPage.certificateNumberValue.getText();

        checkoutPage.listeBtn.click();

        Assert.assertEquals(checkoutPage.firstCertificateNumber.getText(),certificateNum);
    }



}
