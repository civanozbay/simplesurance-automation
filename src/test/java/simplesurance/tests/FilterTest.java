package simplesurance.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import simplesurance.pages.InsuranceHomePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FilterTest extends Hooks{

    @Test
    public void searchForPolicyNumber() throws InterruptedException {

        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        Thread.sleep(5000);
        insuranceHomePage.filterDropdown.click();

        insuranceHomePage.policyNumFilter.click();

        insuranceHomePage.filterInput.sendKeys("200000421525");
        insuranceHomePage.filterInput.sendKeys(Keys.ENTER);

        Assert.assertTrue(insuranceHomePage.certificateNumber.isDisplayed());
        Assert.assertEquals(insuranceHomePage.certificateNumber.getText(),"200000421525");
        Assert.assertTrue(insuranceHomePage.searchIcon.isDisplayed());
    }

    @Test
    public void searchForEmail() throws InterruptedException {

        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        Thread.sleep(5000);
        insuranceHomePage.filterDropdown.click();

        insuranceHomePage.emailFilter.click();

        insuranceHomePage.filterInput.sendKeys("test@tester.com");
        insuranceHomePage.filterInput.sendKeys(Keys.ENTER);

        Assert.assertTrue(insuranceHomePage.selectEmail("test@tester.com").isDisplayed());
        Assert.assertEquals(insuranceHomePage.selectEmail("test@tester.com").getText(),"test@tester.com");
        Assert.assertTrue(insuranceHomePage.searchIcon.isDisplayed());
    }

    @Test
    public void searchForOlderThan() throws InterruptedException {

        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        Thread.sleep(5000);
        insuranceHomePage.filterDropdown.click();

        insuranceHomePage.dateEndFilter.click();
        insuranceHomePage.filterInput.sendKeys("31.05.2024");
        insuranceHomePage.filterInput.sendKeys(Keys.ENTER);

        String insuranceExpiryDateText = insuranceHomePage.insuranceActivationDate.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy", Locale.GERMAN);
        LocalDate parsedDateFromUI = LocalDate.parse(insuranceExpiryDateText, formatter);

        Assert.assertTrue(parsedDateFromUI.isEqual(LocalDate.now()) || parsedDateFromUI.isBefore(LocalDate.of(2024,05,31)));

    }

    @Test
    public void searchForNewerThan() throws InterruptedException {
        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        Thread.sleep(5000);
        insuranceHomePage.filterDropdown.click();

        insuranceHomePage.dateStartFilter.click();

        insuranceHomePage.filterInput.sendKeys(Keys.ENTER);

        String insuranceExpiryDateText = insuranceHomePage.insuranceActivationDate.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy", Locale.GERMAN);
        LocalDate parsedDateFromUI = LocalDate.parse(insuranceExpiryDateText, formatter);

        Assert.assertTrue(parsedDateFromUI.isEqual(LocalDate.now()) || parsedDateFromUI.isAfter(LocalDate.now()));
    }

    @Test
    public void verifyPolicyNumbersOrder(){
        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        List<Long> numbers = new ArrayList<>();
        boolean isSortedDesc =true;
        for(WebElement policyNumber : insuranceHomePage.policyNumbers){
            String policyNumberText = policyNumber.getText();
            Long number = Long.parseLong(policyNumberText);
            numbers.add(number);
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < numbers.get(i + 1)) {
                isSortedDesc=false;
                break;
            }
        }
        Assert.assertTrue( isSortedDesc);
    }
}
