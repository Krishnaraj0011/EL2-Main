package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends Constructor_Baseclass
{
	public Home_page(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//li[@title='Crowley On Dock']")
	public static WebElement Crowleyondock;
	
	public void leftnav_Crowleyondock()
	{
		Crowleyondock.click();
	}
	
	@FindBy(xpath= "(//span[contains(@data-click,'..')][normalize-space()='Crowley TL'])[1]")
	public static WebElement  CrowleyTL;
	
	public void CrowleyTL_leftNav()
	{
		CrowleyTL.click();
	}
	
	//Admin portal
	
	@FindBy(xpath="//li[@title='Create Crowley Order']")
	public static WebElement Create_crowley_order_leftnav;
	
	public void Create_crowley(){
		Create_crowley_order_leftnav.click();
	}
	
}
	
	


