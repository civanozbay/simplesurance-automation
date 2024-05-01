package simplesurance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import simplesurance.utilities.Driver;

import java.util.List;

public class InsuranceHomePage extends BasePage{

    @FindBy(xpath = "//a[@href='/policy/create']")
    public WebElement newBtn;

    @FindBy(xpath = "//a[@href='/policy/import']")
    public WebElement importBtn;

    @FindBy(xpath = "(//div[@aria-haspopup='listbox'])[1]")
    public WebElement filterDropdown;

    @FindBy(xpath = "//li[@data-value='policy_number']")
    public WebElement policyNumFilter;

    @FindBy(xpath = "//li[@data-value='email']")
    public WebElement emailFilter;

    @FindBy(xpath = "//li[@data-value='date_start']")
    public WebElement dateStartFilter;

    @FindBy(xpath = "//li[@data-value='date_end']")
    public WebElement dateEndFilter;

    @FindBy(css = "svg[data-testid='SearchIcon']")
    public WebElement searchIcon;

    @FindBy(xpath = "(//input[@aria-invalid='false'])[1]")
    public WebElement filterInput;

    @FindBy(xpath = "(//a[contains(@href,'/policy/details?id')])[1]")
    public WebElement certificateNumber;

    @FindBy(xpath = "//tr[position()>1]/th[4]/span")
    public WebElement insuranceActivationDate;

    @FindBy(xpath = "//a[contains(@href,'/policy/details?id')]")
    public List<WebElement> policyNumbers;

    public WebElement selectEmail(String email){
        return Driver.get().findElement(By.xpath("//th[text()='"+email+"']"));
    }
}
