package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Test_Utilities.Reuse_methods;
import Test_Utilities.Wait_Utilities;
import Test_Utilities.api_order_create;

public class Create_crowley_UI extends Base_methods {
	
	public Wait_Utilities wait;

	public Create_crowley_UI(WebDriver driver) {
	    this.driver = driver;
	    this.wait = new Wait_Utilities(driver);
	    PageFactory.initElements(driver, this);
	}
	
	//Order details------------------------------------------------------------------------------------------ 
	
	@FindBy(xpath="//select[@name=\"$PpyDisplayHarness$pCrowleyAssignedTradingPartnerName\"]")
	public static WebElement Assigntradingpartner_drdn;
	
	@FindBy(xpath="//select[@name=\"$PpyDisplayHarness$pCrowleyCaseType\"]")
	public static WebElement Casetype_drdn;
	
	@FindBy(xpath="//select[@name=\"$PpyDisplayHarness$pEquipment\"]")
	public static WebElement Equipment_drdn;
	
	@FindBy(xpath="//select[@name=\"$PpyDisplayHarness$pCrowleyMode\"]")
	public static WebElement CrowleyMode_drdn;
	
	@FindBy(xpath="//select[@name=\"$PpyDisplayHarness$pPaymentTerm\"]")
	public static WebElement PaymentTerm_drdn;
	
	@FindBy(xpath="//select[@name=\"$PpyDisplayHarness$pServiceLevel\"]")
	public static WebElement Servicelevel_drdn;
	
	public void enteringOrderDetails() throws Exception
	{
		Reuse_methods rm = new Reuse_methods(driver);
		api_order_create api = new api_order_create(driver);
		Pickupnumber.click();
		Thread.sleep(2000);
		wait.waitForClickable(Assigntradingpartner_drdn);
		wait.clickWithStaleRetry(Assigntradingpartner_drdn, this);
		Thread.sleep(500);
		rm.selectclass(Assigntradingpartner_drdn, "EL2-Manteca");
		api.AssignedTradingPartnerName = "EL2-Manteca";
		api.AssignedTradingPartnerID = "pMrEpO2ysOuRIbHr";
		api.RequestingTradingPartnerName = "Crowley";
		api.RequestingTradingPartnerID =  "dd1a754a-01e9-4b5e-ad31-ce14c9d65e62";
		
		
		wait.waitForClickable(Casetype_drdn);
		wait.clickWithStaleRetry(Casetype_drdn, this);
		Thread.sleep(500);
		rm.selectclass(Casetype_drdn, "PickupAndRelease");
		api.CaseType = "PickupAndRelease";
		
		wait.waitForClickable(Equipment_drdn);
		wait.clickWithStaleRetry(Equipment_drdn, this);
		Thread.sleep(500);
		rm.selectclass(Equipment_drdn, "Trailer");
		api.Equipment = "Trailer";
		
		wait.waitForClickable(CrowleyMode_drdn);
		wait.clickWithStaleRetry(CrowleyMode_drdn, this);
		Thread.sleep(500);
		rm.selectclass(CrowleyMode_drdn, "CrowleyTL");
		api.Mode= "CrowleyTL";
		
		wait.waitForClickable(PaymentTerm_drdn);
		wait.clickWithStaleRetry(PaymentTerm_drdn, this);
		Thread.sleep(500);
		rm.selectclass(PaymentTerm_drdn, "Inbound Prepaid");
		api.PaymentTerm = "Inbound Prepaid";
		
		wait.waitForClickable(Servicelevel_drdn);
		wait.clickWithStaleRetry(Servicelevel_drdn, this);
		Thread.sleep(500);
		rm.selectclass(Servicelevel_drdn, "Curbside");
		api.ServiceLevel = "Curbside";
		
		
		ET.log(Status.PASS, "Order details entered as expected");
	}
	
	//Order ref values -----------------------------------------------------------------------------------
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pBOL']")
	public static WebElement Pro_number;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pTrackingNumber']")
	public static WebElement Tracking_number;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pInvoiceNumber']")
	public static WebElement Invoice_number;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pPickupNumber']")
	public static WebElement Pickupnumber;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pPONumber']")
	public static WebElement Ponumber;
	
	public void order_Ref_details() throws Exception
	{	//Reuse_methods rm = new Reuse_methods(driver);
	    api_order_create api = new api_order_create(driver);
		int BO = (int) Math.ceil(Math.random() * 1000000);
		api.BOL_String = Integer.toString(BO);
		System.out.println("BOL number = " + api.BOL_String);
		wait.waitForClickable(Pro_number);
		wait.clickWithStaleRetry(Pro_number, this);
		Thread.sleep(500);
		Pro_number.sendKeys(api.BOL_String);
		
		int TN = (int) Math.ceil(Math.random() * 1000000);
		api.TrackingNumber = Integer.toString(TN);
		System.out.println("Tracking number = " + api.TrackingNumber);
		wait.waitForClickable(Tracking_number);
		wait.clickWithStaleRetry(Tracking_number, this);
		Thread.sleep(500);
		Tracking_number.sendKeys(api.TrackingNumber);
		
		int IN = (int) Math.ceil(Math.random() * 1000000);
		api.Invoicenum = Integer.toString(IN);
		System.out.println("Invoice number = " + api.Invoicenum);
		wait.waitForClickable(Invoice_number);
		wait.clickWithStaleRetry(Invoice_number, this);
		Thread.sleep(500);
		Invoice_number.sendKeys(api.Invoicenum);
		
		int pick = (int) Math.ceil(Math.random() * 1000000);
		api.PickupNumber = Integer.toString(pick);
		System.out.println("Pickup_number  = " + api.PickupNumber);
		wait.waitForClickable(Pickupnumber);
		wait.clickWithStaleRetry(Pickupnumber, this);
		Thread.sleep(500);
		Pickupnumber.sendKeys(api.PickupNumber);
		
		int PO = (int) Math.ceil(Math.random() * 1000000);
		api.PONumber = Integer.toString(PO);
		System.out.println("PO_number  = " + api.PONumber);
		wait.waitForClickable(Ponumber);
		wait.clickWithStaleRetry(Ponumber, this);
		Thread.sleep(500);
		Ponumber.sendKeys(api.PONumber);
	
		ET.log(Status.PASS, "Entered order ref details as expected");
	}
	
	//Order origin details--------------------------------------------------------------------------------
	
	@FindBy(xpath="//select[@name='$PpyDisplayHarness$pCrowleyOriginCompany']")
	public static WebElement Origincompany;
	
	@FindBy(xpath="//select[@name='$PpyDisplayHarness$pCrowleyOriginAddress1']")
	public static WebElement Origin_address1;
	
	@FindBy(xpath="//select[@name='$PpyDisplayHarness$pCrowleyOriginCity']")
	public static WebElement Origin_city;
	
	@FindBy(xpath="//select[@name='$PpyDisplayHarness$pCrowleyOriginState']")
	public static WebElement Origin_state;
	
	@FindBy(xpath="//select[@name='$PpyDisplayHarness$pCrowleyOriginPostalCode']")
	public static WebElement Origin_postalcode;
	
	public void origin_details() throws Exception 
	{	Reuse_methods rm = new Reuse_methods(driver);
	    api_order_create api = new api_order_create(driver);
		wait.waitForClickable(Origincompany);
		wait.clickWithStaleRetry(Origincompany, this);
		Thread.sleep(1000);
		rm.selectclass(Origincompany, "Consol Crowley C/O MLM Logistics");
		api.Origin_company_Name = "Consol Crowley C/O MLM Logistics";
		
		
		wait.waitForClickable(Origin_address1);
		wait.clickWithStaleRetry(Origin_address1, this);
		Thread.sleep(1000);
		rm.selectclass(Origin_address1, "460 STERLING STREET");
		api.Origin_Address1 = "460 STERLING STREET";
		
		wait.waitForClickable(Origin_city);
		wait.clickWithStaleRetry(Origin_city, this);
		Thread.sleep(1000);
		rm.selectclass(Origin_city, "CAMP HILL");
		api.Origin_City = "CAMP HILL";
		
		wait.waitForClickable(Origin_state);
		wait.clickWithStaleRetry(Origin_state, this);
		Thread.sleep(1000);
		rm.selectclass(Origin_state, "PA");
		api.Origin_State = "PA";
		
		wait.waitForClickable(Origin_postalcode);
		wait.clickWithStaleRetry(Origin_postalcode, this);
		Thread.sleep(1000);
		rm.selectclass(Origin_postalcode, "17011");
		api.Origin_PostalCode = "17011";
		
		api.Origin_Country = "USA";
		
		
		ET.log(Status.PASS, "Entered order origin details as expected");
	}
	
	//Order destination details --------------------------------------------------------------------------
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pDestinationCompanyUI']")
	public static WebElement Destination_company;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pDestinationAddress1UI']")
	public static WebElement Destination_address1;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pDestinationCityUI']")
	public static WebElement Destination_city;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pDestinationStateUI']")
	public static WebElement Destination_state;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pDestinationPostalCodeUI']")
	public static WebElement Destination_Postalcode;
	
	public void destination_Details() throws InterruptedException
	{
		api_order_create api = new api_order_create(driver);
		wait.waitForClickable(Destination_company);
		wait.clickWithStaleRetry(Destination_company, this);
		Thread.sleep(500);
		Destination_company.sendKeys("RK INTRANSIT CARGO BLDG 977 CP 7000SUU");
		api.Destination_Company_name = "RK INTRANSIT CARGO BLDG 977 CP 7000SUU";
	
		wait.waitForClickable(Destination_city);
		wait.clickWithStaleRetry(Destination_city, this);
		Thread.sleep(500);
		Destination_city.sendKeys("TRAVIS AFB");
		api.Destination_City= "TRAVIS AFB";
		
		wait.waitForClickable(Destination_state);
		wait.clickWithStaleRetry(Destination_state, this);
		Thread.sleep(500);
		Destination_state.sendKeys("CA");
		api.Destination_State = "CA";
		api.Destination_country= "USA";
		
		wait.waitForClickable(Destination_Postalcode);
		wait.clickWithStaleRetry(Destination_Postalcode, this);
		Thread.sleep(500);
		Destination_Postalcode.sendKeys("94535");
		api.Destination_Postalcode = "94535";
		
		wait.waitForClickable(Destination_address1);
		wait.clickWithStaleRetry(Destination_address1, this);
		Thread.sleep(500);
		Destination_address1.sendKeys("BLDG 977 CP 707 424 3992 90 RAGSDALE ST");
		api.Destination_Address1 = "BLDG 977 CP 707 424 3992 90 RAGSDALE ST";
		
		ET.log(Status.PASS, "Entered order destination details as expected");
	}
	
	@FindBy(xpath="//button[@name='CreateOrderFromUI_pyDisplayHarness_46']")
	public static WebElement Add_item;
	
	@FindBy(xpath="//a[@name='CreateOrderItems_pyDisplayHarness_31']")
	public static WebElement Popup_additem;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pItemList$l1$pSkuName']")
	public static WebElement Item_name;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pItemList$l1$pItemQuantity']")
	public static WebElement Item_quantity;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pItemList$l1$pTotalWeight']")
	public static WebElement Total_weight;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pItemList$l1$ppyID']")
	public static WebElement Onhandling_unit;
	
	@FindBy(xpath="//button[@id=\"ModalButtonSubmit\"]")
	public static WebElement Popup_Submitbtn;
	
	
	public void Add_items()
	{
		wait.waitForClickable(Add_item);
		Add_item.click();
		
		wait.waitForClickable(Popup_additem);
		Popup_additem.click();
		
		wait.waitForClickable(Item_name);
		Item_name.click();
		Item_name.sendKeys("Test");
	    
		wait.waitForClickable(Item_quantity);
		Item_quantity.click();
		Item_quantity.sendKeys("2");
		
		wait.waitForClickable(Total_weight);
		Total_weight.click();
		Total_weight.sendKeys("20");
		
		wait.waitForClickable(Onhandling_unit);
		Onhandling_unit.click();
		Onhandling_unit.sendKeys("1");
		
		Popup_Submitbtn.click();
		
	}
	

	@FindBy(xpath="//button[@name='CreateOrderFromUI_pyDisplayHarness_47']")
	public static WebElement Add_handlingunits_btn;
	
	@FindBy(xpath="//a[@name='CreateHandlingUnits_pyDisplayHarness_37']")
	public static WebElement Popup_Add_handlingunits_btn;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pHandlingUnit$l1$pHandlingUnitClientID']")
	public static WebElement Client_id;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pHandlingUnit$l1$pHandlingUnitQuantity']")
	public static WebElement HandlingUnit_quantity;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pHandlingUnit$l1$pHandlingUnitType']")
	public static WebElement HandlingUnit_type;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pHandlingUnit$l1$pDIMS$pLength']")
	public static WebElement Length;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pHandlingUnit$l1$pDIMS$pWidth']")
	public static WebElement Width;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pHandlingUnit$l1$pDIMS$pHeight']")
	public static WebElement Height;
	
	@FindBy(xpath="//button[@id='ModalButtonSubmit']")
	public static WebElement submit_btn;
	
	
	public void AddHandlingUnits() throws Exception
	{
		wait.waitForClickable(Add_handlingunits_btn);
		Add_handlingunits_btn.click();
		
		wait.waitForClickable(Popup_Add_handlingunits_btn);
		Popup_Add_handlingunits_btn.click();
		
		//wait.waitForClickable(Client_id);
		wait.clickWithStaleRetry(Client_id, this);
		Thread.sleep(1500);
		Client_id.sendKeys("Test");
		
		wait.waitForClickable(HandlingUnit_quantity);
		wait.clickWithStaleRetry(HandlingUnit_quantity, this);
		HandlingUnit_quantity.sendKeys("2");
		
		wait.waitForClickable(HandlingUnit_type);
		wait.clickWithStaleRetry(HandlingUnit_type, this);
		HandlingUnit_type.sendKeys("test");
		
		wait.waitForClickable(Length);
		wait.clickWithStaleRetry(Length, this);
		Length.sendKeys("10");		
		
		wait.waitForClickable(Width);
		wait.clickWithStaleRetry(Width, this);
		Width.sendKeys("20");
		
		wait.waitForClickable(Height);
		wait.clickWithStaleRetry(Height, this);
		Height.sendKeys("30");
		
		wait.waitForClickable(Popup_Submitbtn);
		wait.clickWithStaleRetry(Popup_Submitbtn, this);
		//Popup_Submitbtn.click();

		 ET.log(Status.PASS, "Handling unit details are entered as expected");
	}
	
	
	@FindBy(xpath="//button[@name='CreateOrderFromUI_pyDisplayHarness_48']")
	public static WebElement Add_Accessorial;
	
	@FindBy(xpath="//a[@name='CreateAccessorial_pyDisplayHarness_28']")
	public static WebElement Popup_add_accessorial;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pAccessorialItemList$l1$pAccessorialCode']")
	public static WebElement Accessorial_code;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pAccessorialItemList$l1$pAccessorialLocation']")
	public static WebElement Accessorial_location;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pOrderPage$pAccessorialItemList$l1$pAccessorialQuantity']")
	public static WebElement Accessorial_Quantity;
	
	@FindBy(xpath="//button[@id='ModalButtonSubmit']")
	public static WebElement Submit_btn;
	
	public void AddAccessorialItems()
	{
		wait.waitForClickable(Add_Accessorial);
		wait.clickWithStaleRetry(Add_Accessorial, this);
		
		wait.waitForClickable(Popup_add_accessorial);
		wait.clickWithStaleRetry(Popup_add_accessorial, this);
		
		wait.waitForClickable(Accessorial_code);
		wait.clickWithStaleRetry(Accessorial_code, this);
		Accessorial_code.sendKeys("C");
		
		wait.waitForClickable(Accessorial_location);
		wait.clickWithStaleRetry(Accessorial_location, this);
		Accessorial_location.sendKeys("Pickup");
		
		wait.waitForClickable(Accessorial_Quantity);
		wait.clickWithStaleRetry(Accessorial_Quantity, this);
		Accessorial_Quantity.sendKeys("1");
		
		wait.waitForClickable(Submit_btn);
		wait.clickWithStaleRetry(Submit_btn, this);
		
		ET.log(Status.PASS, "Added accessorial item to the case as expected");
	}
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pPickupRequestTWStart']")
	public static WebElement PickupRequestTWStart;
	
	@FindBy(xpath="//input[@name='$PpyDisplayHarness$pDeliverByTWStart']")
	public static WebElement DeliverByTWStart;
	
	public void appoinmentDates()
	{
		wait.waitForClickable(PickupRequestTWStart);
		wait.clickWithStaleRetry(PickupRequestTWStart, this);
		PickupRequestTWStart.sendKeys("05/21/2026");
		
		wait.waitForClickable(DeliverByTWStart);
		wait.clickWithStaleRetry(DeliverByTWStart, this);
		DeliverByTWStart.sendKeys("05/22/2026");	
	}
	
	@FindBy(xpath="//button[@name='CreateOrderFromUI_pyDisplayHarness_60']")
	public static WebElement Confirm_order_btn;
	
	@FindBy(xpath="//button[@title='Click to Create Order']")
	public static WebElement Popup_confirm_order;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	public static WebElement Submitbtn;
	
	
	public void Preview_And_ConfirmOrder()
	{
		wait.waitForClickable(Confirm_order_btn);
		wait.clickWithStaleRetry(Confirm_order_btn, this);
	
		wait.waitForClickable(Popup_confirm_order);
		wait.clickWithStaleRetry(Popup_confirm_order, this);
	
		wait.waitForClickable(Submitbtn);
		wait.clickWithStaleRetry(Submitbtn, this);
	}
}
