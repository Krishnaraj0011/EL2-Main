package Page_Object;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Test_Utilities.Reuse_methods;

public class Authentication_page extends Base_methods{
	
	public String OTP;

	public Authentication_page(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
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
    
    public void Scanner() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter OTP");
        OTP = scan.nextLine();
    }
    
    public void loginWithMicrosoftAuthentication()
    {
     Authentication_page ap = new Authentication_page(driver);
   	 BtnLogin_with_corporate();
   	 Btn_verify_identity();
   	 Reuse_methods rm = new Reuse_methods(driver); 
   	 Scanner();
   	 Verify_OTP(OTP);
   	 Btn_submit();
   	ET.log(Status.PASS, "Authentication completed successfully");
    }
    
}