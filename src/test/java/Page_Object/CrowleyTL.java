package Page_Object;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Test_Utilities.Reuse_methods;
import Test_Utilities.Wait_Utilities;
import Test_Utilities.api_order_create;

public class CrowleyTL extends Base_methods {

	public static Wait_Utilities wait;

	public CrowleyTL(WebDriver driver) {
		this.driver = driver;
		this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@name=\"CrowleyTLSection_pyDisplayHarness_41\"]")
	public static WebElement Refresh;

	public void refresh() throws Exception {
		wait.waitForClickable(Refresh);
		Refresh.click();
		Thread.sleep(3500);
	}

	@FindBy(xpath = "//button[@name='CrowleyTLSection_pyDisplayHarness_29']")
	public static WebElement AttachPODbtn;

	public void AttachPOD_btn() throws Exception {
		
		Reuse_methods rm = new Reuse_methods(driver);
		//rm.clickOutsideTheField();
		Thread.sleep(5000);
		wait.waitForVisible(AttachPODbtn);
		wait.waitForClickable(AttachPODbtn);
		AttachPODbtn.click();
	}

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pInvoiceNumber\"]")
	public static WebElement EnterIBloadID;

	public void EnterIB_loadID_input() {
		api_order_create api = new api_order_create(driver);
		wait.waitForClickable(EnterIBloadID);
		Reuse_methods rm = new Reuse_methods(driver);
		EnterIBloadID.sendKeys(api.Invoicenum);
	}

	@FindBy(xpath = "//button[@name=\"BulkAttachPODForCrowleyTL_pyDisplayHarness_6\"]")
	public static WebElement Search_Btn;

	public void Search_btn() throws Exception {
		wait.waitForClickable(Search_Btn);
		Search_Btn.click();
		Thread.sleep(1500);
	}

	@FindBy(xpath = "//button[@name=\"ProcessCancellationRequestForCrowleyTL_pyDisplayHarness_45\"]")
	public static WebElement SubmitBtn;

	public void Submit_btn() throws Exception {
		wait.waitForClickable(SubmitBtn);
		SubmitBtn.click();
		Thread.sleep(1500);
	}

	@FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppxAttachName']")
	public static WebElement Selectfile;

	public void selectfile() throws Exception {
		wait.waitForClickable(AttachPODbtn);
		Selectfile.sendKeys("C:\\Users\\rameskr\\Desktop\\EL2_main\\src\\Files\\63169260228.pdf");
	}

	@FindBy(xpath = "//button[@id='Submit']")
	public static WebElement crowleyTL_submitBTN;

	public void crowleyTL_submitbtn() {
		wait.clickWithStaleRetry(crowleyTL_submitBTN, this);
		//crowleyTL_submitBTN.click();
	}

	public void crowleyTL_Attachment() throws Exception {
		Thread.sleep(2000);
		AttachPOD_btn();
		EnterIB_loadID_input();
		Search_btn();
		Submit_btn();
		selectfile();
		crowleyTL_submitbtn();
		ET.log(Status.PASS, "Attachment added to the case through crowleyTL as expected ");
	}

}
