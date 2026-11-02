package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Class.Base_methods;
import Test_Utilities.Reuse_methods;
import Test_Utilities.Wait_Utilities;
import Test_Utilities.api_order_create;

public class Paccor_on_dock_UI extends Base_methods{
	
	public Paccor_on_dock_UI(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@data-target=\"$PpyDisplayHarness$pStatusEventList\"]")
	public static WebElement Status_drdn;
	
	@FindBy (xpath = "//li[@title='Paccar On Dock']")
	public static WebElement Paccar_on_dock; 
	
	public void paccar_on_dock_leftnav_clk() throws Exception
	{	
		driver.switchTo().defaultContent();
		wait.waitForVisible(Paccar_on_dock);
		wait.clickWithStaleRetry(Paccar_on_dock, this);
		Thread.sleep(2000);
	}
	
	@FindBy (xpath = "//button[@name='PaccarOnDock_pyDisplayHarness_22']")
	public static WebElement POD_Receive_btn;
	
	public void POD_receive_btn_clk()
	{
		wait.waitForClickable(POD_Receive_btn);
		wait.clickWithStaleRetry(POD_Receive_btn, this);
	}
	
	@FindBy (xpath = "//input[@name=\"$PpyDisplayHarness$pReceivedDate\"]")
	public static WebElement Receive_date;
	
	public void Receive_date_input()
	{
		wait.waitForVisible(Receive_date);
		wait.clickWithStaleRetry(Receive_date, this);
		Receive_date.sendKeys("10/9/2026 3:54 AM");
	}
	
	@FindBy (xpath = "//input[@name=\"$PpyDisplayHarness$pSelectedPaccarOnDocOrderList$l1$pTerminalNotes\"]")
	public static WebElement Terminal_notes;
	
	@FindBy (xpath = "//button[@name=\"ProcessPaccarOnDockOrders_pyDisplayHarness_232\"]")
	public static WebElement Submit_btn;
	
	public void POD_receive_order_bulkAction() throws Exception
	{
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		Status_drdn.click();
		Thread.sleep(2000);
		co.enterBolInput();
		co.clickValueFromBolDropdown();
		Thread.sleep(1000);
		co.clickOnOverallCheckbox();
		POD_receive_btn_clk();	
		Receive_date_input();
		Terminal_notes.click();
	    wait.clickWithStaleRetry(Submit_btn, this); 
	    Thread.sleep(2000);
	}
	
	@FindBy (xpath = "//div[@id='gridBody_right']/table/tbody/tr[2]/td/div/input[2]")
	public static WebElement Second_checkbox;
	
	public void Second_checkbox_clk()
	{
		wait.waitForClickable(Second_checkbox);
		wait.clickWithStaleRetry(Second_checkbox, this);
	}
	
	@FindBy (xpath = "//button[@name=\"PaccarOnDock_pyDisplayHarness_35\"]")
	public static WebElement Assign_carrier_btn;
	
	public void Assign_carrier_btn_clk()
	{
		wait.waitForClickable(Assign_carrier_btn);
		wait.clickWithStaleRetry(Assign_carrier_btn, this);
	}
	
	@FindBy (xpath = "//select[@name=\"$PpyDisplayHarness$pAssignedTradingPartnerID\"]")
	public static WebElement Assign_carrier_dropdown;
	
	public void Assign_carrier_drdn()
	{
		Reuse_methods rm = new Reuse_methods(driver);
		wait.clickWithStaleRetry(Assign_carrier_dropdown, this);
		rm.selectclass(Assign_carrier_dropdown, "Estes Express Lines");
	}
	
	@FindBy (xpath = "//button[@name='ProcessPaccarOnDockOrders_pyDisplayHarness_232']")
	
	public static WebElement Assign_carrier_submit_btn;
	
	public void submit_btn_clk() throws Exception
	{
		wait.waitForClickable(Assign_carrier_submit_btn);
		wait.clickWithStaleRetry(Assign_carrier_submit_btn, this);
		Thread.sleep(2000);
	}
	
	public void POD_Assign_carrierbulkAction() throws Exception
	{
		Second_checkbox_clk();
		Thread.sleep(1500);
		Assign_carrier_btn_clk();
		Thread.sleep(1500);
		Assign_carrier_drdn();
		submit_btn_clk();
		Thread.sleep(2000);
	}
	
	@FindBy (xpath = "//button[@name=\"PaccarOnDock_pyDisplayHarness_36\"]")
	public static WebElement Assign_OB_trailer_btn;
	
	public void Assign_Ob_trailer_click()
	{
		wait.waitForClickable(Assign_OB_trailer_btn);
		wait.clickWithStaleRetry( Assign_OB_trailer_btn, this);
	}
	
	@FindBy (xpath = "//input[@name=\"$PpyDisplayHarness$pEventDate\"]")
	public static WebElement Loaded_date;
	
	public void Loaded_date_input() throws Exception
	{
		wait.waitForClickable(Loaded_date);
		wait.clickWithStaleRetry( Loaded_date, this);
		Thread.sleep(1000);
		Loaded_date.sendKeys("10/10/2026 6:58 AM");
		Thread.sleep(1000);
	}
	
	@FindBy (xpath = "//input[@name=\"$PpyDisplayHarness$pName\"]")
	public static WebElement Trailer_input_fld;
	
	public void Trailer_num_input() throws Exception
	{
		wait.waitForClickable(Trailer_input_fld);
		wait.clickWithStaleRetry( Trailer_input_fld, this);
		Thread.sleep(1000);
		Trailer_input_fld.sendKeys("6545323");
		Thread.sleep(1500);
	}
	
	@FindBy (xpath = "(//span[normalize-space()='Paccar On Dock'])[5]")
	public static WebElement Paccar_on_dock_header;
	
	public void Paccar_on_dock_header_clk()
	{
		//wait.waitForVisible(Paccar_on_dock_header);
		wait.clickWithStaleRetry(Paccar_on_dock_header, this);
	}
	 
	public void POD_Assign_Ob_trailer_bulkAction() throws Exception
	{
		Second_checkbox_clk();
		Thread.sleep(1000);
		case_id_hyperlink_clk();
		Thread.sleep(1500);
		driver.switchTo().defaultContent();
		Reuse_methods rm = new Reuse_methods(driver);
		Paccar_on_dock_header_clk();
		rm.Frame_PegaGadget1Ifr();
		Thread.sleep(1500);
		Assign_Ob_trailer_click();
		Thread.sleep(1500);
		Loaded_date_input();
		System.out.println("Loaded date given");
		Trailer_num_input();
		System.out.println("trailer num given ");
		submit_btn_clk();
		System.out.println("submitted ");
	}
	
	@FindBy (xpath = "//button[@name='PaccarOnDock_pyDisplayHarness_40']")
	public static WebElement Assign_load_ID_btn;
	public void Assign_Load_ID_btn_clk()
	{
		wait.waitForClickable(Assign_load_ID_btn);
		wait.clickWithStaleRetry(Assign_load_ID_btn, this);
	}
	
	@FindBy (xpath = "//input[@name='$PpyDisplayHarness$pDescription']")
	public static WebElement outboundload_Id;
	
	public void outboundload_Id_input()
	{
		api_order_create api = new api_order_create(driver);
		wait.waitForClickable(outboundload_Id);
		wait.clickWithStaleRetry(outboundload_Id, this);
		outboundload_Id.sendKeys(api.DeliveryNumber);
	}
	
	public void POD_Assign_Load_ID() throws Exception
	{
		Second_checkbox_clk();
		Thread.sleep(1500);
		Assign_Load_ID_btn_clk();
		Thread.sleep(1500);
		outboundload_Id_input();
		submit_btn_clk();
	}
	
	@FindBy (xpath = "//div[@id='gridBody_right']//tbody/tr[2]/td[2]/div/span/a")
	public static WebElement Case_id_hyperlink;
	
	public void case_id_hyperlink_clk()
	{
		wait.waitForVisible(Case_id_hyperlink);
		wait.clickWithStaleRetry(Case_id_hyperlink, this);
	}
	
	@FindBy (xpath = "//button[@name='PaccarOnDock_pyDisplayHarness_42']")
	public static WebElement Released_btn;
	
	public void Released_btn_clk()
	{
		wait.waitForClickable(Released_btn);
		wait.clickWithStaleRetry(Released_btn, this);
	}
	
	@FindBy (xpath = "//input[@name='$PpyDisplayHarness$pActualDeliveryDate']")
	public static WebElement Released_date_txt_field;
	
	public void Released_date_input()
	{
		wait.waitForClickable(Released_date_txt_field);
		wait.clickWithStaleRetry(Released_date_txt_field, this);
		Released_date_txt_field.sendKeys("10/13/2026 6:50 AM");
	}
	
	@FindBy (xpath = "//input[@name='$PpyDisplayHarness$pSelectedPaccarOnDocOrderList$l1$ppyText']")
	public static WebElement Terminal_notes_field ;
	
	public void Terminal_notes_field_clk ()
	{
		wait.waitForClickable(Terminal_notes_field);
		wait.clickWithStaleRetry(Terminal_notes_field, this);
	}
	
	public void POD_Released_bulk_action() throws Exception
	{
		Second_checkbox_clk();
		Thread.sleep(1500);
		Released_btn_clk();
		Thread.sleep(1500);
		Released_date_input();
		Terminal_notes_field_clk();
		submit_btn_clk();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
	}
	
	@FindBy (xpath = "(//ul[@role=\"tablist\"])[1]/li[4]//tbody/tr/td[2]/span")
	public static WebElement CaseID_header ;
	
	public void CaseID_header_clk ()
	{
		wait.waitForClickable(CaseID_header);
		wait.clickWithStaleRetry(CaseID_header, this);
	}
	
//	@FindBy (xpath = "//span[@class='case_title']")
//	public static WebElement Case_Id_text ;
//	
//	public void CaseID_gettext() throws Exception
//	{
//		Thread.sleep(2000);
//		api_order_create api = new api_order_create(driver);
//		api.Order1 = Case_Id_text.getText();
//		System.out.println(api.Order1);
//	}
}
