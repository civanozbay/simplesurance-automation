package simplesurance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ImportInsurancesPage extends BasePage{

    @FindBy(id = "input-csv")
    public WebElement importBtn;

    @FindBy(xpath = "//th[text()='✅']")
    public WebElement greenCheckMark;

    @FindBy(xpath = "//a[contains(@href,'/policy/details?id')]")
    public List<WebElement> policyNumbers;

    @FindBy(xpath = "//a[@href='/certificates']")
    public WebElement listBtn;

    @FindBy(xpath = "//button[span='Versicherung erstellen']")
    public WebElement createInsuranceBtn;


}
