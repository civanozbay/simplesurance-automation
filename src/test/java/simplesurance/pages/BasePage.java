package simplesurance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import simplesurance.utilities.Driver;

public abstract class BasePage {

    @FindBy(id = "login_username")
    public WebElement emailInput;

    @FindBy(id = "login_password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement nextBtn;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
