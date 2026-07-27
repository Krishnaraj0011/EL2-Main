package Test_Case;


import Page_Object.Clipboard;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Page_Object.Authentication_page;
import Page_Object.COD_singlecaseflow;
import Page_Object.CrowleyTL;
import Page_Object.Crowley_ondock_UI;
import Page_Object.Dev_studio;
import Page_Object.Home_page;
import Test_Utilities.Reuse_methods;

public class Crowley_on_dock_test extends Base_methods{
	
    @Test
    public void COD_bulk_action() throws Exception {
    
    	 Authentication_page ap = new Authentication_page(driver);
    	 ap.BtnLogin_with_corporate();
    	 ap.Btn_verify_identity();
    	 Reuse_methods rm = new Reuse_methods(driver); 
    	 String OTP =  rm.Scanner();
    	 ap.Verify_OTP(OTP);
    	 ap.Btn_submit();
    	 Thread.sleep(3000);
    	 Dev_studio ds=new Dev_studio(driver);
    	 ds.clickLaunchPortal();
    	 Thread.sleep(2000);
    	 ds.clickWarehousePortal();
    	 ET.log(Status.PASS, "Warehouse portal launched successfully");
    	 Thread.sleep(1500);
    	 
    	 //create order 
    	 rm.order_create("\\src\\Files\\OrdersPAR");
    	 Thread.sleep(1500);
    	 ET.log(Status.PASS, "Order created successfully");
    	 
    	 //home page
    	 Home_page hp = new Home_page(driver);
    	 rm.windowhandles();
    	 Thread.sleep(4000);
    	 hp.leftnav_Crowleyondock();
    	 rm.switchtoframe("PegaGadget0Ifr");
    	 
    	 // Crowley on dock UI
    	 Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
    	 //driver.navigate().refresh();
    	 //Thread.sleep(3000);
    	 co.Bolsearch_txt(rm.BOL_String);
    	 co.clk_Boldropdown();
    	 Thread.sleep(1000);
    	 co.clk_overallckeckbox();
    	 Thread.sleep(1500);
    	 co.Clk_receiveorder_btn();
    	 co.txt_receiveddate("3/18/2026 9:25 AM");
    	 co.Clk_submit_btn();
    	 ET.log(Status.PASS, "Received order successfully");
    	 
    	 //Assign carrier  
    	 Thread.sleep(2000);
    	 co.clk_overallckeckbox();
    	 co.Assign_carrier_btn();
    	 co.Assign_carrier_drp_popup(); 
		rm.selectclass(co.Assigncarrierpopupdropdown, "Estes Express Lines");
		co.Assigncarrier_submit();
		 ET.log(Status.PASS, "Carrier assigned as expected ");
		
		//Assign LoadID
		Thread.sleep(3000);
		co.clk_overallckeckbox();
		co.Assign_loadID_btn();
		co.Assign_loadID_textbox();
		co.Outboundload_popup_sbt();
		 ET.log(Status.PASS, "Assigned Load ID for the order");
		
		//Assign Ob trailer 
		Thread.sleep(3000);
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
		co.Releasedate_input("3/19/2026 4:00 AM");
		co.Releasedatepopup_submit();
		Thread.sleep(1000);
		 ET.log(Status.PASS, "Case has been moved to released as expected ");
		//driver.switchTo().defaultContent();
		
		//POD review 
		co.POD_review_Header();
		Thread.sleep(3000);
		co.FirstcaseID();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget1Ifr");
		Thread.sleep(2000);
		co.ArrivedatPickupDate("3/14/26 6:14 AM");
		co.DepartAtPickup("3/15/26 6:14 AM");
		Thread.sleep(1500);
		co.LineHaulArriveatTerminal("3/16/26 6:14 AM");
		co.LinehaulComplete("3/17/26 6:14 AM");
		Thread.sleep(1500);
		co.Submitbtn();
		 ET.log(Status.PASS, "Required dates are entered through UI as expected");
		driver.switchTo().defaultContent();
		
		//Crowley TL attachment 
		hp.CrowleyTL_leftNav();
		driver.switchTo().frame("PegaGadget2Ifr");
		CrowleyTL ct= new CrowleyTL(driver);
		ct.refresh();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("PegaGadget2Ifr");
		Thread.sleep(2000);
		ct.AttachPOD_btn();
		ct.EnterIB_loadID_input(rm.Invoicenum);
		ct.Search_btn();
		Thread.sleep(1000);
		ct.Submit_btn();
		Thread.sleep(3000);
		ct.selectfile();
		Thread.sleep(2000);
		ct.crowleyTL_submitbtn();
		driver.switchTo().defaultContent();
		 ET.log(Status.PASS, "Attachment added to the case through crowleyTL as expected ");
		
		//POD accepted or POD confirm number
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
		ds.PyIDtextfield_input(rm.Order1);
		ds.PODConfirmNumber_input();
		Thread.sleep(1000);
		ds.runbtn();
		Thread.sleep(5000);
		rm.switchto_newwindow();
		driver.close();
		rm.switchto_newwindow();
		driver.close();
		rm.switchto_newwindow(); 
		 ET.log(Status.PASS, "Added confirm number to case as expected");
		
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
		co.PODReview_Bolsearch_txt(rm.BOL_String);
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
	
		//validation in clipboard orderpage
		
		String ATP = co.Assign_trading_partner.getText();
		System.out.println(ATP);
		Assert.assertEquals(ATP, "pMrEpO2ysOuRIbHr");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Assigned trading partner ID is mapped in clipboard orderpage as expected");
		
		String RTP = co.Requesting_trading_partner.getText();
		System.out.println(RTP);
		Assert.assertEquals(RTP, "dd1a754a-01e9-4b5e-ad31-ce14c9d65e62");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Requesting trading partner ID is mapped in clipboard orderpage as expected");
		
		String ATPN = co.Assign_trading_partner_name.getText();
		System.out.println(ATPN);
		Assert.assertEquals(ATPN, "EL2-Manteca");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Assigned trading partner name is mapped in clipboard orderpage as expected");
		
		String Casetype = co.Casetype.getText();
		System.out.println(Casetype);
		Assert.assertEquals(Casetype, "PickupAndRelease");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Casetype is mapped in clipboard orderpage as expected");
		
		String Equipment = co.Equipment.getText();
		System.out.println(Equipment);
		Assert.assertEquals(Equipment, "Trailer");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Casetype is mapped in clipboard orderpage as expected");
		
		String Mode = co.Mode.getText();
		System.out.println(Mode);
		Assert.assertEquals(Mode, "CrowleyTL");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Casetype is mapped in clipboard orderpage as expected");
		
		String Payment_term = co.Payment_term.getText();
		System.out.println(Payment_term);
		Assert.assertEquals(Payment_term, "Inbound Prepaid");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Casetype is mapped in clipboard orderpage as expected");
		
		String Service_level = co.Service_level.getText();
		System.out.println(Service_level);
		Assert.assertEquals(Service_level, "Basic");
		Thread.sleep(1000);
		ET.log(Status.PASS, "Casetype is mapped in clipboard orderpage as expected");
		
		clp.Plus_orderpage();
		
		// Order ref validation
		
		clp.Order_ref();
		Thread.sleep(2000);
		
		String Orderref_BOL = co.Orderref_bol_text.getText();
		System.out.println(Orderref_BOL);
		Assert.assertEquals(Orderref_BOL, rm.BOL_String );
		Thread.sleep(1000);
		ET.log(Status.PASS, "BOL is mapped in OrderRef as expected");
		
		String Orderref_Deliverynum = co.Orderref_Deliverynum_text.getText();
		System.out.println(Orderref_Deliverynum);
		Assert.assertEquals(Orderref_Deliverynum, "543452" );
		Thread.sleep(1000);
		ET.log(Status.PASS, "Delivery num is mapped in OrderRef as expected"); 
		
		String Orderref_invoicenum = co.Orderref_Invoicenum_text.getText();
		System.out.println(Orderref_invoicenum);
		Assert.assertEquals(Orderref_invoicenum, rm.Invoicenum );
		Thread.sleep(1000);
		ET.log(Status.PASS, "Invoice num is mapped in OrderRef as expected");
		
		String Orderref_Pickupnum = co.Orderref_pickupnum_text.getText();
		System.out.println(Orderref_Pickupnum);
		Assert.assertEquals(Orderref_Pickupnum, "2646357511" );
		Thread.sleep(1000);
		ET.log(Status.PASS, "pickup num is mapped in OrderRef as expected");
		
		String Orderref_Ponum = co.Orderref_POnum_text.getText();
		System.out.println(Orderref_Ponum);
		Assert.assertEquals(Orderref_Ponum, "6545646" );
		Thread.sleep(1000);
		ET.log(Status.PASS, "PO num is mapped in OrderRef as expected");
		
		String Orderref_trackingnum = co.Orderref_trackingnum_text.getText();
		System.out.println(Orderref_trackingnum);
		Assert.assertEquals(Orderref_trackingnum, "54321" );
		Thread.sleep(1000);
		ET.log(Status.PASS, "PO num is mapped in OrderRef as expected");
		
		//Order origin validation
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
		
		String Origin_address1 = tdValues_orderorigin.get(0).toString();
		Assert.assertEquals(Origin_address1, "460 STERLING STREET");
		ET.log(Status.PASS, " Origin_city is mapped in Order origin as expected");
		
		String Origin_city = tdValues_orderorigin.get(1).toString();
		Assert.assertEquals(Origin_city, "Camp Hill");
		ET.log(Status.PASS, " Origin_city is mapped in Order origin as expected");
		
		String Origin_companyname = tdValues_orderorigin.get(2).toString();
		Assert.assertEquals(Origin_companyname, "Consol Crowley C/O MLM Logistics");
		ET.log(Status.PASS, " Origin_companyname is mapped in Order origin as expected");
		
		String Origin_country = tdValues_orderorigin.get(4).toString();
		Assert.assertEquals(Origin_country, "US");
		ET.log(Status.PASS, " Origin_country is mapped in Order origin as expected");
		
		String Origin_location = tdValues_orderorigin.get(5).toString();
		Assert.assertEquals(Origin_location, "Camp Hill,PA");
		ET.log(Status.PASS, " Origin_location is mapped in Order origin as expected");
		
		String Origin_Phone = tdValues_orderorigin.get(6).toString();
		Assert.assertEquals(Origin_Phone, "9872726221");
		ET.log(Status.PASS, " Origin_Phone is mapped in Order origin as expected");
		
		String Origin_Postalcode = tdValues_orderorigin.get(7).toString();
		Assert.assertEquals(Origin_Postalcode, "17011");
		ET.log(Status.PASS, " Origin_Postalcode is mapped in Order origin as expected");
		
		String Origin_State = tdValues_orderorigin.get(9).toString();
		Assert.assertEquals(Origin_State, "PA");
		ET.log(Status.PASS, " Origin_State is mapped in Order origin as expected");
		
		//order destination validation 
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
		
		String Destination_Address1 = tdValues_order_des.get(0).toString();
		Assert.assertEquals(Destination_Address1, "BLDG 977 CP 707 424 3992 90 RAGSDALE ST");
		ET.log(Status.PASS, " Destination_Address1 is mapped in order destination as expected");
		
		String Destination_city = tdValues_order_des.get(1).toString();
		Assert.assertEquals(Destination_city, "TRAVIS AFB");
		ET.log(Status.PASS, " Destination_city is mapped in order destination as expected");
		
		String Destination_companyname = tdValues_order_des.get(2).toString();
		Assert.assertEquals(Destination_companyname, "000SUU-94535-FY9150 60 APS TRK INTRANSIT CARGO BLDG 977 CP 7");
		ET.log(Status.PASS, " Destination_companyname is mapped in order destination as expected");
		
		String Destination_country = tdValues_order_des.get(4).toString();
		Assert.assertEquals(Destination_country, "USA");
		ET.log(Status.PASS, " Destination_country is mapped in order destination as expected");
		
		String Destination_phone = tdValues_order_des.get(5).toString();
		Assert.assertEquals(Destination_phone, "qwer");
		ET.log(Status.PASS, " Destination_country is mapped in order destination as expected");
		
		String Destination_postalcode = tdValues_order_des.get(6).toString();
		Assert.assertEquals(Destination_postalcode, "94535");
		ET.log(Status.PASS, " Destination_country is mapped in order destination as expected");
		
		String Destination_state = tdValues_order_des.get(8).toString();
		Assert.assertEquals(Destination_state, "CA");
		ET.log(Status.PASS, " Destination_country is mapped in order destination as expected");
		
		driver.close();
		
		rm.switchtopreviouswwindow(0);
		ds.datatype_clk();
		ds.Ordertable_record_clk();
		Thread.sleep(4000);
		driver.switchTo().frame("PegaGadget1Ifr");
		Thread.sleep(3000);
		ds.Ordertable_searchfield_clk(rm.Order1);
		Thread.sleep(2000);
		ds.Ordertable_searchicon_clk();
		Thread.sleep(4000);
		
		
		List<String> tdValues = new ArrayList<>();

		List<WebElement> tdList = driver.findElements(By.xpath("(//table[@class='gridTable '])[2]/tbody//tr[2]/td"));
		Thread.sleep(2000);
		for (int i = 0; i < tdList.size(); i++) 
		{
		    tdValues.add(tdList.get(i).getText().toString());
		}

		System.out.println(tdValues);
		
		String ATP_id = tdValues.get(1);
		System.out.println(ATP_id);
		Assert.assertEquals(ATP_id, "pMrEpO2ysOuRIbHr");
		ET.log(Status.PASS, "Assigned trading partner is mapped as expected");
		
		String BOL = tdValues.get(43).toString();
		Assert.assertEquals(BOL, rm.BOL_String);
		ET.log(Status.PASS, "BOL is mapped in Ordertable as expected");
		
		String OT_tracking = tdValues.get(2);
		Assert.assertEquals(OT_tracking, "54321" );
		ET.log(Status.PASS, " Tracking number is mapped in ordertable as expected");
		
		String OT_Pickupnum = tdValues.get(3);
		Assert.assertEquals(OT_Pickupnum, "2646357511" );
		ET.log(Status.PASS, " Pickupnumber is mapped in ordertable as expected");

		String OT_Ponumber = tdValues.get(4);
		Assert.assertEquals(OT_Ponumber, "6545646");
		ET.log(Status.PASS, " Ponumber is mapped in ordertable as expected");
	
		String Invoicenumber = tdValues.get(5);
		Assert.assertEquals(Invoicenumber,rm.Invoicenum );
		ET.log(Status.PASS, " Invoice number is mapped in ordertable as expected");
		
		//Order details validation
		
		String equipment = tdValues.get(35);
		Assert.assertEquals(equipment, "Trailer");
		ET.log(Status.PASS, " Equipment is mapped in ordertable as expected");
		
		String OT_Mode = tdValues.get(6);
		Assert.assertEquals(Mode, "CrowleyTL");
		ET.log(Status.PASS, " Mode is mapped in ordertable as expected");
		
		String OT_Serivelvl = tdValues.get(34);
		Assert.assertEquals(OT_Serivelvl, "Basic");
		ET.log(Status.PASS, " Serivelvl is mapped in ordertable as expected");
		
		//order origin details validation
		
		String OT_Origincompany = tdValues.get(7);
		Assert.assertEquals(OT_Origincompany, "Consol Crowley C/O MLM Logistics");
		ET.log(Status.PASS, " Origincompany is mapped in ordertable as expected");
		
		String Originaddress = tdValues.get(8);
		Assert.assertEquals(Originaddress, "460 STERLING STREET");
		ET.log(Status.PASS, " Originaddress is mapped in ordertable as expected");
		
		String Origincity = tdValues.get(10);
		Assert.assertEquals(Origincity, "Camp Hill");
		ET.log(Status.PASS, " Origincity is mapped in ordertable as expected");
		
		String Originstate = tdValues.get(11);
		Assert.assertEquals(Originstate, "PA");
		ET.log(Status.PASS, " Originstate is mapped in ordertable as expected");
		
		String Originpostalcode = tdValues.get(12);
		Assert.assertEquals(Originpostalcode, "17011");
		ET.log(Status.PASS, " Originpostalcode is mapped in ordertable as expected");
		
		//order destination details validation 
		
		String Destianationname = tdValues.get(17);
		Assert.assertEquals(Destianationname, "000SUU-94535-FY9150 60 APS TRK INTRANSIT CARGO BLDG 977 CP 7");
		ET.log(Status.PASS, " Destianation name is mapped in ordertable as expected");
		
		
		String Destianationaddress = tdValues.get(18);
		Assert.assertEquals(Destianationaddress, "BLDG 977 CP 707 424 3992 90 RAGSDALE ST");
		ET.log(Status.PASS, " Destianationaddress is mapped in ordertable as expected");
		
		String Destianationcity = tdValues.get(20);
		Assert.assertEquals(Destianationcity, "TRAVIS AFB");
		ET.log(Status.PASS, " Destianationcity is mapped in ordertable as expected");
		
		String Destianationstate = tdValues.get(22);
		Assert.assertEquals(Destianationstate, "CA");
		ET.log(Status.PASS, " Destianationstate is mapped in ordertable as expected");
		
		String DestianationPostal = tdValues.get(21);
		Assert.assertEquals(DestianationPostal, "94535");
		ET.log(Status.PASS, " Destianationstate is mapped in ordertable as expected");
		
		//appoinmentdate validation
		
		String PickupRequestTWStart = tdValues.get(51);
		Assert.assertEquals(PickupRequestTWStart, "1/27/2025 7:00 AM");
		ET.log(Status.PASS, " PickupRequestTWStart date is mapped in ordertable as expected");
		
		String DeliverByTWStart = tdValues.get(49);
		Assert.assertEquals(DeliverByTWStart, "1/27/2025 7:00 AM");
		ET.log(Status.PASS, " DeliverByTWStart date is mapped in ordertable as expected");
		
		driver.quit();
    }
       
}