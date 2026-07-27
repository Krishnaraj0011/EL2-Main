package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Test_Utilities.Reuse_methods;

public class CrowleyTL extends Constructor_Baseclass{

	public CrowleyTL(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//a[normalize-space()='Refresh']")
	public static WebElement  Refresh;
	
	public void refresh()
	{
		Refresh.click();
	}
	
	@FindBy(xpath= "(//button[normalize-space()='Attach POD'])[1]")
	public static WebElement  AttachPODbtn;
	
	public void AttachPOD_btn()
	{
		AttachPODbtn.click();
	}
	
	@FindBy(xpath= "//input[@placeholder='Enter IB Load ID']")
	public static WebElement  EnterIBloadID;
	
	public void EnterIB_loadID_input(String s)
	{
		Reuse_methods rm = new Reuse_methods(driver); 
		EnterIBloadID.sendKeys(s);
	}
	
	@FindBy(xpath= "//button[normalize-space()='Search']")
	public static WebElement  Search_Btn;
	
	public void Search_btn()
	{
		Search_Btn.click();
	}
	
	@FindBy(xpath= "//button[normalize-space()='Submit']")
	public static WebElement  SubmitBtn;
	
	public void Submit_btn()
	{
		SubmitBtn.click();
	}
	
	@FindBy(xpath= "//input[@name='$PpyAttachmentPage$ppxAttachName']")
	public static WebElement  Selectfile;
	
	public void selectfile()
	{
		Selectfile.sendKeys("C:\\Users\\rameskr\\Desktop\\EL2_main\\src\\Files\\63169260228.pdf");
	}

	@FindBy(xpath= "//button[normalize-space()='Submit']")
	public static WebElement crowleyTL_submitBTN;
	
	public void crowleyTL_submitbtn() {
		crowleyTL_submitBTN.click();
	}
	
}

