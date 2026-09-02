package Test_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Base_Class.Base_methods;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Reuse_methods extends Base_methods {

	static WebDriver driver;

	public static String BOL_String;
	public static String Invoicenum;
	public static String prettyString;
	public static String Order1;

	public static WebDriverWait wait;
	

	public Reuse_methods(WebDriver driver) {
		super();
		Reuse_methods.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		PageFactory.initElements(driver, this);// Initialize the static driver
	}

	public String Scanner() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter OTP");
		String OTP = scan.nextLine();
		return OTP;
	}


	public void selectclass(WebElement element, String s) {
		Select sl = new Select(element);
		sl.selectByVisibleText(s);
	}

	public static void switchtopreviouswwindow(int i) {
		Set<String> window = driver.getWindowHandles();

		// converting set to list

		List<String> windowlist = new ArrayList(window);

		driver.switchTo().window(windowlist.get(i));
	}

	public static void switchto_newwindow() {
		Set<String> window = driver.getWindowHandles();

		// converting set to list

		List<String> windowlist = new ArrayList(window);

		driver.switchTo().window(windowlist.get(windowlist.size() - 1));
	}

	public static void switchToCurrentWindow() {

		String handle = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();

		for (String currentwindow : allwindow) {

			if (!currentwindow.equals(handle)) {

				driver.switchTo().window(currentwindow);
			}
		}
	}

	@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
	public static WebElement Frame_PegaGadget0Ifr;

	@FindBy(xpath = "//iframe[@id='PegaGadget1Ifr']")
	public static WebElement Frame_PegaGadget1Ifr;

	@FindBy(xpath = "//iframe[@id='PegaGadget2Ifr']")
	public static WebElement Frame_PegaGadget2Ifr;

	public  void Frame_PegaGadget0Ifr() {
		//switchToFrameWithRetry(Frame_PegaGadget0Ifr,this);
		driver.switchTo().frame(Frame_PegaGadget0Ifr);
	}

	public void Frame_PegaGadget1Ifr() throws Exception {
		//switchToFrameWithRetry(Frame_PegaGadget1Ifr, this);
		driver.switchTo().frame(Frame_PegaGadget1Ifr);
		Thread.sleep(1000);
	}

	public  void Frame_PegaGadget2Ifr() {
		//switchToFrameWithRetry(Frame_PegaGadget2Ifr, this);
	//	WebElement Frame_PegaGadget2Ifr=  driver.findElement(By.xpath("//iframe[@id='PegaGadget2Ifr']"));
		
		driver.switchTo().frame(Frame_PegaGadget2Ifr);
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public static void clickOutsideTheField() {
	Dimension size = driver.manage().window().getSize();
	 
	// Find center coordinates
	int centerX = size.getWidth() / 2;
	int centerY = size.getHeight() / 2;

	// Click at center of screen
	Actions actions = new Actions(driver);
	actions.moveByOffset(centerX, centerY).click().perform();
	
	}
	
	public static void close()
	{
		driver.close();
	}
}