package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Test_Utilities.Reuse_methods;

public class Crowley_ondock_UI extends Constructor_Baseclass
{

	public Crowley_ondock_UI(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='ms78e76717']")
	public static WebElement Bolsearch;

	public void Bolsearch_txt(String s) {
		Reuse_methods rm = new Reuse_methods(driver);
		Bolsearch.sendKeys(s);
		}
	
	@FindBy(xpath = "//span[@class='ms-primary-option']")
	public static WebElement Bolsearchdropdown;
	
	public void clk_Boldropdown() {Bolsearchdropdown.click();}
	
	@FindBy(xpath = "(//input[@id='d4227aca'])[1]")
	public static WebElement OverallCheckbox;
	
	public void clk_overallckeckbox(){OverallCheckbox.click();}
	
	@FindBy(xpath = "//div[@id='PEGA_GRID_SKIN']//span/button")
	public static WebElement Receiveorder;
	
	public void Clk_receiveorder_btn(){Receiveorder.click();}
	
	@FindBy(xpath = "//div[@id='modaldialog_con']//span/input")
	public static WebElement Receivedate;
	
	public void txt_receiveddate(String s){Receivedate.sendKeys(s);}
	
	@FindBy(xpath = "//button[@data-test-id=\"202412230624430766342\"]")
	public static WebElement Submitbutton;
	
	public void Clk_submit_btn(){Submitbutton.click();}
	
	@FindBy(xpath = "//button[normalize-space()='Assign Carrier']")
	public static WebElement Assigncarrier;
	
	public void Assign_carrier_btn() {Assigncarrier.click();}
	
	
	@FindBy(xpath= "//select[@id=\"dd5f164a\"]")
	public static WebElement Assigncarrierpopupdropdown;
	
	public void Assign_carrier_drp_popup() {
		Assigncarrierpopupdropdown.click();
	}
	
	@FindBy(xpath= "//span[normalize-space()='Submit']")
	public static WebElement Assigncarrierpopupsubmit;
	
	public void Assigncarrier_submit(){
		Assigncarrierpopupsubmit.click();
	}
	
	@FindBy(xpath= "//button[normalize-space()='Assign Load ID']")
	public static WebElement AssignLoadID;
	
	public void Assign_loadID_btn(){
		AssignLoadID.click();
	}
	
	@FindBy(xpath= "(//input[@id='a183471b'])[1]")
	public static WebElement OutboundLoadtextbox;
	
	public void Assign_loadID_textbox(){
		OutboundLoadtextbox.sendKeys("543452");	
	}
	
	@FindBy(xpath= "//button[normalize-space()='Submit']")
	public static WebElement Outboundloadpopupsubmit;
	
	public void Outboundload_popup_sbt(){
		Outboundloadpopupsubmit.click();	
	}
	
	@FindBy(xpath= "//button[normalize-space()='Assign OB Trailer']")
	public static WebElement AssignOBtrailer_button;
	
	public void AssignOBtrailer_button(){
		AssignOBtrailer_button.click();
	}
	
	@FindBy(xpath= "(//input[@id='4df1043d'])[1]")
	public static WebElement Loadeddatepopup;
	
	public void Loaded_date_input(){
		Loadeddatepopup.sendKeys("3/18/2026 4:00 AM");
	}
	
	@FindBy(xpath= "//input[@name=\"$PpyDisplayHarness$pName\"]")
	public static WebElement Trailernumberpopup;
	
	public void Trailernumber_input(){
		Trailernumberpopup.sendKeys("567890");
	}
	
	@FindBy(xpath= "//button[normalize-space()='Submit']")
	public static WebElement Assignobtrailer_submit;
	
	public void Assignobtrailer_submit(){
		Assignobtrailer_submit.click();
	}
	
	@FindBy(xpath= "//button[normalize-space()='Released']")
	public static WebElement Releasebutton;
	
	public void Releasebutton() {
		Releasebutton.click();
	}
	
	@FindBy(xpath= "//div[@id='modaldialog_con']//span/input[@id='345ed271']")
	public static WebElement Releasedate;
	
	public void Releasedate_input(String s){
		Releasedate.sendKeys(s);
	}
	
	@FindBy(xpath= "//button[normalize-space()='Submit']")
	public static WebElement Releasedatepopup_submit;
	
	public void Releasedatepopup_submit() {
		Releasedatepopup_submit.click();
	}
	
	
	//POD review ---------------------------------------------------------------------------------------------
	
	@FindBy(xpath= "//h3[normalize-space()='POD Review']")
	public static WebElement PODReviewHeader;
	
	public void POD_review_Header ()
	{
		PODReviewHeader.click();
	}
	
	@FindBy(xpath= "//div[@id='gridBody_right']//td[2]//span/a")
	public static WebElement FirstcaseID;
	
	public void FirstcaseID(){
		FirstcaseID.click();
	}
	
	@FindBy(xpath= "//div[@id='gridBody_right']//td[3]//span/a")
	public static WebElement FirstcaseID_cod;
	
	public void FirstcaseID_cod(){
		FirstcaseID_cod.click();
	}
	
	@FindBy(xpath= "//span[@id='$PpyWorkPage$pOrderPage$pArrivedAtPickupSpan']/input")
	public static WebElement ArrivedatPickupDate;
	
	public void ArrivedatPickupDate(String s) {
		ArrivedatPickupDate.sendKeys(s);
	}
	
	@FindBy(xpath= "//span[@id='$PpyWorkPage$pOrderPage$pOutForDeliverySpan']/input")
	public static WebElement DepartAtPickup;
	
	public void DepartAtPickup(String s) {
		DepartAtPickup.sendKeys(s);
	}
	
	@FindBy(xpath= "//span[@id='$PpyWorkPage$pOrderPage$pArrivedAtConsigneeSpan']/input")
	public static WebElement LineHaulArriveatTerminal;
	
	public void LineHaulArriveatTerminal(String s) {
		LineHaulArriveatTerminal.sendKeys(s);
	}
	
	@FindBy(xpath= "//span[@id='$PpyWorkPage$pOrderPage$pLineHaulCompleteSpan']/input")
	public static WebElement LinehaulComplete;
	
	public void LinehaulComplete(String s) {
		LinehaulComplete.sendKeys(s);
	}
	
	@FindBy(xpath= "//button[normalize-space()='Submit']")
	public static WebElement Submitbtn ;
	
	public void Submitbtn(){
		Submitbtn.click();
	}
	
	@FindBy(xpath= "//a[normalize-space()='Refresh']")
	public static WebElement  Refresh;
	
	public void Refresh(){
		Refresh.click();
	}
	
	@FindBy(xpath= "//tbody//tr//td//span[contains(text(),'Crowley On Dock')]")
	public static WebElement  Crowleyondock_UI_header;
	
	public void Crowleyondock_UI_header(){
		Crowleyondock_UI_header.click();
	}
	
	@FindBy(xpath= "(//a[@name='PODRequiredPARGrid_pyDisplayHarness_26'])[1]")
	public static WebElement  COD_UI_refresh;
	
	public void COD_UI_refresh(){
		COD_UI_refresh.click();
	}	
	
	@FindBy(xpath= "//button[normalize-space()='Approve POD']")
	public static WebElement ApprovePODbutton;
	
	public void ApprovePODbutton(){
		ApprovePODbutton.click();
	}
	
	@FindBy(xpath= "//button[@id='ModalButtonSubmit']")
	public static WebElement SubmitBTN_aprovePOD;
	
	public void AprovePOD_sbt_btn()
	{
		SubmitBTN_aprovePOD.click();
	}
	
	@FindBy(xpath = "//input[@id='ms2b6b4235']")
	public static WebElement PODReview_Bolsearch;
	
	public void PODReview_Bolsearch_txt(String s) {
		Reuse_methods rm = new Reuse_methods(driver);
		PODReview_Bolsearch.sendKeys(s);}
	
	@FindBy(xpath = "//div[@class='divCont ']//input[@id='d4227aca']")
	public static WebElement POD_review_overallcheckbox;
	
	public void POD_review_overallcheckbox() {
		POD_review_overallcheckbox.click();
	}
	
	@FindBy(xpath = "(//input[@id='d4227aca'])[2]")
	public static WebElement OverallCheckbox_Podreview;
	
	public void OverallCheckbox_Podreview(){OverallCheckbox.click();}
	
	@FindBy(xpath = "//a[@name='PODRequiredPARGrid_pyDisplayHarness_26']")
	public static WebElement POD_review_refresh;
	
	public void POD_review_refresh(){OverallCheckbox.click();}
	
	@FindBy(xpath = "//div[@id=\"workarea\"]//div[@class=\"tStrCntr\"]//li[3]//tbody//td[2]/span")
	public static WebElement Case_id_header_clk;
	
	public void Case_id_header_clk ()
	{
		Case_id_header_clk.click();
	}
	
	@FindBy(xpath = "(//button[@title=\"Actions\"])[2]")
	public static WebElement CaseID_action_drdn;
	
	public void CaseID_action_drdn_clk ()
	{
		CaseID_action_drdn.click();
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Refresh')]")
	public static WebElement Caselvl_refresh;
	
	public void Caselvl_refresh ()
	{
		Caselvl_refresh.click();
	}
	
	@FindBy(xpath = "//div[@class='content-item content-layout item-3 remove-bottom-spacing remove-right-spacing flex flex-row']//span[@class=\"badge_text\"]")
	public static WebElement Casestatus;
	
	public void Case_status_text (){
		String casestatus = Casestatus.getText();
		System.out.println(casestatus);
	}
	
	//CLipboard_validation xpath-----------------------------------------------------------------------------------------------
	
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[8]//td[2]/div/span")
	public static WebElement Assign_trading_partner;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[37]//td[2]/div/span")
	public static WebElement Requesting_trading_partner;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[9]//td[2]/div/span")
	public static WebElement Assign_trading_partner_name;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[10]//td[2]/div/span")
	public static WebElement Casetype;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[17]//td[2]/div/span")
	public static WebElement Equipment;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[21]//td[2]/div/span")
	public static WebElement Mode;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[23]//td[2]/div/span")
	public static WebElement Payment_term;
	
	@FindBy(xpath="(//table[@class=\"gridTable \"])[2]/tbody//tr[39]/td[2]/div/span")
	public static WebElement Service_level;
	
	
	
	//order ref gettext
	
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[2]//td[2]/div/span")
	public static WebElement Orderref_bol_text;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[3]//td[2]/div/span")
	public static WebElement Orderref_Deliverynum_text;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[4]//td[2]/div/span")
	public static WebElement Orderref_Invoicenum_text;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[5]//td[2]/div/span")
	public static WebElement Orderref_pickupnum_text;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[6]//td[2]/div/span")
	public static WebElement Orderref_POnum_text;
	
	@FindBy(xpath="(//table[@class='gridTable '])[2]/tbody//tr[8]//td[2]/div/span")
	public static WebElement Orderref_trackingnum_text;
	
	
}
