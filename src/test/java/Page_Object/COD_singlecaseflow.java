package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Test_Utilities.Reuse_methods;
import Test_Utilities.Wait_Utilities;
import Test_Utilities.api_order_create;

public class COD_singlecaseflow extends Base_methods {

	public COD_singlecaseflow(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}

	// Inbound trailer single case flow
	// elements----------------------------------------------------------------------------

	@FindBy(xpath = "//div[@string_type='field']/span[contains(text(),'Pickup Scheduled')]")
	public static WebElement IBworkqueue_status;

	@FindBy(xpath = "//select[@id=\"8d57733f\"]")
	public static WebElement InboundTrailer_statusdrp;

	@FindBy(xpath = "//div[text()='Qty On Hand']/following::select[1]")
	public static WebElement Select_drdn_1;

	@FindBy(xpath = "//div[text()='Qty On Hand']/following::select[2]")
	public static WebElement Select_drdn_2;

	@FindBy(xpath = "//div[text()='Qty Shipping']/following::select[1]")
	public static WebElement Select_Overage_drdn_1;

	@FindBy(xpath = "//div[text()='Qty Shipping']/following::select[2]")
	public static WebElement Select_Overage_drdn_2;

	@FindBy(xpath = "//label[text()='Date']/following::input")
	public static WebElement IBworkqueue_date;

	public void IBworkqueue_dateinput() {
		wait.clickWithStaleRetry(IBworkqueue_date, this);
		IBworkqueue_date.sendKeys("3/18/2026 9:25 AM");
	}

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public static WebElement IBworkqueue_submit;

	public static void IBworkqueue_submit_clk() {
		wait.waitForClickable(IBworkqueue_submit);
		IBworkqueue_submit.click();
	}

	public static void inbound_trailer_action(String s) {
		COD_singlecaseflow csf = new COD_singlecaseflow(driver);
		Reuse_methods rm = new Reuse_methods(driver);
		String IBstatus = csf.IBworkqueue_status.getText().toString();
		System.out.println(IBstatus);
		wait.waitForClickable(InboundTrailer_statusdrp);
		rm.selectclass(InboundTrailer_statusdrp, s);
		wait.waitForClickable(Select_drdn_1);
		rm.selectclass(Select_drdn_1, "2");
		wait.waitForClickable(Select_drdn_2);
		rm.selectclass(Select_drdn_2, "3");
		csf.IBworkqueue_dateinput();
		csf.IBworkqueue_submit_clk();
	}

	// single case flow OSND stage
	// elements-----------------------------------------------------------

	@FindBy(xpath = "//span[@class='badge_text']")
	public static WebElement status_text_osnd_stage;

	@FindBy(xpath = "//button[normalize-space()='Go']")
	public static WebElement Osnd_Go;

	public static void Osnd_GO_clk() {
		wait.waitForClickable(Osnd_Go);
		Osnd_Go.click();
	}

	@FindBy(xpath = "//select[@name='$PpyWorkPage$pStatusEvent']")
	public static WebElement Osnd_Select_drdn;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public static WebElement Osnd_submit_btn;

	public static void Osnd_submit_btn_clk() {
		wait.waitForClickable(Osnd_submit_btn);
		Osnd_submit_btn.click();
	}

	public static void Osnd_stage_actions(String s) throws Exception {
		Thread.sleep(2000);
		Reuse_methods rm = new Reuse_methods(driver);
		String Shortage = status_text_osnd_stage.getText().toString();
		System.out.println(Shortage);
		Osnd_GO_clk();
		rm.switchToDefaultContent();
		Thread.sleep(1000);
		rm.Frame_PegaGadget1Ifr();
		wait.waitForVisible(Osnd_Select_drdn);
		rm.selectclass(Osnd_Select_drdn, s);
		Osnd_submit_btn_clk();
		Thread.sleep(1500);
	}

	// single case flow outboundLoads stage
	// elements------------------------------------------------------------------------

	@FindBy(xpath = "//span[@class='badge_text']")
	public static WebElement status_text_outbound_stage;

	@FindBy(xpath = "//button[normalize-space()='Go']")
	public static WebElement Outbound_Go;

	public static void Outbound_GO_clk() {
		wait.waitForClickable(Outbound_Go);
		Outbound_Go.click();
	}

	@FindBy(xpath = "//select[@name='$PpyWorkPage$pStatusEvent']")
	public static WebElement Outboundload_Select_drdn;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public static WebElement Outboundload_submit_btn;

	public static void Outboundload_submit_btn_clk() {
		wait.waitForClickable(Osnd_submit_btn);
		Osnd_submit_btn.click();
	}

	@FindBy(xpath = "//input[@name=\"$PpyWorkPage$pOrderPage$pShipmentList$l2$pPickupNumber\"]")
	public static WebElement OutboundTrailer_input;

	public static void Outboundtrailer_input() {
		wait.waitForVisible(OutboundTrailer_input);
		OutboundTrailer_input.sendKeys("6543456");
	}

	@FindBy(xpath = "//select[@name=\"$PpyWorkPage$pOrderPage$pShipmentList$l2$pAssignedTradingPartnerName\"]")
	public static WebElement Outboundload_carrier;

	@FindBy(xpath = "(//input[@name=\"$PpyWorkPage$pOrderPage$pOrderRefs$pDeliveryNumber\"])[2]")
	public static WebElement Outbound_load_ID_input;

	public static void OutboundLoad_ID_input() {
		api_order_create api = new api_order_create(driver);
		// api.DeliveryNumber = "5432345";
		wait.waitForClickable(Outbound_load_ID_input);
		Outbound_load_ID_input.sendKeys(api.DeliveryNumber);
	}

	@FindBy(xpath = "(//input[@name=\"$PpyWorkPage$pOrderPage$pOrderRefs$pDeliveryNumber\"])[1]")
	public static WebElement ReturnID_input;

	public static void Return_Id() {
		wait.waitForClickable(ReturnID_input);
		ReturnID_input.sendKeys("543452");
	}

	public static void Outbound_loaded_actions() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		String Shipshort = status_text_outbound_stage.getText().toString();
		System.out.println(Shipshort);
		Outbound_GO_clk();
		rm.switchToDefaultContent();
		Thread.sleep(1000);
		rm.Frame_PegaGadget1Ifr();
		rm.selectclass(Outboundload_Select_drdn, "Loaded");
		Outboundtrailer_input();
		rm.selectclass(Outboundload_carrier, "Estes Express Lines");
		// OutboundLoad_ID_input();
		Outboundload_submit_btn_clk();
		Thread.sleep(1500);
	}

	public static void outbound_released_action() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		String Loaded = status_text_outbound_stage.getText().toString();
		System.out.println(Loaded);
		Outbound_GO_clk();
		Thread.sleep(1000);
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();
		rm.selectclass(Outboundload_Select_drdn, "Released");
		Outboundload_submit_btn_clk();
		Thread.sleep(1000);
		String Released = status_text_outbound_stage.getText().toString();
		System.out.println(Released);
		Outbound_GO_clk();
		Thread.sleep(2000);
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();
	}

	public static void return_auth() throws Exception {

		Reuse_methods rm = new Reuse_methods(driver);
		String Shipshort = status_text_outbound_stage.getText().toString();
		System.out.println(Shipshort);
		Outbound_GO_clk();
		Thread.sleep(1500);
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();
		rm.selectclass(Outboundload_Select_drdn, "Return Auth");
		ET.log(Status.PASS, "Verify that the Status is in Return auth ");
		// Return_Id();
		Outboundload_submit_btn_clk();
	}

	public static void return_loaded() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		String Loaded = status_text_outbound_stage.getText().toString();
		System.out.println(Loaded);
		Outbound_GO_clk();
		Thread.sleep(1000);
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();
		rm.selectclass(Outboundload_Select_drdn, "Return Loaded");
		ET.log(Status.PASS, " Verify that the Status is in Return Loaded  ");
		Outboundload_submit_btn_clk();
	}

	public static void return_complete() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		Thread.sleep(1000);
		String Return_Loaded = status_text_outbound_stage.getText().toString();
		System.out.println(Return_Loaded);
		Outbound_GO_clk();
		Thread.sleep(1000);
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();
		rm.selectclass(Outboundload_Select_drdn, "Return Complete");
		Outboundload_submit_btn_clk();
		Thread.sleep(1000);
		ET.log(Status.PASS, "Verify that the Status is in Return Complete ");
		String Loaded = status_text_outbound_stage.getText().toString();
		System.out.println(Loaded);
		Outbound_GO_clk();
		Thread.sleep(1000);
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();
	}

	public static void Overage() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		COD_singlecaseflow csf = new COD_singlecaseflow(driver);
		String IBstatus = IBworkqueue_status.getText().toString();
		System.out.println(IBstatus);
		Assert.assertEquals(IBstatus, "PICKUP SCHEDULED");
		ET.log(Status.PASS, "Status is in pickup scheduled ");
		rm.selectclass(InboundTrailer_statusdrp, "Overage");
		rm.selectclass(Select_Overage_drdn_1, "5");
		rm.selectclass(Select_Overage_drdn_2, "6");
		csf.IBworkqueue_dateinput();
		csf.IBworkqueue_submit_clk();
		ET.log(Status.PASS, "Verify that the Status is in Overage ");
		Thread.sleep(1500);
	}

	public static void ship_over() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		String Shortage = status_text_osnd_stage.getText().toString();
		System.out.println(Shortage);
		Osnd_GO_clk();
		rm.switchToDefaultContent();
		Thread.sleep(1000);
		rm.Frame_PegaGadget1Ifr();
		rm.selectclass(Osnd_Select_drdn, "Ship Over");
		Osnd_submit_btn_clk();
		ET.log(Status.PASS, "Verify that the Status is in Ship over ");
		Thread.sleep(1500);
	}

	public static void return_overage() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		String Shortage = status_text_osnd_stage.getText().toString();
		System.out.println(Shortage);
		Osnd_GO_clk();
		rm.switchToDefaultContent();
		Thread.sleep(1000);
		rm.Frame_PegaGadget1Ifr();
		rm.selectclass(Osnd_Select_drdn, "Return Overage");
		Thread.sleep(1000);
		rm.selectclass(Select_Overage_drdn_1, "2");
		rm.selectclass(Select_Overage_drdn_2, "3");
		// Return_Id();
		Osnd_submit_btn_clk();
		ET.log(Status.PASS, "Verify that the Status is in Return Overage  ");
		Thread.sleep(1500);
	}

}
