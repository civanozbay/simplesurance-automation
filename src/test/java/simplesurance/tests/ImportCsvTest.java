package simplesurance.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import simplesurance.listeners.LogListener;
import simplesurance.pages.ImportInsurancesPage;
import simplesurance.pages.InsuranceHomePage;
import simplesurance.utilities.LoggerUtil;

@Listeners({LogListener.class})
public class ImportCsvTest extends Hooks{

    @Test
    public void importCsv(){
        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        insuranceHomePage.importBtn.click();

        ImportInsurancesPage importInsurancesPage = new ImportInsurancesPage();
        importInsurancesPage.importBtn.sendKeys(System.getProperty("user.dir")+"/src/test/resources/Follow up QA Automation Challenge data.csv");
        LoggerUtil.log("Csv file uploaded.");
        importInsurancesPage.createInsuranceBtn.click();
        Assert.assertTrue(importInsurancesPage.greenCheckMark.isDisplayed());

        for(WebElement policyNumber : importInsurancesPage.policyNumbers){
            Assert.assertTrue(policyNumber.isDisplayed());
        }
        importInsurancesPage.listBtn.click();
        LoggerUtil.log("Insurances added to the list.");
        for(WebElement policyNumber : importInsurancesPage.policyNumbers){
            Assert.assertTrue(policyNumber.isDisplayed());
        }

    }

}
