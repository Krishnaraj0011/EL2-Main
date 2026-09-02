package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Test_Utilities.Wait_Utilities;


public class Home_page extends Base_methods
{
	
	Wait_Utilities wait;
	public Home_page (WebDriver driver) {
	    this.driver = driver;
	    this.wait= new Wait_Utilities(driver);
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@title='Crowley On Dock']")
	public static WebElement Crowleyondock;
	
	public void clickOnLeftnav_Crowleyondock_Btn()
	{
	   wait = new Wait_Utilities(driver);
	   wait.waitForVisible(Crowleyondock);
	   Crowleyondock.click();
	   ET.log(Status.PASS, "Opened crowley on dock worked queue as expected");
	}
	
	@FindBy(xpath= "(//span[contains(@data-click,'..')][normalize-space()='Crowley TL'])[1]")
	public static WebElement  CrowleyTL;
	
	public void clickOnCrowleyTL_LeftNav() throws Exception
	{	
		Thread.sleep(1000);
		wait.waitForClickable(CrowleyTL);
		CrowleyTL.click();
		ET.log(Status.PASS, "Successfully navigated to crowley TL page");
	}
	
	
	
	//Admin portal
	
	@FindBy(xpath="//li[@title='Create Crowley Order']")
	public static WebElement Create_crowley_order_leftnav;
	
	public void Create_crowley(){
		Create_crowley_order_leftnav.click();
	}
	
}
	
	


