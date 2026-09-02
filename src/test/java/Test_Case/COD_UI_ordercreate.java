package Test_Case;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base_Class.Base_methods;
import Base_Class.TestNG_listener;
import Page_Object.Authentication_page;
import Page_Object.Clipboard;
import Page_Object.Create_crowley_UI;
import Page_Object.CrowleyTL;
import Page_Object.Crowley_ondock_UI;
import Page_Object.Dev_studio;
import Page_Object.Home_page;
import Test_Utilities.Reuse_methods;

//@Listeners(TestNG_listener.class)
public class COD_UI_ordercreate extends Base_methods {

	//public static String Pronumber;
	public static String Track_number;
	public static String Invoice_num;
	public static String Pickup_number;
	public static String Po_number;

	@Test
	public void COD_UI_order() throws Exception {

		Authentication_page ap = new Authentication_page(driver);
		Reuse_methods rm = new Reuse_methods(driver);
		Dev_studio ds = new Dev_studio(driver);
		Home_page hp = new Home_page(driver);
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		ap.loginWithMicrosoftAuthentication();
		ds.clickLaunchPortal();
		ds.Adminportal_clk();
		rm.switchToCurrentWindow();
		hp.Create_crowley();
		rm.Frame_PegaGadget0Ifr();
		Create_crowley_UI cc = new Create_crowley_UI(driver);
		cc.enteringOrderDetails();
		cc.order_Ref_details();
		cc.origin_details();
		cc.destination_Details();
		cc.Add_items();
		cc.AddHandlingUnits();
		cc.AddAccessorialItems();
		cc.appoinmentDates();
		cc.Preview_And_ConfirmOrder();
		rm.switchToDefaultContent();
		rm.close();
		rm.switchtopreviouswwindow(0);
		ds.clickLaunchPortal();
		ds.clickWarehousePortal();
		Thread.sleep(3000);
		rm.switchToCurrentWindow();
		hp.clickOnLeftnav_Crowleyondock_Btn();
		rm.Frame_PegaGadget0Ifr();
		co.codReceiveOrderBulkAction(); // Crowley on dock UI
		co.codAssignCarrier_BulkAction();// Assign carrier
		co.codAssignLoadID();// Assign LoadID
		co.codAssignOBTrailer_BulkAction();// Assign Ob trailer
		co.codReleased_BulkAction(); // Released

		// POD review
		co.clickOnPodReviewHeader();
		co.clickOnFirstCaseID();
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();
		co.codSingleCaseFlow_PodReview_action();
		rm.switchToDefaultContent();

		// Crowley TL attachment
		hp.clickOnCrowleyTL_LeftNav();
		rm.Frame_PegaGadget2Ifr();
		CrowleyTL ct = new CrowleyTL(driver);
		ct.refresh();
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget2Ifr();
		ct.crowleyTL_Attachment();
		// --------------------------------------------------
		rm.switchToDefaultContent();
		rm.switchtopreviouswwindow(0);
		ds.Favorites();

		// POD confirm number action
		ds.ConfirmPOD();
		rm.Frame_PegaGadget0Ifr();
		ds.POD_Confirm_Number();
		Thread.sleep(5000);
		rm.switchto_newwindow();
		driver.close();
		rm.switchto_newwindow();
		driver.close();
		rm.switchto_newwindow();

		// Approve POD
		co.Crowleyondock_UI_header();
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget0Ifr();
		co.clickOnPodReviewHeader();
		co.approve_pod();
		rm.switchToDefaultContent();
		co.Case_id_header_clk();
		rm.Frame_PegaGadget1Ifr();
		co.CaseID_action_drdn_clk();
		co.Caselvl_refresh();
		rm.switchToDefaultContent();
		Clipboard clp = new Clipboard(driver);
		clp.Case_lvl_settings_icon();
		clp.Clipboard_icon_clk();
		rm.switchto_newwindow();
		clp.plus_pyworkpage();
		clp.clipboard_order_pg_clk();
		// validation in clipboard orderpage
		clp.clipboardOrderTableValidationForCrowleyOnDock();
		clp.Plus_orderpage();

		// Order ref validation
		clp.Order_ref();
		clp.clipboardOrderRefValidationforCrowleyOndock();

		// Order origin validation
		clp.Order_origin_clk();
		clp.clipboardOrderOriginValidationforCrowleyOndock();

		// order destination validation
		clp.Order_destination_clk();
		clp.clipboardOrderDestinationValidationforCrowleyOndock();
		driver.close();
		rm.switchtopreviouswwindow(0);
		ds.datatype_clk();

		// Order table validation
		ds.Ordertable_record_clk();
		rm.Frame_PegaGadget1Ifr();
		ds.Ordertable_searchfield_clk();
		ds.Ordertable_searchicon_clk();
		ds.orderTableValidationforCrowleyOndock();
		driver.quit();			
	}

}
