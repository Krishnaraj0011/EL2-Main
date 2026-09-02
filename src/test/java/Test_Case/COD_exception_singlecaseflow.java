package Test_Case;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import Page_Object.COD_singlecaseflow;
import Page_Object.Clipboard;
import Page_Object.CrowleyTL;
import Page_Object.Crowley_ondock_UI;
import Page_Object.Dev_studio;
import Page_Object.Home_page;
import Test_Utilities.Reuse_methods;
import Test_Utilities.api_order_create;
import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;

@Listeners(TestNG_listener.class)

public class COD_exception_singlecaseflow extends Base_methods {

	public static WebDriverWait wait;

	@Test (priority =1)
	public void COD_shortage_exception() throws Exception {

		Authentication_page ap = new Authentication_page(driver);
		Reuse_methods rm = new Reuse_methods(driver);
		Dev_studio ds = new Dev_studio(driver);
		Home_page hp = new Home_page(driver);
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		api_order_create api = new api_order_create(driver);
		COD_singlecaseflow csf = new COD_singlecaseflow(driver);
		ap.loginWithMicrosoftAuthentication();
		ds.clickLaunchPortal();
		ds.clickWarehousePortal();
		api.order_create();
		rm.switchToCurrentWindow();
		hp.clickOnLeftnav_Crowleyondock_Btn();
		rm.Frame_PegaGadget0Ifr();
		co.enterBolInput();
		co.clickValueFromBolDropdown();
		co.FirstcaseID_cod();
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();

		// Inbound trailer
		// stage----------------------------------------------------------------
		csf.inbound_trailer_action("Shortage");

		// OSND
		// stage---------------------------------------------------------------------------
		csf.Osnd_stage_actions("Ship Short");

		// outbound load
		// stage------------------------------------------------------------------
		csf.Outbound_loaded_actions();

		// Outbound released
		// action--------------------------------------------------------------
		csf.outbound_released_action();
		co.codSingleCaseFlow_PodReview_action();
		rm.switchToDefaultContent();
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
		rm.close();
		rm.switchto_newwindow();
		rm.close();
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
		rm.close();
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

	@Test (priority = 2)
	public void COD_shortage_exception_2() throws Exception {

		Authentication_page ap = new Authentication_page(driver);
		Reuse_methods rm = new Reuse_methods(driver);
		Dev_studio ds = new Dev_studio(driver);
		Home_page hp = new Home_page(driver);
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		api_order_create api = new api_order_create(driver);
		COD_singlecaseflow csf = new COD_singlecaseflow(driver);
		ap.loginWithMicrosoftAuthentication();
		ds.clickLaunchPortal();
		ds.clickWarehousePortal();
		api.order_create();
		rm.switchToCurrentWindow();
		hp.clickOnLeftnav_Crowleyondock_Btn();
		rm.Frame_PegaGadget0Ifr();
		co.enterBolInput();
		co.clickValueFromBolDropdown();
		co.FirstcaseID_cod();
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();

		// Inbound trailer stage----------------------------------------------------------------
		csf.inbound_trailer_action("Shortage");

		// OSND stage---------------------------------------------------------------------------
		csf.Osnd_stage_actions("Short Resolved");

		// OSND stage----------------------------------------------------------------
		csf.return_auth();

		// OSNDstage----------------------------------------------------------------------------
		csf.return_loaded();

		csf.return_complete();
		// csf.outbound_released_action();

		co.codSingleCaseFlow_PodReview_action();
		rm.switchToDefaultContent();
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
		rm.close();
		rm.switchto_newwindow();
		rm.close();
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
		rm.close();
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

	@Test(priority = 3)
	public void Overage_exception() throws Exception {

		Authentication_page ap = new Authentication_page(driver);
		Reuse_methods rm = new Reuse_methods(driver);
		Dev_studio ds = new Dev_studio(driver);
		Home_page hp = new Home_page(driver);
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		api_order_create api = new api_order_create(driver);
		COD_singlecaseflow csf = new COD_singlecaseflow(driver);
		ap.loginWithMicrosoftAuthentication();
		ds.clickLaunchPortal();
		ds.clickWarehousePortal();
		api.order_create();
		rm.switchToCurrentWindow();
		hp.clickOnLeftnav_Crowleyondock_Btn();
		rm.Frame_PegaGadget0Ifr();
		co.enterBolInput();
		co.clickValueFromBolDropdown();
		co.FirstcaseID_cod();
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();

		// Inbound trailer
		// stage----------------------------------------------------------------
		csf.Overage();
		csf.ship_over();
		csf.return_auth();
		csf.return_loaded();
		csf.return_complete();
		co.codSingleCaseFlow_PodReview_action();
		rm.switchToDefaultContent();
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
		rm.close();
		rm.switchto_newwindow();
		rm.close();
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
		rm.close();
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

	@Test (priority =4)
	public void Overage_exception_2() throws Exception {
		
		Authentication_page ap = new Authentication_page(driver);
		Reuse_methods rm = new Reuse_methods(driver);
		Dev_studio ds = new Dev_studio(driver);
		Home_page hp = new Home_page(driver);
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		api_order_create api = new api_order_create(driver);
		COD_singlecaseflow csf = new COD_singlecaseflow(driver);
		ap.loginWithMicrosoftAuthentication();
		ds.clickLaunchPortal();
		ds.clickWarehousePortal();
		api.order_create();
		rm.switchToCurrentWindow();
		hp.clickOnLeftnav_Crowleyondock_Btn();
		rm.Frame_PegaGadget0Ifr();
		co.enterBolInput();
		co.clickValueFromBolDropdown();
		co.FirstcaseID_cod();
		rm.switchToDefaultContent();
		rm.Frame_PegaGadget1Ifr();

		// Inbound trailer stage----------------------------------------------------------------
		csf.Overage();
		csf.return_overage();
		
		// outbound load stage-----------------------------------------------------------------	
		csf.Outbound_loaded_actions();

		// Outbound released action--------------------------------------------------------------
		csf.outbound_released_action();
		co.codSingleCaseFlow_PodReview_action();
		rm.switchToDefaultContent();
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
		rm.close();
		rm.switchto_newwindow();
		rm.close();
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
		rm.close();
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


