package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Test_Utilities.Reuse_methods;
import Test_Utilities.Wait_Utilities;
import Test_Utilities.api_order_create;

public class Order_create_PaccarOnDock extends Base_methods {

	public Order_create_PaccarOnDock(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@name=\"$PpyDisplayHarness$pPaccarTemplate\"]")
	public static WebElement Template_drdn;

	@FindBy(xpath = "//button[@name='OrderCreate_pyDisplayHarness_13']")
	public static WebElement Create_new_order;

	public void Create_new_order_click() throws Exception {
		Thread.sleep(1500);
		Template_drdn.click();
		Thread.sleep(2500);
		wait.waitForVisible(Create_new_order);
		wait.clickWithStaleRetry(Create_new_order, this);
		ET.log(Status.PASS, "Create new order without template is opened successfully");
	}

	@FindBy(xpath = "//select[@name='$PpyDisplayHarness$pOrderPage$pRequestingTradingPartnerName']")
	public static WebElement RTP_drdn;

	@FindBy(xpath = "//select[@name='$PpyDisplayHarness$pOrderPage$pAssignedTradingPartnerName']")
	public static WebElement ATP_drdn;

	public void select_Trading_partner_combination() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		api_order_create api = new api_order_create(driver);
		wait.clickWithStaleRetry(RTP_drdn, this);
		rm.selectclass(RTP_drdn, "Paccar");
		Thread.sleep(1000);
		api.RequestingTradingPartnerName = "Paccar";
		api.AssignedTradingPartnerID = "c896eedc-0627-40f0-9f63-7519a6870355";
		
		wait.clickWithStaleRetry(ATP_drdn, this);
		rm.selectclass(ATP_drdn, "Kent");
		Thread.sleep(1000);
		api.AssignedTradingPartnerName = "EL2-Kent";
		api.RequestingTradingPartnerID = "6MndozukZMEAvza2"; 
		ET.log(Status.PASS, "Selected trading partner combination as expected");
	}

	@FindBy(xpath = "//label[@for='e3cd8305Yes, Driver will pickup Freight']")
	public static WebElement Que1_Option1;

	public void Clickon_Que1_Option1() throws Exception {
		wait.waitForVisible(Que1_Option1);
		wait.clickWithStaleRetry(Que1_Option1, this);
		Thread.sleep(1500);
	}

	@FindBy(xpath = "//label[@for='e3cd8305No, Freight will be dropped to terminal by foreign carrier']")
	public static WebElement Que1_Option2;

	@FindBy(xpath = "//label[@for='7ac4d2bfDriver will deliver immediately']")
	public static WebElement Que2_Option1;

	@FindBy(xpath = "//label[@for='7ac4d2bfDriver will return to terminal with freight']")
	public static WebElement Que2_Option2;

	public void Clickon_Que2_Option2() throws Exception {
		wait.waitForVisible(Que2_Option2);
		wait.clickWithStaleRetry(Que2_Option2, this);
		Thread.sleep(1500);
	}

	@FindBy(xpath = "//label[@for='0dc3e229Stored until new order is placed']")
	public static WebElement Que3_Option1;

	@FindBy(xpath = "//label[@for='0dc3e229Delivered as it is']")
	public static WebElement Que3_Option2;

	public void Clickon_Que3_Option2() throws Exception {
		wait.waitForVisible(Que3_Option2);
		wait.clickWithStaleRetry(Que3_Option2, this);
		Thread.sleep(1500);
	}

	public void select_PAR_combination() throws Exception {
		api_order_create api = new api_order_create(driver);
		Clickon_Que1_Option1();
		//Thread.sleep(1500);
		Clickon_Que2_Option2();
		//Thread.sleep(1500);
		Clickon_Que3_Option2();
		api.CaseType = "PickupAndRelease";
		ET.log(Status.PASS, "Selected PAR combination to create a case ");
	}

	// Order details---------------------------------------------------------------
	@FindBy(xpath = "//select[@name=\"$PpyDisplayHarness$pOrderPage$pMode\"]")
	public static WebElement Mode;

	@FindBy(xpath = "//select[@name=\"$PpyDisplayHarness$pOrderPage$pEquipment\"]")
	public static WebElement Equipment;

	@FindBy(xpath = "//select[@name=\"$PpyDisplayHarness$pOrderPage$pPaymentTerm\"]")
	public static WebElement Paymentterm;

	@FindBy(xpath = "//select[@name=\"$PpyDisplayHarness$pOrderPage$pServiceLevel\"]")
	public static WebElement ServiceLevel;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pBOL']")
	public static WebElement Bol_Text_field;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOrderRefs$pInvoiceNumber']")
	public static WebElement Invoice_number_textfield;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOrderRefs$pPONumber']")
	public static WebElement Po_number_textfield;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOrderRefs$pTrackingNumber']")
	public static WebElement Tracking_number_textfield;

	public void Order_details() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		wait.clickWithStaleRetry(Mode, this);
		rm.selectclass(Mode, "LTL");
		Thread.sleep(750);
		wait.clickWithStaleRetry(Equipment, this);
		rm.selectclass(Equipment, "Trailer");
		Thread.sleep(750);
		wait.clickWithStaleRetry(Paymentterm, this);
		rm.selectclass(Paymentterm, "Outbound Prepaid");
		Thread.sleep(750);
		wait.clickWithStaleRetry(ServiceLevel, this);
		rm.selectclass(ServiceLevel, "Basic");
		Thread.sleep(750);
		api_order_create api = new api_order_create(driver);
		api.Equipment= "Trailer";
		api.Mode ="LTL";
		api.PaymentTerm = "Outbound Prepaid";
		api.ServiceLevel = "Basic";

//		int BO = (int) Math.ceil(Math.random() * 1000000);
//		api.BOL_String = Integer.toString(BO);
//		System.out.println("BOL number = " + api.BOL_String);
//		wait.waitForClickable(Bol_Text_field);
//		wait.clickWithStaleRetry(Bol_Text_field, this);
//		Bol_Text_field.clear();
//		Thread.sleep(500);
//		Bol_Text_field.sendKeys(api.BOL_String);
		
//		System.out.println("get text bol ");
//		
		
		
		
		int IN = (int) Math.ceil(Math.random() * 1000000);
		api.Invoicenum = Integer.toString(IN);
		System.out.println("Invoice number = " + api.Invoicenum);
		wait.waitForClickable(Invoice_number_textfield);
		wait.clickWithStaleRetry(Invoice_number_textfield, this);
		Thread.sleep(500);
		Invoice_number_textfield.sendKeys(api.Invoicenum);
		
		int PO = (int) Math.ceil(Math.random() * 1000000);
		api.PONumber = Integer.toString(PO);
		System.out.println("PO_number  = " + api.PONumber);
		wait.waitForClickable(Po_number_textfield);
		wait.clickWithStaleRetry(Po_number_textfield, this);
		Thread.sleep(500);
		Po_number_textfield.sendKeys(api.PONumber);
		
		int TN = (int) Math.ceil(Math.random() * 1000000);
		api.TrackingNumber = Integer.toString(TN);
		System.out.println("Tracking number = " + api.TrackingNumber);
		wait.waitForClickable(Tracking_number_textfield);
		wait.clickWithStaleRetry(Tracking_number_textfield, this);
		Thread.sleep(500);
		Tracking_number_textfield.sendKeys(api.TrackingNumber);
		
		ET.log(Status.PASS, "Entered order details as expected ");

	}

	// Pickup Or Ooder origin
	// details------------------------------------------------------------------------

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOriginCompany']")
	public static WebElement Origin_company;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOriginAddress1']")
	public static WebElement Origin_Address1;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOriginAddress2']")
	public static WebElement Origin_Address2;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOriginCity']")
	public static WebElement Origin_City;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOriginState']")
	public static WebElement Origin_State;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOriginPostalCode']")
	public static WebElement Origin_Postalcode;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pOriginContactName']")
	public static WebElement Origin_contact_name;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pPickupNumber']")
	public static WebElement Origin_Pickup_number;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pPickupNotes']")
	public static WebElement Origin_Pickup_notes;
	
	public void order_origin_details() throws Exception
	{
		Thread.sleep(750);
		api_order_create api = new api_order_create(driver);
		wait.clickWithStaleRetry(Origin_company, this);
		Thread.sleep(500);
		Origin_company.sendKeys("Consol Crowley C/O MLM Logistics");
		api.Origin_company_Name = "Consol Crowley C/O MLM Logistics";
		Thread.sleep(1000);
		
		wait.clickWithStaleRetry(Origin_Address1, this);
		Thread.sleep(500);
		Origin_Address1.sendKeys("460 STERLING STREET");
		api.Origin_Address1 = "460 STERLING STREET";
		//Thread.sleep(750);
		
		wait.clickWithStaleRetry(Origin_Address2, this);
		Thread.sleep(500);
		Origin_Address2.sendKeys("Test");
		//Thread.sleep(750);
		
		wait.clickWithStaleRetry(Origin_City, this);
		Thread.sleep(500);
		Origin_City.sendKeys("CAMP HILL");
		api.Origin_City = "CAMP HILL";
		api.Origin_Country= "USA";
		Thread.sleep(750);
		
		wait.clickWithStaleRetry(Origin_State, this);
		Thread.sleep(500);
		Origin_State.sendKeys("PA");
		api.Origin_State = "PA";
		//Thread.sleep(750);
		
		wait.clickWithStaleRetry(Origin_Postalcode, this);
		Thread.sleep(500);
		Origin_Postalcode.sendKeys("17011");
		api.Origin_PostalCode = "17011";
		//Thread.sleep(750);
		
		wait.clickWithStaleRetry(Origin_contact_name, this);
		Thread.sleep(500);
		Origin_contact_name.sendKeys("Krishna");
		//Thread.sleep(750);
		
		int pick = (int) Math.ceil(Math.random() * 1000000);
		api.PickupNumber = Integer.toString(pick);
		System.out.println("Pickup_number  = " + api.PickupNumber);
		wait.waitForClickable(Origin_Pickup_number);
		wait.clickWithStaleRetry(Origin_Pickup_number, this);
		Thread.sleep(500);
		Origin_Pickup_number.sendKeys(api.PickupNumber);
		//Thread.sleep(1000);
		
		wait.clickWithStaleRetry(Origin_Pickup_notes, this);
		Thread.sleep(500);
		Origin_Pickup_notes.sendKeys("Testing Notes");
		//Thread.sleep(750);
		
		ET.log(Status.PASS, "Entered order origin details to create a case ");
	}

	// Destination
	// details--------------------------------------------------------------------------------------

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDestinationCompany']")
	public static WebElement Destination_company;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDestinationAddress1']")
	public static WebElement Destination_Address1;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDestinationAddress2']")
	public static WebElement Destination_Address2;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDestinationCity']")
	public static WebElement Destination_city;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDestinationState']")
	public static WebElement Destination_state;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDestinationPostalCode']")
	public static WebElement Destination_Postal_code;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDestinationContactName']")
	public static WebElement Destination_ContactName;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDeliveryNumber']")
	public static WebElement Destination_deliverynumber;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pOrderPage$pDeliveryNotes']")
	public static WebElement Destination_DeliveryNotes;
	
	public void order_destination_details() throws Exception
	{
		Thread.sleep(1000);
		api_order_create api = new api_order_create(driver);
		wait.clickWithStaleRetry(Destination_company, this);
		Thread.sleep(500);
		Destination_company.sendKeys("Destination_company");
		api.Destination_Company_name = "Destination_company";
		Thread.sleep(1000);
		
		wait.clickWithStaleRetry(Destination_Address1, this);
		Thread.sleep(500);
		Destination_Address1.sendKeys("Test_destination");
		api.Destination_Address1 = "Test_destination";
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Destination_city, this);
		Thread.sleep(500);
		Destination_city.sendKeys("Chennai");
		api.Destination_City = "Chennai";
		api.Destination_country = "USA";
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Destination_state, this);
		Thread.sleep(500);
		Destination_state.sendKeys("TN");
		api.Destination_State = "TN";
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Destination_Postal_code, this);
		Thread.sleep(500);
		Destination_Postal_code.sendKeys("78094");
		api.Destination_Postalcode = "78094";
		Thread.sleep(500);
		
		int Delivery = (int) Math.ceil(Math.random() * 1000000);
		api.DeliveryNumber = Integer.toString(Delivery);
		System.out.println("Delivery_number  = " + api.DeliveryNumber);
		wait.waitForClickable(Destination_deliverynumber);
		wait.clickWithStaleRetry(Destination_deliverynumber, this);
		Thread.sleep(500);
		Destination_deliverynumber.sendKeys(api.PickupNumber);
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Destination_DeliveryNotes, this);
		Thread.sleep(500);
		Destination_DeliveryNotes.sendKeys("Testing Notes");
		Thread.sleep(500);
		
		ET.log(Status.PASS, " Entered order destination details to create a case");
			
	}

	// Items and Handling Units
	// --------------------------------------------------------------

	@FindBy(xpath = "//a[@name=\"CreateOrderWithoutTemplate_pyDisplayHarness_112\"]")
	public static WebElement Add_items;

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pOrderPage$pItemList$l1$pSkuName\"]")
	public static WebElement Item_name;
	
	public void Handlingunit_details() throws Exception
	{
		Thread.sleep(1000);
		wait.clickWithStaleRetry(Add_items, this);
		Thread.sleep(1500);
		wait.clickWithStaleRetry(Item_name, this);
		Item_name.sendKeys("BOX");
		Thread.sleep(1500);
		
		ET.log(Status.PASS, " Entered handling unit and item details ");
	}

	// Billto------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pOrderPage$pCompanyName\"]")
	public static WebElement Billto_companyname;

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pOrderPage$pAddress1\"]")
	public static WebElement Billto_Address;

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pOrderPage$pCity\"]")
	public static WebElement Billto_city;

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pOrderPage$pState\"]")
	public static WebElement Billto_state;

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pOrderPage$pCountry\"]")
	public static WebElement Billto_Country;

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pOrderPage$pPostalCode\"]")
	public static WebElement Billto_postalcode;
	
	public void Bill_to_details() throws Exception
	{
		wait.clickWithStaleRetry(Billto_companyname, this);
		Thread.sleep(500);
		Billto_companyname.sendKeys("Estes-Express");
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Billto_Address, this);
		Thread.sleep(500);
		Billto_Address.sendKeys("Richmond");
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Billto_city, this);
		Thread.sleep(500);
		Billto_city.sendKeys("CA");
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Billto_state, this);
		Thread.sleep(500);
		Billto_state.sendKeys("PA");
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Billto_Country, this);
		Thread.sleep(500);
		Billto_Country.sendKeys("USA");
		Thread.sleep(500);
		
		wait.clickWithStaleRetry(Billto_postalcode, this);
		Thread.sleep(500);
		Billto_postalcode.sendKeys("98053");
		Thread.sleep(1000);
		
		ET.log(Status.PASS, " Entered Billing details for the case");
	}

	// Button--------------------------------

	@FindBy(xpath = "//button[@name='CreateOrderWithoutTemplate_pyDisplayHarness_137']")
	public static WebElement Preview_order;
	public void Preview_cirm_order() throws Exception
	{
		wait.waitForClickable(Preview_order);
		wait.clickWithStaleRetry(Preview_order , this);
		Thread.sleep(1500);
	}

	@FindBy(xpath = "//button[@name='ConfirmPaccarOrder_pyDisplayHarness_363']")
	public static WebElement Confirm_order;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public static WebElement submit_btn;
	
	public void Preview_confirm_order() throws Exception
	{
		api_order_create api = new api_order_create(driver);
		wait.waitForClickable(Preview_order);
		wait.clickWithStaleRetry(Preview_order , this);
		Thread.sleep(3000);
		String BOL_POD = driver.findElement(By.xpath("//div[@class='content-item content-field item-5 flex required']//div/span[@class]")).getText();
		System.out.println(BOL_POD);
		api.BOL_String = BOL_POD;
		api.Order1 = BOL_POD; 
		Thread.sleep(1500);
		wait.waitForClickable(Confirm_order);
		wait.clickWithStaleRetry(Confirm_order , this);
		Thread.sleep(1500);
		wait.waitForClickable(submit_btn);
		wait.clickWithStaleRetry(submit_btn , this);
		System.out.println("Case create successfully");
		ET.log(Status.PASS, " Successfully created PAR case through create order without template  ");
		Thread.sleep(1500);
	}

}
