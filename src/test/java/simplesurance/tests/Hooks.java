package simplesurance.tests;

import org.testng.ITestContext;
import org.testng.annotations.*;
import simplesurance.listeners.LogListener;
import simplesurance.pages.InsuranceHomePage;
import simplesurance.utilities.ConfigurationReader;
import simplesurance.utilities.Driver;
import simplesurance.utilities.LoggerUtil;

import java.time.Duration;
@Listeners({ LogListener.class })
public class Hooks {

    @BeforeSuite(alwaysRun = true)
    public void globalSetup(){
        LoggerUtil.log("************************** Test Execution Started ************************************");
//        Driver.get().get(ConfigurationReader.get("url"));
    }

    @AfterSuite(alwaysRun = true)
    public void wrapAll(ITestContext context){
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        LoggerUtil.log("Total number of testcases : " + total);
        LoggerUtil.log("Number of testcases Passed : " + passed);
        LoggerUtil.log("Number of testcases Failed : " + failed);
        LoggerUtil.log("Number of testcases Skipped  : " + skipped);
        LoggerUtil.log("************************** Test Execution Finished ************************************");
    }

    @BeforeMethod
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        InsuranceHomePage insuranceHomePage = new InsuranceHomePage();
        insuranceHomePage.emailInput.sendKeys("testsellingpartner3@simplesurance.de");
        insuranceHomePage.passwordInput.sendKeys("TestSellingPartner3Pass");
        insuranceHomePage.nextBtn.click();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
