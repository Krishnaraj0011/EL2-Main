package Test_Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Base_Class.Base_methods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class api_order_create extends Base_methods{
	
	private WebDriver driver;

	public api_order_create(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	public static String RequestingTradingPartnerID;
	public static String RequestingTradingPartnerName;
	public static String AssignedTradingPartnerID;
	public static String AssignedTradingPartnerName;
	public static String CaseType;
	public static String ServiceLevel;
	public static String Equipment;
	public static String Mode;
	public static String PaymentTerm;
	public static String TrackingNumber;
	public static String BOL_String;
	public static String Invoicenum;
	public static String PickupNumber;
	public static String DeliveryNumber;
	public static String PONumber;
	public static String Origin_company_Name;
	public static String Origin_Address1;
	public static String Origin_City;
	public static String Origin_State;
	public static String Origin_PostalCode;
	public static String Origin_Country;
	public static String Origin_Phone ;
	public static String Origin_ContactName;
	public static String Destination_Address1;
	public static String Destination_City;
	public static String Destination_Company_name;
	public static String Destination_country;
	public static String Destination_Postalcode;
	public static String Destination_State;
	

	public static String prettyString;
	public static String Order1;

	public static Wait_Utilities wait;
	
	public void order_create() throws Exception, IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\Files\\OrdersPAR");
		ObjectMapper Om = new ObjectMapper();
		JsonNode JS = Om.readTree(file);

		ObjectNode On = (ObjectNode) JS;
		ObjectNode Orderref = (ObjectNode) On.get("OrderRefs");
		ObjectNode Orderorg = (ObjectNode) On.get("OrderOrigin");
		ObjectNode Orderdes = (ObjectNode) On.get("OrderDestination");
		//, On.get("OrderOrigin");

		RequestingTradingPartnerID = JS.path("RequestingTradingPartnerID").asText();
		System.out.println("AssignedTradingPartnerID: " + RequestingTradingPartnerID);
		
		RequestingTradingPartnerName = "Crowley";

		AssignedTradingPartnerID = JS.path("AssignedTradingPartnerID").asText();
		System.out.println("AssignedTradingPartnerID: "  + AssignedTradingPartnerID);
		
		AssignedTradingPartnerName = "EL2-Manteca";
		
		CaseType = JS.path("CaseType").asText();
		System.out.println("CaseType: " + CaseType);
		
		ServiceLevel = JS.path("ServiceLevel").asText();
		System.out.println("ServiceLevel: " + ServiceLevel);
		
		Equipment = JS.path("Equipment").asText();
		System.out.println("Equipment: "+ Equipment);
		
		Mode = JS.path("Mode").asText();
		System.out.println("Mode: " + Mode);
		
		PaymentTerm = JS.path("PaymentTerm").asText();
		System.out.println("PaymentTerm: " + PaymentTerm);
		
		TrackingNumber = Orderref.path("TrackingNumber").asText();
		System.out.println("TrackingNumber: " + TrackingNumber);
		
		PickupNumber = Orderref.path("PickupNumber").asText();
		System.out.println("PickupNumber: " + PickupNumber);
		
		DeliveryNumber = Orderref.path("DeliveryNumber").asText();
		System.out.println("DeliveryNumber: "+ DeliveryNumber);
		
		PONumber = Orderref.path("PONumber").asText();
		System.out.println("PONumber: " + PONumber);
		
		Origin_company_Name = Orderorg.path("CompanyName").asText();
		System.out.println("Origin_company_Name: "+ Origin_company_Name);
		
		Origin_Address1 = Orderorg.path("Address1").asText();
		System.out.println("Origin_Address1: " + Origin_Address1 );
		
		Origin_City = Orderorg.path("City").asText();
		System.out.println("Origin_City: " + Origin_City );
		
		Origin_State = Orderorg.path("State").asText();
		System.out.println("Origin_State: " + Origin_State);
		
		Origin_PostalCode = Orderorg.path("PostalCode").asText();
		System.out.println("Origin_PostalCode: " + Origin_PostalCode);
		
		Origin_Country = Orderorg.path("Country").asText();
		System.out.println("Origin_Country: " + Origin_Country);
		
		Origin_Phone = Orderorg.path("Phone").asText();
		System.out.println("Origin_Phone: " + Origin_Phone);
		
		Origin_ContactName = Orderorg.path("ContactName").asText();
		System.out.println("Origin_ContactName: " + Origin_ContactName);
		
		Destination_Address1 = Orderdes.path("Address1").asText();
		System.out.println("Destination_address: " + Destination_Address1);
		
		Destination_City = Orderdes.path("City").asText();
		System.out.println("Destination_City: " + Destination_City);
		
		Destination_State = Orderdes.path("State").asText();
		System.out.println("Destination_State: " + Destination_State);
		
		Destination_Postalcode = Orderdes.path("PostalCode").asText();
		System.out.println("Destination_PostalCode: " + Destination_Postalcode);
		
		Destination_Postalcode = Orderdes.path("PostalCode").asText();
		System.out.println("Destination_PostalCode: " + Destination_Postalcode);
		
		Destination_Company_name = Orderdes.path("CompanyName").asText();
		System.out.println("Destination_CompanyName: " + Destination_Company_name);
		
		Destination_country = Orderdes.path("Country").asText();
		System.out.println("Destination_country: " + Destination_country);
		
		
		// To pass the value randomly
		double BOL = Math.ceil(Math.random() * 200000);
		BOL_String = Double.toString(BOL);
		System.out.println(BOL_String);
		Orderref.put("BOL", BOL_String);

		double InvoiceNumber = Math.ceil(Math.random() * 200000);
		Invoicenum = Double.toString(InvoiceNumber);
		System.out.println(Invoicenum);
		Orderref.put("InvoiceNumber", Invoicenum);
		prettyString = Om.writerWithDefaultPrettyPrinter().writeValueAsString(On);

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";

		Response rp = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234").contentType("application/json")
				.body(prettyString).post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");

		String responseBody = rp.getBody().asString();

		System.out.println(responseBody);

		String[] convert = responseBody.split("Reference is ");

		System.out.println(convert[1]);

		Order1 = convert[1];

		ET.log(Status.PASS, "Order created successfully");
	}

}
