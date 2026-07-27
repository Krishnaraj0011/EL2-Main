package Test_Case;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Page_Object.Authentication_page;
import Page_Object.Clipboard;
import Page_Object.Constructor_Baseclass;
import Page_Object.Create_crowley_UI;
import Page_Object.CrowleyTL;
import Page_Object.Crowley_ondock_UI;
import Page_Object.Dev_studio;
import Page_Object.Home_page;
import Test_Utilities.Reuse_methods;

public class COD_UI_ordercreate extends Base_methods{
	
	public static String Pronumber;
	public static String Track_number;
	public static String Invoice_num;
	public static String Pickup_number;
	public static String Po_number;
	
	@Test
	 public void COD_UI_order() throws Exception{
		
	 Authentication_page ap = new Authentication_page(driver);
   	 ap.BtnLogin_with_corporate();
   	 ap.Btn_verify_identity();
   	 Reuse_methods rm = new Reuse_methods(driver); 
   	 String OTP =  rm.Scanner();
   	 ap.Verify_OTP(OTP);
   	 ap.Btn_submit();
   	 Thread.sleep(2000);
   	 Dev_studio ds=new Dev_studio(driver);
   	 ds.clickLaunchPortal();
   	 Thread.sleep(2000);
   	 ds.Adminportal_clk();
   	 ET.log(Status.PASS, "Launched Admin portal successfully");
   	 Thread.sleep(4000);
   	 
   	 rm.windowhandles();
   	 Home_page hp = new Home_page(driver);
   	 hp.Create_crowley();
   	 Thread.sleep(2000);
   	 driver.switchTo().frame("PegaGadget0Ifr");
   	 
   	 //Order details
   	 
   	 Create_crowley_UI cc =new Create_crowley_UI(driver);
   	 cc.Pickupnumber.click();
   	 Thread.sleep(2000);
   	 rm.selectclass(cc.Assigntradingpartner_drdn, "EL2-Manteca");
   	 //rm.selectclass(cc.Casetype_drdn, );
   	rm.selectclass(cc.Casetype_drdn, "PickupAndRelease");
	Thread.sleep(500);
	rm.selectclass(cc.Equipment_drdn, "Trailer");
	Thread.sleep(500);
	rm.selectclass(cc.CrowleyMode_drdn, "CrowleyTL");
	Thread.sleep(500);
	rm.selectclass(cc.PaymentTerm_drdn, "Inbound Prepaid");
	Thread.sleep(500);
	rm.selectclass(cc.Servicelevel_drdn, "Curbside");
	
	 ET.log(Status.PASS, "Order details entered as expected");
	
	//Order Details
	
	double Pro = Math.ceil(Math.random() * 1000000000);
	Pronumber = Double.toString(Pro);
	System.out.println("Pronumber = " + Pronumber);
	Thread.sleep(500);
	cc.Pro_number.sendKeys(Pronumber);
	Thread.sleep(500);
	double TN  = Math.ceil(Math.random() * 300000);
	Track_number = Double.toString(TN);
	System.out.println("Tracking number = " + Track_number);
	Thread.sleep(500);
	cc.Tracking_number.sendKeys(Track_number);
	double IN  = Math.ceil(Math.random() * 300000);
	Invoice_num = Double.toString(IN);
	System.out.println("Invoice number = " + Invoice_num);
	Thread.sleep(500);
	cc.Invoice_number.sendKeys(Invoice_num);
	double PN  = Math.ceil(Math.random() * 300000);
	Pickup_number = Double.toString(PN);
	System.out.println("Pickup_num = " + Pickup_number);
	Thread.sleep(500);
	cc.Pickupnumber.sendKeys(Pickup_number);
	double Ponum  = Math.ceil(Math.random() * 300000);
	Po_number = Double.toString(Ponum);
	System.out.println("Po_number = " + Po_number);
	Thread.sleep(500);
	cc.Ponumber.sendKeys(Po_number);
	
	 ET.log(Status.PASS, "Entered order ref details as expected");
	
	//Order Origin Details
	
	rm.selectclass(cc.Origincompany, "Consol Crowley C/O MLM Logistics");
	Thread.sleep(500);
	rm.selectclass(cc.Origin_address1, "460 STERLING STREET");
	Thread.sleep(500);
	rm.selectclass(cc.Origin_city, "CAMP HILL");
	Thread.sleep(500);
	rm.selectclass(cc.Origin_state, "PA");
	Thread.sleep(500);
	rm.selectclass(cc.Origin_postalcode, "17011");
	 ET.log(Status.PASS, "Entered order origin details as expected");
	
	//Order Destination Details
	
	Thread.sleep(500);;
	cc.Destination_address1.sendKeys("BLDG 977 CP 707 424 3992 90 RAGSDALE ST");
	Thread.sleep(500);
	cc.Destination_company.sendKeys("000SUU-94535-FY9150 60 APS TRK INTRANSIT CARGO BLDG 977 CP 7");
	Thread.sleep(500);
	cc.Destination_city.sendKeys("TRAVIS AFB");
	Thread.sleep(500);;
	cc.Destination_state.sendKeys("CA");
	Thread.sleep(500);;
	cc.Destination_Postalcode.sendKeys("94535");
	
	 ET.log(Status.PASS, "Entered order destination details as expected");
	
	//Items,HandlingUnit and Accessorial
	Thread.sleep(2000);
	cc.Add_item.click();
	Thread.sleep(500);
	cc.Popup_additem.click();
	Thread.sleep(500);;
	cc.Item_name.sendKeys("Test");
    Thread.sleep(500);;
	cc.Item_quantity.sendKeys("2");
	Thread.sleep(500);;
	cc.Total_weight.sendKeys("20");
	Thread.sleep(500);;
	cc.Onhandling_unit.sendKeys("1");
	Thread.sleep(500);;
	cc.Popup_Submitbtn.click();
	
	 ET.log(Status.PASS, "Item details are entered as expected ");
			
			
	//Handling unit
	cc.Add_handlingunits_btn.click();
	Thread.sleep(500);;
	cc.Popup_Add_handlingunits_btn.click();
	Thread.sleep(500);;
	cc.Client_id.click();
	Thread.sleep(500);;
	cc.Client_id.sendKeys("Test");
	Thread.sleep(500);;
	cc.HandlingUnit_quantity.sendKeys("2");
	Thread.sleep(500);;
	cc.HandlingUnit_type.sendKeys("test");
	Thread.sleep(500);;
	cc.Length.sendKeys("10");
	Thread.sleep(500);;
	cc.Width.sendKeys("20");
	Thread.sleep(500);;
	cc.Height.sendKeys("30");
	Thread.sleep(500);;
	cc.Popup_Submitbtn.click();
	
	 ET.log(Status.PASS, "Handling unit details are entered as expected");
	
	//Add accessorial
	cc.Add_Accessorial.click();
	Thread.sleep(1000);
	cc.Popup_add_accessorial.click();
	Thread.sleep(500);;
	cc.Accessorial_code.sendKeys("C");
	Thread.sleep(500);;
	cc.Accessorial_location.sendKeys("Pickup");
	Thread.sleep(500);;
	cc.Accessorial_Quantity.sendKeys("1");
	Thread.sleep(500);;
	cc.Submit_btn.click();
	
	 ET.log(Status.PASS, "Added accessorial item to the case as expected");
	
	//Appointment date
	Thread.sleep(500);;
	cc.PickupRequestTWStart.sendKeys("05/21/2026");
	Thread.sleep(500);;
	cc.DeliverByTWStart.sendKeys("05/22/2026");
	Thread.sleep(500);;
	cc.Confirm_order_btn.click();
	Thread.sleep(1000);
	cc.Popup_confirm_order.click();
	Thread.sleep(2000);
	cc.Submitbtn.click();
	driver.switchTo().defaultContent();
	driver.close();
	rm.switchtopreviouswwindow(0);
	Thread.sleep(2000);
	ds.clickLaunchPortal();
	Thread.sleep(1500);
	 ET.log(Status.PASS, "Crowley order created successfully through create crowley UI");
	
	//warehouse portal 
	 ds.clickWarehousePortal();
	 Thread.sleep(1500);
	 ET.log(Status.PASS, "Warehouse portal launched successfully");
	 
	 rm.windowhandles();
	 Thread.sleep(4000);
	 hp.leftnav_Crowleyondock();
	 rm.switchtoframe("PegaGadget0Ifr");
	 
	 // Crowley on dock UI
	 Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
	 co.Bolsearch_txt(Pronumber);
	 co.clk_Boldropdown();
	 Thread.sleep(3000);
	 co.clk_overallckeckbox();
	 Thread.sleep(3000);
	 co.Clk_receiveorder_btn();
	 co.txt_receiveddate("6/18/2026 9:25 AM");
	 co.Clk_submit_btn();
	 ET.log(Status.PASS, "Received order successfully");
	 
	 //Assign carrier  
	 Thread.sleep(3000);
	 co.clk_overallckeckbox();
	 co.Assign_carrier_btn();
	 co.Assign_carrier_drp_popup(); 
	 rm.selectclass(co.Assigncarrierpopupdropdown, "Estes Express Lines");
	 co.Assigncarrier_submit();
	 ET.log(Status.PASS, "Carrier assigned as expected ");
	
	//Assign LoadID
	Thread.sleep(2000);
	co.clk_overallckeckbox();
	co.Assign_loadID_btn();
	co.Assign_loadID_textbox();
	co.Outboundload_popup_sbt();
	 ET.log(Status.PASS, "Assigned Load ID for the order");
	 
	//Assign Ob trailer 
	Thread.sleep(2000);
	co.clk_overallckeckbox();
	co.AssignOBtrailer_button();
	co.Loaded_date_input();
	co.Trailernumber_input();
	co.Assignobtrailer_submit();
	 ET.log(Status.PASS, "Assign Ob trailer successfully");
	 
	//Released 
	Thread.sleep(2000);
	co.clk_overallckeckbox();
	co.Releasebutton();
	co.Releasedate_input("6/19/26 6:14 AM");
	co.Releasedatepopup_submit();
	Thread.sleep(1000);
	 ET.log(Status.PASS, "Case has been moved to released as expected ");
	//driver.switchTo().defaultContent();
	
	//POD review 
	co.POD_review_Header();
	Thread.sleep(4000);
	WebElement Case = driver.findElement(By.xpath("//table[@class='gridTable ']/tbody//tr[2]//td[2]/div/span/a"));
	String Case_ID = Case.getText();
	Thread.sleep(2000);
	co.FirstcaseID();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("PegaGadget1Ifr");
	Thread.sleep(2000);
	co.ArrivedatPickupDate("6/14/2026 9:25 AM");
	co.DepartAtPickup("6/15/2026 9:25 AM");
	Thread.sleep(1500);
	co.LineHaulArriveatTerminal("6/16/26 6:14 AM");
	co.LinehaulComplete("6/17/26 6:14 AM");
	Thread.sleep(1500);
	co.Submitbtn();
	driver.switchTo().defaultContent();
	
	//crowleyTL attachment
	
	hp.CrowleyTL_leftNav();
	driver.switchTo().frame("PegaGadget2Ifr");
	CrowleyTL ct= new CrowleyTL(driver);
	ct.refresh();
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("PegaGadget2Ifr");
	Thread.sleep(2000);
	ct.AttachPOD_btn();
	ct.EnterIB_loadID_input(Invoice_num);
	ct.Search_btn();
	Thread.sleep(1000);
	ct.Submit_btn();
	Thread.sleep(3000);
	ct.selectfile();
	Thread.sleep(2000);
	ct.crowleyTL_submitbtn();
	driver.switchTo().defaultContent();
	 ET.log(Status.PASS, "Attachment added to the case through crowleyTL as expected ");
	
	//POD confirm number
		
	rm.switchtopreviouswwindow(0);
	ds.Favorites();
	Thread.sleep(2000);
	ds.ConfirmPOD();
	driver.switchTo().frame("PegaGadget0Ifr");
	ds.Actiondropdown();
	Thread.sleep(1000);
	ds.runoption();
	rm.switchto_newwindow();
	Thread.sleep(1000);
	ds.PyIDtextfield_input(Case_ID);
	ds.PODConfirmNumber_input();
	Thread.sleep(1000);
	ds.runbtn();
	Thread.sleep(5000);
	 ET.log(Status.PASS, "Added confirm number to case as expected");
	rm.switchto_newwindow();
	driver.close();
	rm.switchto_newwindow();
	driver.close();
	rm.switchto_newwindow();
	
	//Approve POD
	co.Crowleyondock_UI_header();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("PegaGadget0Ifr");
	Thread.sleep(1000);
	co.COD_UI_refresh();
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("PegaGadget0Ifr");
	co.POD_review_Header();
	Thread.sleep(1000);
	co.PODReview_Bolsearch_txt(Pronumber);
	Thread.sleep(2000);
	co.clk_Boldropdown();
	Thread.sleep(1000);
	co.POD_review_overallcheckbox();
	co.ApprovePODbutton();
	Thread.sleep(1000);
    co.AprovePOD_sbt_btn();
    ET.log(Status.PASS, "Approve POD button is working as expected");
    driver.switchTo().defaultContent();
	co.Case_id_header_clk();
	driver.switchTo().frame("PegaGadget1Ifr");
	co.CaseID_action_drdn_clk();
	Thread.sleep(2000);
	co.Caselvl_refresh();
	//co.Case_status_text();
	
	driver.switchTo().defaultContent();
	
	Clipboard clp = new Clipboard(driver);
	
	clp.Case_lvl_settings_icon();
	clp.Clipboard_icon_clk();
	rm.switchto_newwindow();
	clp.plus_pyworkpage();
	clp.clipboard_order_pg_clk();
	
	//clipboard order table 
	
	System.out.println("Order table details : ");
	
	List<String> tdValues_Clp_order_tbl = new ArrayList<>();

	List<WebElement> tdList_Clp_order_tbl = driver.findElements(By.xpath("(//table[@class='gridTable '])[2]/tbody//tr//td/div/span"));
	Thread.sleep(2000);
	for (int i = 0; i < tdList_Clp_order_tbl.size(); i++) 
	{
		tdValues_Clp_order_tbl.add(tdList_Clp_order_tbl.get(i).getText().toString());
	}
	
	String ATP_id = tdValues_Clp_order_tbl.get(5);
	Assert.assertEquals(ATP_id, "pMrEpO2ysOuRIbHr");

	String ATP_name = tdValues_Clp_order_tbl.get(6);
	Assert.assertEquals(ATP_name, "EL2-Manteca");
	ET.log(Status.PASS, "Assigned trading partner name is mapped in clipboard orderpage as expected");

	String casetype = tdValues_Clp_order_tbl.get(7);
	Assert.assertEquals(casetype, "PickupAndRelease");
	ET.log(Status.PASS, "Casetype is mapped in clipboard orderpage as expected");
	
	String equipment = tdValues_Clp_order_tbl.get(11);
	Assert.assertEquals(equipment, "Trailer");
	ET.log(Status.PASS, "Equipment is mapped in clipboard orderpage as expected");
		
	String Mode = tdValues_Clp_order_tbl.get(14);
	Assert.assertEquals(Mode, "CrowleyTL");
	ET.log(Status.PASS, "Mode is mapped in clipboard orderpage as expected");

	String Payment_term = tdValues_Clp_order_tbl.get(16);
	Assert.assertEquals(Payment_term,"Inbound Prepaid");
	ET.log(Status.PASS, "Payment term is mapped in clipboard orderpage as expected");

	String RTP_ID = tdValues_Clp_order_tbl.get(28);
	Assert.assertEquals(RTP_ID,"dd1a754a-01e9-4b5e-ad31-ce14c9d65e62");
	ET.log(Status.PASS, "Requesting trading partner ID is mapped in clipboard orderpage as expected");

	String RTP_name = tdValues_Clp_order_tbl.get(29);
	Assert.assertEquals(RTP_name,"Crowley");
	ET.log(Status.PASS, "Requesting trading partner name is mapped in clipboard orderpage as expected");

	String Service_lvl = tdValues_Clp_order_tbl.get(30);
	Assert.assertEquals(Service_lvl,"Curbside");
	ET.log(Status.PASS, "Service level is mapped in clipboard orderpage as expected");

	// Order ref
	
	System.out.println("Order ref details : ");
	clp.Plus_orderpage();
	clp.Order_ref();
	Thread.sleep(2000);
	
	List<String> tdValues_clp_order_ref = new ArrayList<>();

	List<WebElement> tdList_clp_order_ref = driver.findElements(By.xpath("(//table[@class='gridTable '])[2]/tbody//tr//td/div/span"));
	Thread.sleep(2000);
	for (int i = 0; i < tdList_clp_order_ref.size(); i++) 
	{
		tdValues_clp_order_ref.add(tdList_clp_order_ref.get(i).getText().toString());
	}

	System.out.println(tdValues_clp_order_ref);

	String BOL = tdValues_clp_order_ref.get(0);
	Assert.assertEquals(BOL,Pronumber);
	ET.log(Status.PASS, "BOL is mapped in clipboard orderref as expected");

	String Delivery_num = tdValues_clp_order_ref.get(1);
	Assert.assertEquals(Delivery_num,"543452");
	ET.log(Status.PASS, "Delivery number is mapped in clipboard orderref as expected");

	String Invoice_number = tdValues_clp_order_ref.get(2);
	Assert.assertEquals(Invoice_number, Invoice_num);
	ET.log(Status.PASS, "Invoice number is mapped in clipboard orderref as expected");

	String Pickup_num = tdValues_clp_order_ref.get(3);
	Assert.assertEquals(Pickup_num, Pickup_number);
	ET.log(Status.PASS, "pickup number is mapped in clipboard orderref as expected");

	String Po_num = tdValues_clp_order_ref.get(4);
	Assert.assertEquals(Po_num, Po_number  );
	ET.log(Status.PASS, "Po number is mapped in clipboard orderref as expected");

	String Tracking_number = tdValues_clp_order_ref.get(6);
	Assert.assertEquals(Tracking_number,  Track_number );
	ET.log(Status.PASS, "tracking number is mapped in clipboard orderref as expected");
	
	//Order Origin validation -------------------------------------------------------------------
	
	System.out.println("Order origin details : ");
	
	clp.Order_origin_clk();
	Thread.sleep(2000);	
	
	List<String> tdValues_orderorigin = new ArrayList<>();

	List<WebElement> tdList_orderorigin = driver.findElements(By.xpath("(//div[@id='gridBody_right'])[2]/table/tbody/tr/td/div/span"));
	Thread.sleep(2000);
	for (int i = 0; i < tdList_orderorigin.size(); i++) 
	{
		tdValues_orderorigin.add(tdList_orderorigin.get(i).getText().toString());
	}
	
	System.out.println(tdValues_orderorigin);

	String Origin_address1 = tdValues_orderorigin.get(0);
	Assert.assertEquals(Origin_address1,  "460 STERLING STREET" );
	ET.log(Status.PASS, "Origin address1 is mapped in clipboard as expected");
	
	String city = tdValues_orderorigin.get(1);
	Assert.assertEquals(city,  "CAMP HILL" );
	ET.log(Status.PASS, "Origin city is mapped in clipboard as expected");
	
	String companyname = tdValues_orderorigin.get(2);
	Assert.assertEquals(companyname,  "Consol Crowley C/O MLM Logistics" );
	ET.log(Status.PASS, "Origin companyname is mapped in clipboard as expected");
	
	String country = tdValues_orderorigin.get(3);
	Assert.assertEquals(country,  "USA" );
	ET.log(Status.PASS, "Origin country is mapped in clipboard as expected");
	
	String Postal_code = tdValues_orderorigin.get(5);
	Assert.assertEquals(Postal_code,  "17011" );
	ET.log(Status.PASS, "Origin postal code is mapped in clipboard as expected");
	
	String State = tdValues_orderorigin.get(7);
	Assert.assertEquals(State,  "PA" );
	ET.log(Status.PASS, "Origin state is mapped in clipboard as expected");
	
	//order destination validation ----------------------------------------------------------------------------------------------
	
	System.out.println("Order Destination details : ");
	
	clp.Order_destination_clk();
	
	Thread.sleep(2000);		
	List<String> tdValues_order_des = new ArrayList<>();

	List<WebElement> tdList_order_des = driver.findElements(By.xpath("(//div[@id='gridBody_right'])[2]/table/tbody/tr/td/div/span"));
	Thread.sleep(2000);
	for (int i = 0; i < tdList_order_des.size(); i++) 
	{
		tdValues_order_des.add(tdList_order_des.get(i).getText().toString());
	}
	
	System.out.println(tdValues_order_des);
	
	String Destination_address1 = tdValues_order_des.get(0);
	Assert.assertEquals(Destination_address1,  "BLDG 977 CP 707 424 3992 90 RAGSDALE ST" );
	ET.log(Status.PASS, "Destination address1 is mapped in clipboard as expected");
	
	String Destination_city = tdValues_order_des.get(1);
	Assert.assertEquals(Destination_city,  "TRAVIS AFB" );
	ET.log(Status.PASS, "Destination city is mapped in clipboard as expected");
	
	String Destination_name = tdValues_order_des.get(2);
	Assert.assertEquals(Destination_name,  "000SUU-94535-FY9150 60 APS TRK INTRANSIT CARGO BLDG 977 CP 7" );
	ET.log(Status.PASS, "Destination name is mapped in clipboard as expected");
	
	String Destination_country = tdValues_order_des.get(3);
	Assert.assertEquals(Destination_country,  "USA" );
	ET.log(Status.PASS, "Destination country is mapped in clipboard as expected");
	
	String Destination_postalcode = tdValues_order_des.get(4);
	Assert.assertEquals(Destination_postalcode,  "94535" );
	ET.log(Status.PASS, "Destination postal code is mapped in clipboard as expected");
	
	String Destination_state = tdValues_order_des.get(6);
	Assert.assertEquals(Destination_state,  "CA" );
	ET.log(Status.PASS, "Destination state is mapped in clipboard as expected");
	
	driver.close();
	
	rm.switchtopreviouswwindow(0);
	ds.datatype_clk();
	ds.Ordertable_record_clk();
	Thread.sleep(3000);
	driver.switchTo().frame("PegaGadget1Ifr");
	Thread.sleep(1000);
	ds.Ordertable_searchfield_clk(Pronumber);
	Thread.sleep(2000);
	ds.Ordertable_searchicon_clk();
	Thread.sleep(2500);
	
	
	List<String> tdValues = new ArrayList<>();

	List<WebElement> tdList = driver.findElements(By.xpath("(//table[@class='gridTable '])[2]/tbody//tr[2]/td"));
	Thread.sleep(2000);
	for (int i = 0; i < tdList.size(); i++) 
	{
	    tdValues.add(tdList.get(i).getText().toString());
	}

	System.out.println(tdValues);
	
	String OT_ATP_id = tdValues.get(1);
	Assert.assertEquals(OT_ATP_id , "pMrEpO2ysOuRIbHr");
	ET.log(Status.PASS, "Assigned trading partner is mapped in order table as expected");
	
	String OT_BOL = tdValues.get(43).toString();
	Assert.assertEquals(OT_BOL, Pronumber);
	ET.log(Status.PASS, "BOL is mapped in Ordertable as expected");
	
	String OT_tracking = tdValues.get(2);
	Assert.assertEquals(OT_tracking, Track_number);
	ET.log(Status.PASS, " Tracking number is mapped in ordertable as expected");
	
	String OT_Pickupnum = tdValues.get(3);
	Assert.assertEquals(OT_Pickupnum, Pickup_number);
	ET.log(Status.PASS, " Pickupnumber is mapped in ordertable as expected");

	String OT_Ponumber = tdValues.get(4);
	Assert.assertEquals(OT_Ponumber, Po_number);
	ET.log(Status.PASS, " Ponumber is mapped in ordertable as expected");

	String OT_Invoicenumber = tdValues.get(5);
	Assert.assertEquals(OT_Invoicenumber, Invoice_num);
	ET.log(Status.PASS, " Invoice number is mapped in ordertable as expected");
	
	//Order details validation
	
	String OT_equipment = tdValues.get(35);
	Assert.assertEquals(OT_equipment, "Trailer");
	ET.log(Status.PASS, " Equipment is mapped in ordertable as expected");
	
	String OT_Mode = tdValues.get(6);
	Assert.assertEquals(OT_Mode, "CrowleyTL");
	ET.log(Status.PASS, " Mode is mapped in ordertable as expected");
	
	String OT_Serivelvl = tdValues.get(34);
	Assert.assertEquals(OT_Serivelvl, "Curbside");
	ET.log(Status.PASS, " Serivelvl is mapped in ordertable as expected");
	
	//order origin details validation
	
	String OT_Origincompany = tdValues.get(7);
	Assert.assertEquals(OT_Origincompany, "Consol Crowley C/O MLM Logistics");
	ET.log(Status.PASS, " Origincompany is mapped in ordertable as expected");
	
	String OT_Originaddress = tdValues.get(8);
	Assert.assertEquals(OT_Originaddress, "460 STERLING STREET");
	ET.log(Status.PASS, " Originaddress is mapped in ordertable as expected");
	
	String OT_Origincity = tdValues.get(10);
	Assert.assertEquals(OT_Origincity, "CAMP HILL");
	ET.log(Status.PASS, " Origincity is mapped in ordertable as expected");
	
	String OT_Originstate = tdValues.get(11);
	Assert.assertEquals(OT_Originstate, "PA");
	ET.log(Status.PASS, " Originstate is mapped in ordertable as expected");
	
	String OT_Originpostalcode = tdValues.get(12);
	Assert.assertEquals(OT_Originpostalcode, "17011");
	ET.log(Status.PASS, " Originpostalcode is mapped in ordertable as expected");
	
	//order destination details validation 
	
	String OT_Destianationname = tdValues.get(17);
	Assert.assertEquals(OT_Destianationname, "000SUU-94535-FY9150 60 APS TRK INTRANSIT CARGO BLDG 977 CP 7");
	ET.log(Status.PASS, " Destianation name is mapped in ordertable as expected");
	
	
	String OT_Destianationaddress = tdValues.get(18);
	Assert.assertEquals(OT_Destianationaddress, "BLDG 977 CP 707 424 3992 90 RAGSDALE ST");
	ET.log(Status.PASS, " Destianationaddress is mapped in ordertable as expected");
	
	String OT_Destianationcity = tdValues.get(20);
	Assert.assertEquals(OT_Destianationcity, "TRAVIS AFB");
	ET.log(Status.PASS, " Destianationcity is mapped in ordertable as expected");
	
	String OT_Destianationstate = tdValues.get(22);
	Assert.assertEquals(OT_Destianationstate, "CA");
	ET.log(Status.PASS, " Destianationstate is mapped in ordertable as expected");
	
	String OT_DestianationPostal = tdValues.get(21);
	Assert.assertEquals(OT_DestianationPostal, "94535");
	ET.log(Status.PASS, " Destianationstate is mapped in ordertable as expected");
	
	//appoinmentdate validation
	
	String PickupRequestTWStart = tdValues.get(51);
	Assert.assertEquals(PickupRequestTWStart, "5/21/2026 8:00 AM");
	ET.log(Status.PASS, " PickupRequestTWStart date is mapped in ordertable as expected");
	
	String DeliverByTWStart = tdValues.get(49);
	Assert.assertEquals(DeliverByTWStart, "5/22/2026 8:00 AM");
	ET.log(Status.PASS, " DeliverByTWStart date is mapped in ordertable as expected");
	driver.switchTo().defaultContent();
	
	System.out.println("Test completed");
	
	driver.quit();
	}

}
