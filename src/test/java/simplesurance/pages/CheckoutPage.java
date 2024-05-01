package simplesurance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//h3[@data-testid='total-component']")
    public WebElement totalAmount;

    @FindBy(xpath = "//div[@data-testid='default-stepper-component']")
    public WebElement checkoutSteps;

    @FindBy(xpath = "//input[@value='STRIPE.CARD']")
    public WebElement creditCard;

    @FindBy(xpath = "//button[span='Continuar para pagamento']")
    public WebElement continuePaymentBtn;


    @FindBy(xpath = "//iframe[contains(@name, '__privateStripeFrame')]")
    public WebElement cardNumberIframe;

    @FindBy(xpath = "//input[@name='cardnumber']")
    public WebElement cardNumberInput;

    @FindBy(xpath = "//button[span='Fazer encomenda']")
    public WebElement placeOrderBtn;

    @FindBy(xpath = "//p[span='Zertifikatsnummer']")
    public WebElement certificateNumber;

    @FindBy(xpath = "(//td[contains(@class, 'jss28')]/div[contains(@class, 'css-68o8xu')])[2]")
    public WebElement certificateNumberValue;

    @FindBy(xpath = "//a[@href='/certificates']")
    public WebElement listeBtn;

    @FindBy(xpath = "(//a[contains(@href,'/policy/details?id')])[1]")
    public WebElement firstCertificateNumber;


}
