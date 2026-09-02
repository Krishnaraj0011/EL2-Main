package Page_Object;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Test_Utilities.Reuse_methods;
import Test_Utilities.Wait_Utilities;
import Test_Utilities.api_order_create;

public class Dev_studio extends Base_methods {

	public Wait_Utilities wait;

	public Dev_studio(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Launch portal']")
	public static WebElement Launchportal;

	@FindBy(xpath = "//span[contains(text(),'WareHouse UserPortal')]")
	public static WebElement WareHousePortal;

	public void clickLaunchPortal() {
		wait.waitForVisible(Launchportal);
		wait.waitForClickable(Launchportal);
		Launchportal.click();
		ET.log(Status.PASS, "Dev studio launched successfully");
		
	}

	public void clickWarehousePortal() {
		wait.waitForClickable(WareHousePortal);
		WareHousePortal.click();
		ET.log(Status.PASS, "Warehouse portal launched successfully");
	}

	@FindBy(xpath = "//span[contains(text(),'Admin Portal')]")
	public static WebElement Admin_portal;

	public void Adminportal_clk() throws Exception {
		wait.waitForClickable(Admin_portal);
		Admin_portal.click();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//div[@title='Favorites']/h3/i")
	public static WebElement favorites;

	public void Favorites() {
		wait.waitForVisible(favorites);
		wait.waitForClickable(favorites);
		favorites.click();
	}

	@FindBy(xpath = "//h3[normalize-space()='Data types']")
	public static WebElement datatype;

	public void datatype_clk() {
		wait.waitForClickable(datatype);
		datatype.click();
	}

	// POD confirm number elements
	// ------------------------------------------------------------------------------

	@FindBy(xpath = "(//span[contains(text(),'ConfrimPOD')])[3]")
	public static WebElement ConfirmPOD;

	public void ConfirmPOD() {
		wait.waitForVisible(ConfirmPOD);
		wait.waitForClickable(ConfirmPOD);
		ConfirmPOD.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Actions']")
	public static WebElement Actiondropdown;

	public void Actiondropdown() {
		wait.waitForVisible(Actiondropdown);
		wait.waitForClickable(Actiondropdown);
		Actiondropdown.click();
	}

	@FindBy(xpath = "(//span[contains(text(),'Run')])[2]")
	public static WebElement runindropdown;

	public void runoption() {
		wait.waitForVisible(runindropdown);
		wait.waitForClickable(runindropdown);
		runindropdown.click();
	}

	@FindBy(xpath = "(//span/input[@id='pyValue'])[1]")
	public static WebElement PyIDtextfield;

	public void PyIDtextfield_input() {
		api_order_create api = new api_order_create(driver);
		wait.waitForVisible(PyIDtextfield);
		wait.waitForClickable(PyIDtextfield);
		PyIDtextfield.sendKeys(api.Order1);
	}

	@FindBy(xpath = "(//span/input[@id='pyValue'])[2]")
	public static WebElement PODConfirmNumber;

	public void PODConfirmNumber_input() {
		wait.waitForVisible(PODConfirmNumber);
		wait.waitForClickable(PODConfirmNumber);
		PODConfirmNumber.sendKeys("8667632");
	}

	@FindBy(xpath = "//div[contains(text(),'Run')]")
	public static WebElement runbutton;

	public void runbtn() {
		wait.waitForClickable(runbutton);
		runbutton.click();
	}

	public void POD_Confirm_Number() throws Exception {
		Actiondropdown();
		runoption();
		Reuse_methods rm = new Reuse_methods(driver);
		rm.switchto_newwindow();
		Thread.sleep(1000);
		PyIDtextfield_input();
		PODConfirmNumber_input();
		runbtn();
		Thread.sleep(4000);
		ET.log(Status.PASS, "Added POD confirm number to case as expected");
	}

	// order table elements

	@FindBy(xpath = "//div[@id='gridBody_left']/ul/li[24]/ul/li[2]//div[@string_type='field'][2]/span/i")
	public static WebElement ordertable_record;

	public void Ordertable_record_clk() throws Exception {
		wait.waitForClickable(ordertable_record);
		ordertable_record.click();
		Thread.sleep(3500);
	}

	@FindBy(xpath = "(//input[@placeholder='Search...'])[2]")
	public static WebElement Ordertable_searchfield;

	public void Ordertable_searchfield_clk() throws Exception {
		api_order_create api = new api_order_create(driver);
		Ordertable_searchfield.sendKeys(api.Order1);
		Thread.sleep(1500);
	}

	@FindBy(xpath = "//i[@class='pi pi-search']")
	public static WebElement Ordertable_searchicon;

	public void Ordertable_searchicon_clk() throws Exception {
		wait.waitForClickable(Ordertable_searchicon);
		Ordertable_searchicon.click();
		Thread.sleep(3000);
	}

	public void clickOnLaunchPortal() {
		Dev_studio ds = new Dev_studio(driver);
		Wait_Utilities wait = new Wait_Utilities(driver);
		wait.waitForVisible(Launchportal);
		ds.clickLaunchPortal();
		
	}
	
	public void clickonWarehousePortal() {
		wait.waitForVisible(WareHousePortal);
		clickWarehousePortal();
		ET.log(Status.PASS, "Warehouse portal launched successfully");
	}

	// Order table validation
	// ------------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr[1]/th")
	List<WebElement> orderTableProperty;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr[2]/td")
	List<WebElement> orderTableValue;

	public void validateOrderTableValue(String property, String expectedValue) {

		for (int i = 0; i < orderTableProperty.size(); i++) {

			String actualProperty = orderTableProperty.get(i).getText().trim();

			if (actualProperty.equals(property)) {

				String actualValue = orderTableValue.get(i).getText().trim();

				Assert.assertEquals(actualValue, expectedValue, property + " value mismatch");

				return;
			}
		}

		Assert.fail("Property not found in Order ref : " + property);
	}

	public void orderTableValidationforCrowleyOndock() {
		
		api_order_create api = new api_order_create(driver);

		validateOrderTableValue("BOL", api.BOL_String);
		ET.log(Status.PASS, "BOL is mapped in Ordertable as expected");
		
		validateOrderTableValue("InvoiceNumber", api.Invoicenum);
		ET.log(Status.PASS, "InvoiceNumber is mapped in Ordertable as expected");
		
		validateOrderTableValue("PickupNumber", api.PickupNumber);
		ET.log(Status.PASS, "PickupNumber is mapped in Ordertable as expected");
		
		validateOrderTableValue("PONumber", api.PONumber );
		ET.log(Status.PASS, "PONumber is mapped in Ordertable as expected");
		
		validateOrderTableValue("TrackingNumber", api.TrackingNumber);
		ET.log(Status.PASS, "TrackingNumber is mapped in Ordertable as expected");
		
		//order details 
		
		validateOrderTableValue("AssignedTradingPartnerID", api.AssignedTradingPartnerID);
		ET.log(Status.PASS, "AssignedTradingPartnerID is mapped in Ordertable as expected");
		
		validateOrderTableValue("ServiceLevel", api.ServiceLevel);
		ET.log(Status.PASS, "ServiceLevel is mapped in Ordertable as expected");
		
		validateOrderTableValue("Equipment", api.Equipment);
		ET.log(Status.PASS, "Equipment is mapped in Ordertable as expected");
		
		validateOrderTableValue("Mode", api.Mode);
		ET.log(Status.PASS, "Mode is mapped in Ordertable as expected");
		
		// order origin details-------------------------------------------------------------------------------------
		validateOrderTableValue("Origin Address 1", api.Origin_Address1);
		ET.log(Status.PASS, "Origin Address 1 is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Origin City", api.Origin_City);
		ET.log(Status.PASS, "Origin City is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Origin Company", api.Origin_company_Name);
		ET.log(Status.PASS, "Origin City is mapped in Ordertable as expected");
		 
//		validateOrderTableValue("Origin Contact Name", api.Origin_ContactName);
//		ET.log(Status.PASS, "Origin Contact Name is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Origin Country", api.Origin_Country);
		ET.log(Status.PASS, "Origin Country is mapped in Ordertable as expected");
		 
//		validateOrderTableValue("OriginPhoneNumber", api.Origin_Phone);
//		ET.log(Status.PASS, "OriginPhoneNumber is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Origin Postal Code", api.Origin_PostalCode);
		ET.log(Status.PASS, "Origin Postal Code is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Origin State", api.Origin_State);
		ET.log(Status.PASS, "Origin State is mapped in Ordertable as expected");
		 
		//order destination details ---------------------------------------------------------------------------------
		
		validateOrderTableValue("Destination Address 1", api.Destination_Address1);
		ET.log(Status.PASS, "Destination Address 1 is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Destination City", api.Destination_City);
		ET.log(Status.PASS, "Destination City is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Destination Company", api.Destination_Company_name);
		ET.log(Status.PASS, "Destination Company is mapped in Ordertable as expected");
		 
//		validateOrderTableValue("Destination Contact Name", "CROWLEY Logistics");
//		ET.log(Status.PASS, "Destination Contact Name is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Destination Country", api.Destination_country);
		ET.log(Status.PASS, "Destination Country is mapped in Ordertable as expected");
		 
//		validateOrderTableValue("DestinationPhoneNumber", "qwer");
//		ET.log(Status.PASS, "DestinationPhoneNumberis mapped in Ordertable as expected");
		 
		validateOrderTableValue("Destination Postal Code", api.Destination_Postalcode);
		ET.log(Status.PASS, "Destination Postal Code is mapped in Ordertable as expected");
		 
		validateOrderTableValue("Destination State", api.Destination_State);
		ET.log(Status.PASS, "Destination State is mapped in Ordertable as expected");
		 
	}

}