package Test_Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Page_Object.Constructor_Baseclass;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Reuse_methods extends Constructor_Baseclass {

    static WebDriver driver;
    
    public static String BOL_String;
    public static String Invoicenum;
    public static String prettyString;
    public static String Order1 ;

    public Reuse_methods(WebDriver driver)
    {
        super(driver);
        Reuse_methods.driver = driver;   // Initialize the static driver
    }

    public String Scanner() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter OTP");
        String OTP = scan.nextLine();
        return OTP;
    }

    public static void windowhandles() {

        String handle = driver.getWindowHandle();
        Set<String> allwindow = driver.getWindowHandles();

        for (String currentwindow : allwindow) {

            if (!currentwindow.equals(handle)) {

                driver.switchTo().window(currentwindow);
            }
        }
    }

    public static void switchtoframe(String frameName) {

        driver.switchTo().frame(frameName);
    }
    
    public void order_create(String File) throws Exception, IOException
	{
		File file = new File(System.getProperty("user.dir") + File);
		ObjectMapper Om = new ObjectMapper();
		JsonNode JS = Om.readTree(file);
	
		ObjectNode On = (ObjectNode) JS;
		ObjectNode Orderref = (ObjectNode) On.get("OrderRefs") ;
		
		String ATP = JS.path("RequestingTradingPartnerID").asText();
		System.out.println(ATP);
		
		String RTP = JS.path("AssignedTradingPartnerID").asText();
		System.out.println(RTP);
		
		//To pass the value randomly 
		double BOL = Math.ceil(Math.random() * 200000);
		BOL_String = Double.toString(BOL);
		System.out.println(BOL_String);
		Orderref.put("BOL", BOL_String);
		
		double InvoiceNumber = Math.ceil(Math.random() * 200000);
		Invoicenum = Double.toString(InvoiceNumber);
		System.out.println(Invoicenum);
		Orderref.put("InvoiceNumber",Invoicenum );
		prettyString = Om.writerWithDefaultPrettyPrinter().writeValueAsString(On);
		
		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		
		Response rp = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(prettyString).post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		
		String responseBody = rp.getBody().asString();
	
		System.out.println(responseBody);
		
		String[] convert = responseBody.split("Reference is ");
		
		System.out.println(convert[1]);
		
		Order1 =convert[1];		
	}
    

	public void selectclass (WebElement element, String s)
	{
		Select sl=new Select(element);
		sl.selectByVisibleText(s);
	}
	
	
	public static void switchtopreviouswwindow(int i)
	{
		Set<String> window = driver.getWindowHandles();
		
		//converting set to list
		
		List<String> windowlist = new ArrayList(window);
		
		driver.switchTo().window(windowlist.get(i));
	}
	
	
	public static void switchto_newwindow()
	{
		Set<String> window = driver.getWindowHandles();
		
		//converting set to list
		
		List<String> windowlist = new ArrayList(window);
		
		driver.switchTo().window(windowlist.get(windowlist.size()-1));
	}
	
}