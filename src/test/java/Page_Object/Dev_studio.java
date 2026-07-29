package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Test_Utilities.Reuse_methods;

public class Dev_studio extends Constructor_Baseclass{

    public Dev_studio(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//a[normalize-space()='Launch portal']")
	public static WebElement Launchportal;

    @FindBy(xpath="//span[contains(text(),'WareHouse UserPortal')]")
   public static  WebElement WareHousePortal;

    public void clickLaunchPortal()
    {
        Launchportal.click();
    }

    public void clickWarehousePortal()
    {
        WareHousePortal.click();
    }
    
	@FindBy(xpath="//span[contains(text(),'Admin Portal')]")
	public static WebElement Admin_portal;
	
	public void Adminportal_clk() {
		Admin_portal.click();
	}
    
    @FindBy(xpath= "//div[@title='Favorites']/h3/i")
	public static WebElement favorites;
    
    public void Favorites()
    {
    	favorites.click();
    }
    
	@FindBy(xpath="//h3[normalize-space()='Data types']")
	public static WebElement datatype ;
	
	 public void datatype_clk()
	    {
		 datatype.click();
	    }
	
    //POD confirm number elements ------------------------------------------------------------------------------
    
    @FindBy(xpath= "(//span[contains(text(),'ConfrimPOD')])[3]")
	public static WebElement ConfirmPOD;
    
    public void ConfirmPOD()
    {
    	ConfirmPOD.click();
    }
    
    @FindBy(xpath= "//button[normalize-space()='Actions']")
	public static WebElement Actiondropdown;
    
    public void Actiondropdown() {
    	Actiondropdown.click();
    }
    
    @FindBy(xpath= "(//span[contains(text(),'Run')])[2]")
	public static WebElement runindropdown;
    
    public void runoption()
    {
    	runindropdown.click();
    }
    
	@FindBy(xpath= "(//span/input[@id='pyValue'])[1]")
	public static WebElement PyIDtextfield;
	
	public void PyIDtextfield_input(String s) {
		Reuse_methods rm = new Reuse_methods(driver);
		PyIDtextfield.sendKeys(s);
	}
	
	@FindBy(xpath= "(//span/input[@id='pyValue'])[2]")
	public static WebElement PODConfirmNumber;
	
	public void PODConfirmNumber_input()
	{
		PODConfirmNumber.sendKeys("8667632");
	}
	
	@FindBy(xpath= "//div[contains(text(),'Run')]")
	public static WebElement runbutton;
	
	public void runbtn() {
		runbutton.click();
	}
    
	
	//order table elements 
	
	@FindBy(xpath="//div[@id=\"gridBody_left\"]/ul/li[23]/ul/li[2]//div[@string_type=\"field\"][2]/span/i")
	public static WebElement ordertable_record ;
	
	public void Ordertable_record_clk()
	    {
		 ordertable_record.click();
	    }
	
	@FindBy(xpath="(//input[@placeholder='Search...'])[2]")
	public static WebElement Ordertable_searchfield;

	public void Ordertable_searchfield_clk(String s)
    {
		Reuse_methods rm = new Reuse_methods(driver);
		Ordertable_searchfield.sendKeys(s);
    }
	
	@FindBy(xpath="//i[@class='pi pi-search']")
	public static WebElement Ordertable_searchicon;
	
	public void Ordertable_searchicon_clk()
    {
		Ordertable_searchicon.click();
    }
	
	
	
	
	
}