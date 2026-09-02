package Page_Object;

import java.util.List;

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

public class Clipboard extends Base_methods {

	public Wait_Utilities wait;

	public Clipboard(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button/i[@class='pz-pi pi-gear']")
	public static WebElement Case_lvl_settings;

	public void Case_lvl_settings_icon() {
		wait.waitForClickable(Case_lvl_settings);
		Case_lvl_settings.click();
	}

	@FindBy(xpath = "//i[@class='pz-pi pi-clipboard']")
	public static WebElement Clipboard_icon;

	public void Clipboard_icon_clk() {
		wait.waitForClickable(Clipboard_icon);
		Clipboard_icon.click();
	}

	@FindBy(xpath = "(//span[contains(text(), 'pyWorkPage')])[1]/ancestor::li[2]/ul/li/div/div[1]")
	public static WebElement plus_pyworkpage;

	public void plus_pyworkpage() {
		wait.waitForClickable(plus_pyworkpage);
		plus_pyworkpage.click();
	}

	@FindBy(xpath = "//span[@title=\"OrderPage (ESTES-Data-Order)\"]")
	public static WebElement clipboard_order_pg;

	public void clipboard_order_pg_clk() {
		wait.waitForClickable(clipboard_order_pg);
		clipboard_order_pg.click();
	}

	@FindBy(xpath = "(//span[@title=\"OrderPage (ESTES-Data-Order)\"])[1]//ancestor::li[2]/ul/li/div/div/a")
	public static WebElement Plus_orderpage;

	public void Plus_orderpage() {
		wait.waitForClickable(Plus_orderpage);
		Plus_orderpage.click();
	}

	@FindBy(xpath = "//span[@title=\"OrderRefs (ESTES-Data-Order)\"]")
	public static WebElement Order_refs;

	public void Order_ref() throws Exception {
		wait.waitForClickable(Order_refs);
		Order_refs.click();
		Thread.sleep(1500);
	}

	@FindBy(xpath = "//span[@title='OrderOrigin (ESTES-Data-Order)']")
	public static WebElement Order_origin;

	public void Order_origin_clk() throws Exception {
		wait.waitForClickable(Order_origin);
		Order_origin.click();
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//span[@title='OrderDestination (ESTES-Data-Order)']")
	public static WebElement Order_destination;

	public void Order_destination_clk() {
		wait.waitForClickable(Order_destination);
		Order_destination.click();
	}

	// Clipboard order table validations
	// ---------------------------------------------------------------------------------------------------------

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[1]//span/a")
	List<WebElement> clipboardProperty;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[2]/div/span")
	List<WebElement> clipboardValue;

	public void validateClipboardOrderTableValue(String property, String expectedValue) {

		for (int i = 0; i < clipboardProperty.size(); i++) {

			String actualProperty = clipboardProperty.get(i).getText().trim();

			if (actualProperty.equals(property)) {

				String actualValue = clipboardValue.get(i).getText().trim();

				Assert.assertEquals(actualValue, expectedValue, property + " value mismatch");

				return;
			}
		}

		Assert.fail("Property not found in Clipboard: " + property);
	}

	public void clipboardOrderTableValidationForCrowleyOnDock() throws Exception {
		
		Thread.sleep(1500);
		api_order_create api = new api_order_create(driver);
		
		validateClipboardOrderTableValue("AssignedTradingPartnerID", api.AssignedTradingPartnerID);
		ET.log(Status.PASS, "Assigned trading partner values is mapped in clipboard OrderTable as expected");

		validateClipboardOrderTableValue("AssignedTradingPartnerName", api.AssignedTradingPartnerName);
		ET.log(Status.PASS, "AssignedTradingPartnerName values is mapped in clipboard OrderTable as expected");

		validateClipboardOrderTableValue("RequestingTradingPartnerID", api.RequestingTradingPartnerID);
		ET.log(Status.PASS, "Assigned trading partner values is mapped in clipboard OrderTable as expected");
		
		validateClipboardOrderTableValue("RequestingTradingPartnerName", api.RequestingTradingPartnerName);
		ET.log(Status.PASS, "RequestingTradingPartnerName is mapped in clipboard OrderTable as expected");
		
		validateClipboardOrderTableValue("CaseType", api.CaseType);
		ET.log(Status.PASS, "CaseType values is mapped in clipboard OrderTable  as expected");
		
		validateClipboardOrderTableValue("Equipment", api.Equipment);
		ET.log(Status.PASS, "Equipment values is mapped in clipboard OrderTable as expected");
		
		validateClipboardOrderTableValue("Mode", api.Mode);
		ET.log(Status.PASS, "Mode values is mapped in clipboard OrderTable as expected");
		
		validateClipboardOrderTableValue("PaymentTerm", api.PaymentTerm);
		ET.log(Status.PASS, "PaymentTerm values is mapped in clipboard OrderTable  as expected");
		
		validateClipboardOrderTableValue("ServiceLevel", api.ServiceLevel);
		ET.log(Status.PASS, "ServiceLevel values is mapped in clipboard OrderTable as expected");
	}

	// Order ref validation
	// ----------------------------------------------------------------------------------------------------

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[1]/div//tbody//span/a")
	List<WebElement> orderRefProperty;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[2]/div/span")
	List<WebElement> orderRefValue;

	public void validateClipboardOrderRefValue(String property, String expectedValue) {

		for (int i = 0; i < orderRefProperty.size(); i++) {

			String actualProperty = orderRefProperty.get(i).getText().trim();

			if (actualProperty.equals(property)) {

				String actualValue = orderRefValue.get(i).getText().trim();

				Assert.assertEquals(actualValue, expectedValue, property + " value mismatch");

				return;
			}
		}

		Assert.fail("Property not found in Order ref : " + property);
	}

	public void clipboardOrderRefValidationforCrowleyOndock() throws Exception {
		Thread.sleep(1500);
		api_order_create api = new api_order_create(driver);
		
		validateClipboardOrderRefValue("BOL", api.BOL_String);
		ET.log(Status.PASS, "BOL is mapped in clipboard Orderref as expected");
		
		validateClipboardOrderRefValue("DeliveryNumber", api.DeliveryNumber);
		ET.log(Status.PASS, "DeliveryNumber is mapped in clipboard Orderref as expected");
		
		validateClipboardOrderRefValue("InvoiceNumber", api.Invoicenum);
		ET.log(Status.PASS, "InvoiceNumber is mapped in clipboard Orderref as expected");
		
		validateClipboardOrderRefValue("PickupNumber", api.PickupNumber);
		ET.log(Status.PASS, "PickupNumber is mapped in clipboard Orderref as expected");
		
		validateClipboardOrderRefValue("PONumber", api.PONumber);
		ET.log(Status.PASS, "PONumber is mapped in clipboard Orderref as expected");
		
		validateClipboardOrderRefValue("TrackingNumber", api.TrackingNumber);
		ET.log(Status.PASS, "TrackingNumber is mapped in clipboard Orderref as expected");
		
	}

	// Order Origin validation----------------------------------------------------------------------------------------------------

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[1]/div//tbody//span/a")
	List<WebElement> orderOriginProperty;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[2]/div/span")
	List<WebElement> orderOriginValue;

	public void validateClipboardOrderOriginValue(String property, String expectedValue) {

		for (int i = 0; i < orderOriginProperty.size(); i++) {

			String actualProperty = orderOriginProperty.get(i).getText().trim();

			if (actualProperty.equals(property)) {

				String actualValue = orderOriginValue.get(i).getText().trim();

				Assert.assertEquals(actualValue, expectedValue, property + " value mismatch");

				return;
			}
		}

		Assert.fail("Property not found in Order ref : " + property);
	}

	public void clipboardOrderOriginValidationforCrowleyOndock() throws Exception {
		Thread.sleep(1500);
		api_order_create api = new api_order_create(driver);
		
		validateClipboardOrderOriginValue("Address1", api.Origin_Address1);
		ET.log(Status.PASS, "Address1 is mapped in clipboard Orderorigin as expected");

		validateClipboardOrderOriginValue("City", api.Origin_City );
		ET.log(Status.PASS, "City is mapped in clipboard Orderorigin as expected");

		validateClipboardOrderOriginValue("CompanyName", api.Origin_company_Name);
		ET.log(Status.PASS, "CompanyName is mapped in clipboard Orderorigin as expected");

//		validateClipboardOrderOriginValue("ContactName",api.Origin_ContactName);
//		ET.log(Status.PASS, "ContactName is mapped in clipboard Orderorigin as expected");

		validateClipboardOrderOriginValue("Country", api.Origin_Country);
		ET.log(Status.PASS, "Country is mapped in clipboard Orderorigin as expected");

//		validateClipboardOrderOriginValue("Phone", api.Origin_Phone);
//		ET.log(Status.PASS, "Phone is mapped in clipboard Orderorigin as expected");

		validateClipboardOrderOriginValue("PostalCode", api.Origin_PostalCode);
		ET.log(Status.PASS, "PostalCode is mapped in clipboard Orderorigin as expected");

		validateClipboardOrderOriginValue("State", api.Origin_State );
		ET.log(Status.PASS, "State is mapped in clipboard Orderorigin as expected");

	}

	// Order Destination validation
	// ----------------------------------------------------------------------------------------------------

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[1]/div//tbody//span/a")
	List<WebElement> orderDestinationProperty;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody//tr//td[2]/div/span")
	List<WebElement> orderDestinationValue;

	public void validateClipboardOrderDestinationValue(String property, String expectedValue) {

		for (int i = 0; i < orderDestinationProperty.size(); i++) {

			String actualProperty = orderDestinationProperty.get(i).getText().trim();

			if (actualProperty.equals(property)) {

				String actualValue = orderDestinationValue.get(i).getText().trim();

				Assert.assertEquals(actualValue, expectedValue, property + " value mismatch");

				return;
			}
		}

		Assert.fail("Property not found in Order ref : " + property);
	}

	public void clipboardOrderDestinationValidationforCrowleyOndock() throws Exception {
		Thread.sleep(2000);
		
		api_order_create api = new api_order_create(driver);

		validateClipboardOrderDestinationValue("Address1", api.Destination_Address1 );
		ET.log(Status.PASS, "Address1 is mapped in clipboard Orderdestination as expected");
		
		validateClipboardOrderDestinationValue("City", api.Destination_City);
		ET.log(Status.PASS, "City is mapped in clipboard Orderdestination as expected");
		
		validateClipboardOrderDestinationValue("CompanyName",	api.Destination_Company_name);
		ET.log(Status.PASS, "CompanyName is mapped in clipboard Orderdestination as expected");
		
//		validateClipboardOrderDestinationValue("ContactName", "CROWLEY Logistics");
//		ET.log(Status.PASS, "ContactName is mapped in clipboard Orderdestination as expected");
		
		validateClipboardOrderDestinationValue("Country", api.Destination_country);
		ET.log(Status.PASS, "Country is mapped in clipboard Orderdestination as expected");
		
//		validateClipboardOrderDestinationValue("Phone", );
//		ET.log(Status.PASS, "Phone is mapped in clipboard Orderdestination as expected");
		
		validateClipboardOrderDestinationValue("PostalCode", api.Destination_Postalcode);
		ET.log(Status.PASS, "PostalCode is mapped in clipboard Orderdestination as expected");
		
		validateClipboardOrderDestinationValue("State", api.Destination_State);
		ET.log(Status.PASS, "State is mapped in clipboard Orderdestination as expected");
	}

}
