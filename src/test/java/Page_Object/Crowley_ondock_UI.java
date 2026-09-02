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

public class Crowley_ondock_UI extends Base_methods {
	Wait_Utilities wait;

	public Crowley_ondock_UI(WebDriver driver) {
		this.driver = driver;
		 this.wait = new Wait_Utilities(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@data-target='$PpyDisplayHarness$pBOLNumberList']")
	public static WebElement Bolsearch;

	public void enterBolInput() throws Exception {
		//Reuse_methods rm = new Reuse_methods(driver);
		api_order_create api = new api_order_create(driver);
		wait.waitForClickable(Bolsearch);
		Bolsearch.click();
		Bolsearch.sendKeys(api.BOL_String);
		Thread.sleep(1000);
	}

	@FindBy(xpath = "//span[@class='ms-primary-option']")
	public static WebElement Bolsearchdropdown;

	public void clickValueFromBolDropdown() throws Exception {
		//Bolsearchdropdown.click();
		wait.clickWithStaleRetry(Bolsearchdropdown, this);
		
	}
	// Bolsearchdropdown.click();}

	@FindBy(xpath = "(//input[@id='d4227aca'])[1]")
	public static WebElement OverallCheckbox;

	public void clickOnOverallCheckbox() throws Exception {
		// Wait_Utilities WT = new Wait_Utilities(driver);
		Thread.sleep(1000);
		wait.clickWithStaleRetry(OverallCheckbox, this);
	}

	@FindBy(xpath = "//div[@id='PEGA_GRID_SKIN']//span/button")
	public static WebElement Receiveorder;

	public void clickOnRecieveOrderButton() throws Exception {
		Thread.sleep(1000);
		// Wait_Utilities WT = new Wait_Utilities(driver);
		wait.clickWithStaleRetry(Receiveorder, this);
		//Thread.sleep(2000);
	}

	@FindBy(xpath = "//input[@aria-describedby=\"$PpyDisplayHarness$pReceivedDateError \"]")
	public static WebElement Receivedate;

	public void enterReceiveDate() throws Exception {
		wait.waitForVisible(Receivedate);
		Receivedate.click();
		Thread.sleep(1000);
		Receivedate.sendKeys("6/18/2026 9:25 AM");
	}
	
	@FindBy(xpath = "(//input[@name=\"$PpyDisplayHarness$pSelectedCrowleyOnDocOrderList$l1$pTerminalNotes\"])[1]")
	public static WebElement Terminal_notes;
	
	public void enterTerminal_notes () throws Exception {
		//wait.waitForVisible(Terminal_notes);
		wait.clickWithStaleRetry(Terminal_notes, this);
		Thread.sleep(1000);
		//Terminal_notes.sendKeys("Terminal notes ");
	}

	@FindBy(xpath = "//button[@name='CrowleyOnDocOrderButtons_pyDisplayHarness_272']")
	public static WebElement Submitbutton;

	public void clickOnSubmitButton() {
		wait.waitForClickable(Submitbutton);
		wait.clickWithStaleRetry(Submitbutton, this);
	}

	public static void codReceiveOrderBulkAction() throws Exception {
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		co.enterBolInput();
		co.clickValueFromBolDropdown();
		Thread.sleep(1000);
		co.clickOnOverallCheckbox();
		co.clickOnRecieveOrderButton();
		co.enterReceiveDate();
		co. enterTerminal_notes();
		co.clickOnSubmitButton();
		Thread.sleep(3000);
		ET.log(Status.PASS, "Received order successfully");
	}

	// Assign carrier
	// ------------------------------------------------------------------------------------

	@FindBy(xpath = "//button[normalize-space()='Assign Carrier']")
	public static WebElement Assigncarrier;

	public void Assign_carrier_btn() {
		wait.clickWithStaleRetry(Assigncarrier, this);
	}

	@FindBy(xpath = "//select[@name=\"$PpyDisplayHarness$pAssignedTradingPartnerID\"]")
	public static WebElement Assigncarrierpopupdropdown;

	public void Assign_carrier_drp_popup() {
		wait.waitForClickable(Assigncarrierpopupdropdown);
		Assigncarrierpopupdropdown.click();
	}

	@FindBy(xpath = "//button[@name='CrowleyOnDocOrderButtons_pyDisplayHarness_272']")
	public static WebElement Assigncarrierpopupsubmit;

	public void Assigncarrier_submit() {
		wait.waitForClickable(Assigncarrierpopupsubmit);
		Assigncarrierpopupsubmit.click();
	}

	public void codAssignCarrier_BulkAction() throws Exception {
		clickOnOverallCheckbox();
		Assign_carrier_btn();
		Assign_carrier_drp_popup();
		Reuse_methods rm = new Reuse_methods(driver);
		rm.selectclass(Assigncarrierpopupdropdown, "Estes Express Lines");
		Assigncarrier_submit();
		Thread.sleep(2000);
		ET.log(Status.PASS, "Carrier has been assign for the case successfully");
	}

	// Assign load ID
	// -----------------------------------------------------------------------------------

	@FindBy(xpath = "//button[@name=\"CrowleyOnDock_pyDisplayHarness_46\"]")
	public static WebElement AssignLoadID;

	public void Assign_loadID_btn() {

		wait.waitForClickable(AssignLoadID);
		AssignLoadID.click();
	}

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pDescription\"]")
	public static WebElement OutboundLoadtextbox;

	public void Assign_loadID_textbox() {
		// Wait_Utilities WT = new Wait_Utilities(driver);
		wait.waitForClickable(OutboundLoadtextbox);
		OutboundLoadtextbox.click();
		OutboundLoadtextbox.sendKeys("543452");
	}

	@FindBy(xpath = "//button[@name='CrowleyOnDocOrderButtons_pyDisplayHarness_272']")
	public static WebElement Outboundloadpopupsubmit;

	public void Outboundload_popup_sbt() {
		wait.waitForClickable(Outboundloadpopupsubmit);
		Outboundloadpopupsubmit.click();
	}

	public void codAssignLoadID() throws Exception {
		clickOnOverallCheckbox();
		Assign_loadID_btn();
		Assign_loadID_textbox();
		Outboundload_popup_sbt();
		Thread.sleep(2000);
		ET.log(Status.PASS, "Load ID has been assigned for the case as expected");
	}

	// Assign OB trailer
	// ----------------------------------------------------------------------------------------

	@FindBy(xpath = "//button[@name=\"CrowleyOnDock_pyDisplayHarness_47\"]")
	public static WebElement AssignOBtrailer_button;

	public void AssignOBtrailer_button() {
		wait.waitForClickable(AssignOBtrailer_button);
		AssignOBtrailer_button.click();
	}

	@FindBy(xpath = "//input[@name=\"$PpyDisplayHarness$pEventDate\"]")
	public static WebElement Loadeddatepopup;

	public void Loaded_date_input() {
		wait.waitForClickable(Loadeddatepopup);
		Loadeddatepopup.click();
		Loadeddatepopup.sendKeys("3/18/2026 4:00 AM");
	}

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pName']")
	public static WebElement Trailernumberpopup;

	public void Trailernumber_input() throws Exception {
		wait.waitForClickable(Trailernumberpopup);
		Trailernumberpopup.click();
		Thread.sleep(1000);
	    Trailernumberpopup.sendKeys("567890");
	}

	@FindBy(xpath = "//button[@name='CrowleyOnDocOrderButtons_pyDisplayHarness_272']")
	public static WebElement Assignobtrailer_submit;

	public void Assignobtrailer_submit() {
		Assignobtrailer_submit.click();
	}

	public void codAssignOBTrailer_BulkAction() throws Exception {
		clickOnOverallCheckbox();
		AssignOBtrailer_button();
		Loaded_date_input();
		Trailernumber_input();
		Assignobtrailer_submit();
		Thread.sleep(2000);
		ET.log(Status.PASS, "OB trailer has been assigned for the case as expected");
	}

	// released bulk action
	// ----------------------------------------------------------------------------------------------------

	@FindBy(xpath = "//button[normalize-space()='Released']")
	public static WebElement Releasebutton;

	public void Releasebutton() {
		wait.waitForClickable(Releasebutton);
		Releasebutton.click();
	}

	@FindBy(xpath = "//div[@id='modaldialog_con']//span/input[@id='345ed271']")
	public static WebElement Releasedate;

	public void Releasedate_input() {
		wait.waitForClickable(Releasedate);
		Releasedate.click();
		Releasedate.sendKeys("6/19/26 6:14 AM");
	}

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	public static WebElement Releasedatepopup_submit;

	public void Releasedatepopup_submit() {
		wait.waitForClickable(Releasedatepopup_submit);
		Releasedatepopup_submit.click();
	}

	public void codReleased_BulkAction() throws Exception {
		clickOnOverallCheckbox();
		Releasebutton();
		Releasedate_input();
		Reuse_methods rm = new Reuse_methods(driver);
		rm.clickOutsideTheField();
		//enterTerminal_notes();
		Releasedatepopup_submit();
		Thread.sleep(1500);
		ET.log(Status.PASS, "Case has been moved to released as expected");
	}

	// POD review
	// ---------------------------------------------------------------------------------------------

	@FindBy(xpath = "//h3[normalize-space()='POD Review']")
	public static WebElement PODReviewHeader;

	public void clickOnPodReviewHeader() throws Exception {
		wait.waitForClickable(PODReviewHeader);
		PODReviewHeader.click();
		Thread.sleep(1000);
	}

	@FindBy(xpath = "//div[@id='gridBody_right']//td[2]//span/a")
	public static WebElement FirstcaseID;

	public void clickOnFirstCaseID() {
		wait.waitForClickable(FirstcaseID);
		FirstcaseID.click();
	}

	@FindBy(xpath = "//a[@name=\"PODRequiredPARGrid_pyDisplayHarness_26\"]")
	public static WebElement refresh;

	public void pod_review_refresh() {
		refresh.click();
	}

	@FindBy(xpath = "//div[@id='gridBody_right']//td[3]//span/a")
	public static WebElement FirstcaseID_cod;

	public void FirstcaseID_cod() throws Exception {
		
		Thread.sleep(2000);
		wait.clickWithStaleRetry(FirstcaseID_cod, this);
		//FirstcaseID_cod.click();
	}

	@FindBy(xpath = "//span[@id='$PpyWorkPage$pOrderPage$pArrivedAtPickupSpan']/input")
	public static WebElement ArrivedatPickupDate;

	public void ArrivedatPickupDate() throws Exception {
		wait.waitForVisible(ArrivedatPickupDate);
		wait.waitForClickable(ArrivedatPickupDate);
		ArrivedatPickupDate.click();
		Thread.sleep(1000);
		ArrivedatPickupDate.sendKeys("6/14/2026 9:25 AM");
	}

	@FindBy(xpath = "//span[@id='$PpyWorkPage$pOrderPage$pOutForDeliverySpan']/input")
	public static WebElement DepartAtPickup;

	public void DepartAtPickup() throws Exception {
		wait.waitForVisible(DepartAtPickup);
		wait.waitForClickable(DepartAtPickup);
		DepartAtPickup.click();
		Thread.sleep(1000);
		DepartAtPickup.sendKeys("6/15/2026 9:25 AM");
	}

	@FindBy(xpath = "//span[@id='$PpyWorkPage$pOrderPage$pArrivedAtConsigneeSpan']/input")
	public static WebElement LineHaulArriveatTerminal;

	public void LineHaulArriveatTerminal() throws Exception {
		wait.waitForVisible(LineHaulArriveatTerminal);
		wait.clickWithStaleRetry(LineHaulArriveatTerminal, this);
		Thread.sleep(1000);
		// LineHaulArriveatTerminal.click();
		LineHaulArriveatTerminal.sendKeys("6/16/26 6:14 AM");
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//span[@id='$PpyWorkPage$pOrderPage$pLineHaulCompleteSpan']/input")
	public static WebElement LinehaulComplete;

	public void LinehaulComplete() throws Exception {
//		wait.waitForClickable(LinehaulComplete);
//		wait.clickWithStaleRetry(LinehaulComplete, this);
		//Thread.sleep(1000);
		// LinehaulComplete.click();
		LinehaulComplete.sendKeys("6/17/26 6:14 AM");
	}

	@FindBy(xpath = "//button[@name=\"PODException_pyWorkPage_63\"]")
	public static WebElement Submitbtn;

	public void Submitbtn() {
		wait.clickWithStaleRetry(Submitbtn, this);
		// Submitbtn.click();
	}
	

	@FindBy(xpath = "//span[@class='case_title']")
	public static WebElement CaseID;
	
	

	public void codSingleCaseFlow_PodReview_action() throws Exception {
		Reuse_methods rm = new Reuse_methods(driver);
		api_order_create api = new api_order_create(driver); 
		api.Order1 = CaseID.getText();
		ArrivedatPickupDate();
		DepartAtPickup();
		LineHaulArriveatTerminal();
		LinehaulComplete();
		//rm.clickOutsideTheField();
		Submitbtn();
		Thread.sleep(2000);
		ET.log(Status.PASS, "All required dates are updated");
	}

	@FindBy(xpath = "//a[normalize-space()='Refresh']")
	public static WebElement Refresh;

	public void Refresh() {
		Refresh.click();
	}

	@FindBy(xpath = "//tbody//tr//td//span[contains(text(),'Crowley On Dock')]")
	public static WebElement Crowleyondock_UI_header;

	public void Crowleyondock_UI_header() {
		wait.waitForVisible(Crowleyondock_UI_header);
		wait.waitForClickable(Crowleyondock_UI_header);
		Crowleyondock_UI_header.click();
	}

	@FindBy(xpath = "(//a[@name='PODRequiredPARGrid_pyDisplayHarness_26'])[1]")
	public static WebElement COD_UI_refresh;

	public void COD_UI_refresh() throws Exception {
		wait.waitForVisible(COD_UI_refresh);
		wait.waitForClickable(COD_UI_refresh);
		COD_UI_refresh.click();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//button[normalize-space()='Approve POD']")
	public static WebElement ApprovePODbutton;

	public void ApprovePODbutton() {
		wait.waitForClickable(ApprovePODbutton);
		wait.clickWithStaleRetry(ApprovePODbutton, this);	
	}

	@FindBy(xpath = "//button[@id='ModalButtonSubmit']")
	public static WebElement SubmitBTN_aprovePOD;

	public void AprovePOD_sbt_btn() {
		SubmitBTN_aprovePOD.click();
	}

	@FindBy(xpath = "//input[@id='ms2b6b4235']")
	public static WebElement PODReview_Bolsearch;

	public void PODReview_Bolsearch_txt() throws Exception {
		api_order_create api = new api_order_create(driver);
		//wait.waitForClickable(PODReview_Bolsearch);
		wait.clickWithStaleRetry(PODReview_Bolsearch, this);
		Thread.sleep(500);
		PODReview_Bolsearch.sendKeys(api.BOL_String);
	}

	@FindBy(xpath = "//div[@class='divCont ']//input[@id='d4227aca']")
	public static WebElement POD_review_overallcheckbox;

	public void POD_review_overallcheckbox() {
		wait.waitForVisible(POD_review_overallcheckbox);
		wait.clickWithStaleRetry(POD_review_overallcheckbox, this);
		//POD_review_overallcheckbox.click();
	}

	@FindBy(xpath = "(//input[@id='d4227aca'])[2]")
	public static WebElement OverallCheckbox_Podreview;

	public void OverallCheckbox_Podreview() {
		OverallCheckbox.click();
	}

	@FindBy(xpath = "//a[@name='PODRequiredPARGrid_pyDisplayHarness_26']")
	public static WebElement POD_review_refresh;

	public void POD_review_refresh() {
		POD_review_refresh.click();
	}

	@FindBy(xpath = "//div[@id=\"workarea\"]//div[@class=\"tStrCntr\"]//li[3]//tbody//td[2]/span")
	public static WebElement Case_id_header_clk;

	public void approve_pod() throws Exception {
		PODReview_Bolsearch_txt();
		clickValueFromBolDropdown();
		POD_review_overallcheckbox();
		ApprovePODbutton();
		AprovePOD_sbt_btn();
		ET.log(Status.PASS, "Case as been approved and moved to resolved completed as expected ");
	}

	public void Case_id_header_clk() {
		wait.waitForClickable(Case_id_header_clk);
		Case_id_header_clk.click();
	}

	@FindBy(xpath = "(//button[@title=\"Actions\"])[2]")
	public static WebElement CaseID_action_drdn;

	public void CaseID_action_drdn_clk() {
		wait.waitForClickable(CaseID_action_drdn);
		CaseID_action_drdn.click();
	}

	@FindBy(xpath = "//span[contains(text(), 'Refresh')]")
	public static WebElement Caselvl_refresh;

	public void Caselvl_refresh() {
		wait.waitForVisible(Caselvl_refresh);
		wait.waitForClickable(Caselvl_refresh);
		Caselvl_refresh.click();
	}

	@FindBy(xpath = "//div[@class='content-item content-layout item-3 remove-bottom-spacing remove-right-spacing flex flex-row']//span[@class='badge_text']")
	public static WebElement Casestatus;

	public void Case_status_text() {
		String casestatus = Casestatus.getText();
		System.out.println(casestatus);
	}


	@FindBy(xpath = "(//table[@id='RULE_KEY'])[3]/tbody/tr/td[3]/span[@id='close']")
	public static WebElement Crowley_TL_close;

	public void Crowley_TLclose() {
		Crowley_TL_close.click();
	}

	@FindBy(xpath = "(//table[@id='RULE_KEY'])[2]/tbody/tr/td[3]/span[@id='close']")
	public static WebElement Case_id_close;

	public void Case_idclose() {
		Case_id_close.click();
	}
	
	
}
