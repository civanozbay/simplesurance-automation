package simplesurance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceHomePage extends BasePage{

    @FindBy(xpath = "//a[@href='/policy/create']")
    public WebElement newBtn;

}
