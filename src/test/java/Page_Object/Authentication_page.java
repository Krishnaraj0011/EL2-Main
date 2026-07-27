package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Authentication_page extends Constructor_Baseclass{

    public Authentication_page(WebDriver driver){

        super(driver);

    }

    @FindBy(xpath="//a[@id='loginText2']")
    WebElement Login_with_corporate;

    @FindBy(xpath="//div[@data-bind='text: display']")
    WebElement Verify_Identity;

    @FindBy(xpath="//input[@id='idTxtBx_SAOTCC_OTC']")
    WebElement Verifycode;

    @FindBy(xpath="//input[@id='idSubmit_SAOTCC_Continue']")
    WebElement Btn_submit;

    public void BtnLogin_with_corporate()
    {
  	Login_with_corporate.click();
    }
    
    public void Btn_verify_identity()
    {
    	Verify_Identity.click();
    }
    
    public void Verify_OTP(String OTP)
    {
    	Verifycode.sendKeys(OTP);
    }

    public void Btn_submit()
    {
    	Btn_submit.click();
    }
}