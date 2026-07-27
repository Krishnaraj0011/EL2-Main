package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class COD_singlecaseflow extends Constructor_Baseclass{

	public COD_singlecaseflow(WebDriver driver) {
		super(driver);
		
	}
	
	//Inbound trailer single case flow elements----------------------------------------------------------------------------
	
	@FindBy(xpath="//div[@string_type='field']/span[contains(text(),'Pickup Scheduled')]")
	public static WebElement IBworkqueue_status ;
	
	@FindBy(xpath="//select[@id=\"8d57733f\"]")
	public static WebElement InboundTrailer_statusdrp ;
	
	@FindBy(xpath="//div[text()='Qty On Hand']/following::select[1]")
	public static WebElement Select_drdn_1 ;
	
	@FindBy(xpath="//div[text()='Qty On Hand']/following::select[2]")
	public static WebElement Select_drdn_2 ;
	
	@FindBy(xpath="//div[text()='Qty Shipping']/following::select[1]")
	public static WebElement Select_Overage_drdn_1 ;
	
	@FindBy(xpath="//div[text()='Qty Shipping']/following::select[2]")
	public static WebElement Select_Overage_drdn_2 ;
	
	@FindBy(xpath="//label[text()='Date']/following::input")
	public static WebElement IBworkqueue_date ;
	
	public void IBworkqueue_dateinput(String s)
	{
		IBworkqueue_date.sendKeys(s);
	}
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	public static WebElement IBworkqueue_submit ;
	
	public void IBworkqueue_submit_clk()
	{
		IBworkqueue_submit.click();
	}
	//single case flow OSND stage elements-----------------------------------------------------------
	
	@FindBy(xpath="//span[@class='badge_text']")
	public static WebElement status_text_osnd_stage ;
	
	@FindBy(xpath="//button[normalize-space()='Go']")
	public static WebElement Osnd_Go ;
    public void Osnd_GO_clk()
    {
    	Osnd_Go.click();
    }
    
    @FindBy(xpath="//select[@name='$PpyWorkPage$pStatusEvent']")
	public static WebElement Osnd_Select_drdn ;
    
    @FindBy(xpath="//button[normalize-space()='Submit']")
   	public static WebElement Osnd_submit_btn;
    public void Osnd_submit_btn_clk ()
    {
    	Osnd_submit_btn.click();
    }
    
    //single case flow outboundLoads stage elements------------------------------------------------------------------------
    
    @FindBy(xpath="//span[@class='badge_text']")
	public static WebElement status_text_outbound_stage ;
    
    @FindBy(xpath="//button[normalize-space()='Go']")
	public static WebElement Outbound_Go ;
    public void Outbound_GO_clk()
    {
    	Outbound_Go.click();
    }
    
    @FindBy(xpath="//select[@name='$PpyWorkPage$pStatusEvent']")
   	public static WebElement Outboundload_Select_drdn ;
    
    @FindBy(xpath="//button[normalize-space()='Submit']")   
   	public static WebElement Outboundload_submit_btn;
    public void Outboundload_submit_btn_clk ()
    {
    	Osnd_submit_btn.click();
    }
    
    @FindBy(xpath="//input[@name=\"$PpyWorkPage$pOrderPage$pShipmentList$l2$pPickupNumber\"]")
   	public static WebElement OutboundTrailer_input ;
    public void Outboundtrailer_input()
    {
    	OutboundTrailer_input.sendKeys("6543456");
    }
    
    @FindBy(xpath="//select[@name=\"$PpyWorkPage$pOrderPage$pShipmentList$l2$pAssignedTradingPartnerName\"]")   
   	public static WebElement Outboundload_carrier;
    
    @FindBy(xpath="(//input[@name=\"$PpyWorkPage$pOrderPage$pOrderRefs$pDeliveryNumber\"])[2]")
   	public static WebElement Outbound_load_ID_input ;
    public void OutboundLoad_ID_input()
    {
    	Outbound_load_ID_input.sendKeys("5432345");
    }
    
    @FindBy(xpath="(//input[@name=\"$PpyWorkPage$pOrderPage$pOrderRefs$pDeliveryNumber\"])[1]")
   	public static WebElement ReturnID_input ;
    public void Return_Id()
    {
    	ReturnID_input.sendKeys("5432345");
    }
    
}
