package Test_Case;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base_Class.Base_methods;
import Page_Object.Authentication_page;
import Page_Object.Clipboard;
import Page_Object.Crowley_ondock_UI;
import Page_Object.Dev_studio;
import Page_Object.Home_page;
import Page_Object.Order_create_PaccarOnDock;
import Page_Object.Paccor_on_dock_UI;
import Test_Utilities.Reuse_methods;
import Test_Utilities.api_order_create;
import Base_Class.TestNG_listener;

@Listeners(TestNG_listener.class)

public class Paccar_on_Dock extends Base_methods {

	@Test
	public void Create_order_without_template() throws Exception {

		Authentication_page ap = new Authentication_page(driver);
		Reuse_methods rm = new Reuse_methods(driver);
		Dev_studio ds = new Dev_studio(driver);
		Home_page hp = new Home_page(driver);
		Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
		api_order_create api = new api_order_create(driver);
		ap.loginWithMicrosoftAuthentication();
		ds.clickLaunchPortal();
		ds.clickWarehousePortal();
		rm.switchToCurrentWindow();
		hp.Order_create_click();
		rm.Frame_PegaGadget0Ifr();
		Order_create_PaccarOnDock pod = new Order_create_PaccarOnDock(driver);
		pod.Create_new_order_click();
		Order_create_PaccarOnDock op = new Order_create_PaccarOnDock(driver);
		op.select_Trading_partner_combination();
		op.select_PAR_combination();
		op.Order_details();
		op.order_origin_details();
		op.order_destination_details();
		op.Handlingunit_details();
		op.Bill_to_details();
		op.Preview_confirm_order();
		Paccor_on_dock_UI PODUI = new Paccor_on_dock_UI(driver);
		PODUI.paccar_on_dock_leftnav_clk();
		rm.Frame_PegaGadget1Ifr();
		PODUI.POD_receive_order_bulkAction();
		PODUI.POD_Assign_carrierbulkAction();
		PODUI.POD_Assign_Load_ID();
		PODUI.POD_Assign_Ob_trailer_bulkAction();
		PODUI.POD_Released_bulk_action();
		PODUI.CaseID_header_clk();
		rm.Frame_PegaGadget2Ifr();
		//PODUI.CaseID_gettext();
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
		rm.Frame_PegaGadget0Ifr();
		ds.Ordertable_searchfield_clk();
		ds.Ordertable_searchicon_clk();
		ds.orderTableValidationforCrowleyOndock();
		driver.manage().deleteAllCookies();
		driver.quit();

	}

}
