//package Test_Case;
//
//public class dummy {
//	
//	public void COD_shortage_exception_2 () throws Exception
//	{
//		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 
//		 Authentication_page ap = new Authentication_page(driver);
//	  	 ap.BtnLogin_with_corporate();
//	  	 ap.Btn_verify_identity();
//	  	 Reuse_methods rm = new Reuse_methods(driver); 
//	  	 String OTP =  rm.Scanner();
//	  	 ap.Verify_OTP(OTP);
//	  	 ap.Btn_submit();
//	  	 Dev_studio ds=new Dev_studio(driver);
//	  	 wait.until(ExpectedConditions.visibilityOf(ds.Launchportal));
//	  	 ds.clickLaunchPortal();
//	  	 wait.until(ExpectedConditions.visibilityOf(ds.WareHousePortal));
//	  	 ds.clickWarehousePortal();
//	  	// ET.log(Status.PASS, "Warehouse portal launched successfully");
//	  	 
//	  	 //create order 
//	  	 rm.order_create("\\src\\Files\\OrdersPAR");
//	  	///ET.log(Status.PASS, "Order created successfully");
//	  	 
//	  	 //home page
//	  	 Home_page hp = new Home_page(driver);
//	  	 rm.windowhandles();
//	  	wait.until(ExpectedConditions.visibilityOf(hp.Crowleyondock));
//	  	 hp.leftnav_Crowleyondock();
//	  	 rm.switchtoframe("PegaGadget0Ifr");
//	  	 
//	  	 // Crowley on dock UI
//	  	 Crowley_ondock_UI co = new Crowley_ondock_UI(driver);
//	  	 co.Bolsearch_txt(rm.BOL_String);
//	  	 co.clk_Boldropdown();
//	  	Thread.sleep(2000);
//	  	 wait.until(ExpectedConditions.visibilityOf(co.FirstcaseID_cod));
//	  	 co.FirstcaseID_cod();
//	  	 Thread.sleep(1000);
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame("PegaGadget1Ifr");
//			COD_singlecaseflow csf = new COD_singlecaseflow(driver);
//			
//			//Inbound trailer stage----------------------------------------------------------------
//			String IBstatus = csf.IBworkqueue_status.getText().toString();
//			System.out.println(IBstatus);
////			Assert.assertEquals(IBstatus, "PICKUP SCHEDULED");
////			ET.log(Status.PASS,"Status is in pickup scheduled ");
//			
//			// moving the case to shortage
//			wait.until(ExpectedConditions.visibilityOf(csf.InboundTrailer_statusdrp));
//			rm.selectclass(csf.InboundTrailer_statusdrp, "Shortage" );			
//			wait.until(ExpectedConditions.visibilityOf(csf.Select_drdn_1));
//			rm.selectclass(csf.Select_drdn_1, "2");			
//			wait.until(ExpectedConditions.visibilityOf(csf.Select_drdn_2));
//			rm.selectclass(csf.Select_drdn_2, "3");
//			wait.until(ExpectedConditions.visibilityOf(csf.IBworkqueue_date));
//			csf.IBworkqueue_dateinput("3/18/2026 9:25 AM");
//			csf.IBworkqueue_submit_clk();
//			//Thread.sleep(1000);
//			
//			//OSND stage--------------------------------------------------------------------------------------------------------
//			//wait.until(ExpectedConditions.visibilityOf(csf.status_text_osnd_stage));
//			
//			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(csf.status_text_osnd_stage)));
//			String Exception = csf.status_text_osnd_stage.getText().toString();
//			System.out.println(Exception);		
//			wait.until(ExpectedConditions.visibilityOf(csf.Osnd_Go));
//			csf.Osnd_GO_clk();
//			Thread.sleep(2000);
//			
//			//moving the case to short resolved 
//			driver.switchTo().defaultContent();	
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget1Ifr"));
//			wait.until(ExpectedConditions.visibilityOf(csf.Osnd_Select_drdn));
//			rm.selectclass(csf.Osnd_Select_drdn , "Short Resolved");
//			csf.Osnd_submit_btn_clk();	
////			Thread.sleep(1000);
////			wait.until(ExpectedConditions.visibilityOf(csf.status_text_osnd_stage));
//			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(csf.status_text_osnd_stage)));
//			String Exception2  = csf.status_text_osnd_stage.getText().toString();
//			System.out.println(Exception2);		
//			wait.until(ExpectedConditions.visibilityOf(csf.Osnd_Go));
//			csf.Osnd_GO_clk();
//			Thread.sleep(2000);
//			
//			// moving the case to Return auth
//			driver.switchTo().defaultContent();	
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget1Ifr"));
//			wait.until(ExpectedConditions.visibilityOf(csf.Outboundload_Select_drdn));
//			rm.selectclass(csf.Outboundload_Select_drdn , "Return Auth");
//			wait.until(ExpectedConditions.visibilityOf(csf.ReturnID_input));
//			csf.Return_Id();
//			csf.Outboundload_submit_btn_clk();
////			Thread.sleep(1000);
////			wait.until(ExpectedConditions.visibilityOf(csf.status_text_osnd_stage));
//			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(csf.status_text_osnd_stage)));
//			String Exception3  = csf.status_text_osnd_stage.getText().toString();
//			System.out.println(Exception2);		
//			wait.until(ExpectedConditions.visibilityOf(csf.Osnd_Go));
//			csf.Osnd_GO_clk();
//			Thread.sleep(2000);
//			
//			// moving the case to Return Loaded
//			driver.switchTo().defaultContent();	
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget1Ifr"));
//			wait.until(ExpectedConditions.visibilityOf(csf.Outboundload_Select_drdn));
//			rm.selectclass(csf.Outboundload_Select_drdn , "Return Loaded");
//			csf.Outboundload_submit_btn_clk();
////			Thread.sleep(1000);
////			wait.until(ExpectedConditions.visibilityOf(csf.status_text_osnd_stage));
//			
//			wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(csf.status_text_osnd_stage)));
//				
//			String Exception4  = csf.status_text_osnd_stage.getText().toString();
//			System.out.println(Exception2);		
//			wait.until(ExpectedConditions.visibilityOf(csf.Osnd_Go));
//			csf.Osnd_GO_clk();
//			Thread.sleep(2000);
//			
//			// moving the case to Return complete
//			driver.switchTo().defaultContent();	
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget1Ifr"));
//			wait.until(ExpectedConditions.visibilityOf(csf.Outboundload_Select_drdn));
//			rm.selectclass(csf.Outboundload_Select_drdn , "Return Complete");
//			csf.Outboundload_submit_btn_clk();
//			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(csf.status_text_osnd_stage)));
//			String Exception5  = csf.status_text_osnd_stage.getText().toString();
//			System.out.println(Exception2);		
//			wait.until(ExpectedConditions.visibilityOf(csf.Osnd_Go));
//			csf.Osnd_GO_clk();
//			Thread.sleep(2000);
//			
//			driver.switchTo().defaultContent();	
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget1Ifr"));
//			wait.until(ExpectedConditions.visibilityOf(co.ArrivedatPickupDate));
//			co.ArrivedatPickupDate("3/14/26 6:14 AM");
//			wait.until(ExpectedConditions.visibilityOf(co.DepartAtPickup));
//			co.DepartAtPickup("3/15/26 6:14 AM");
//			Thread.sleep(1500);
//			wait.until(ExpectedConditions.visibilityOf(co.LineHaulArriveatTerminal));
//			co.LineHaulArriveatTerminal("3/16/26 6:14 AM");
//			wait.until(ExpectedConditions.visibilityOf(co.LinehaulComplete));
//			co.LinehaulComplete("3/17/26 6:14 AM");
//			wait.until(ExpectedConditions.elementToBeClickable(co.Submitbtn));
//			co.Submitbtn();
//			driver.switchTo().defaultContent();
//			
//			//Crowley TL attachment 
//			hp.CrowleyTL_leftNav();
//			driver.switchTo().frame("PegaGadget2Ifr");
//			CrowleyTL ct= new CrowleyTL(driver);
//			ct.refresh();
//			Thread.sleep(3000);
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame("PegaGadget2Ifr");
//			wait.until(ExpectedConditions.visibilityOf(ct.AttachPODbtn));
//			ct.AttachPOD_btn();
//			ct.EnterIB_loadID_input(rm.Invoicenum);
//			ct.Search_btn();
//			wait.until(ExpectedConditions.visibilityOf(ct.SubmitBtn));
//			ct.Submit_btn();
//			Thread.sleep(1500);
//			ct.selectfile();
//			Thread.sleep(2000);
//			ct.crowleyTL_submitbtn();
//			driver.switchTo().defaultContent();
//			//ET.log(Status.PASS, "Attachment added to the case through crowleyTL as expected ");
//			
//			//POD accepted or POD confirm number
//			rm.switchtopreviouswwindow(0);
//			ds.Favorites();
//			wait.until(ExpectedConditions.visibilityOf(ds.ConfirmPOD));
//			ds.ConfirmPOD();
//			driver.switchTo().frame("PegaGadget0Ifr");
//			ds.Actiondropdown();
//			Thread.sleep(1000);
//			ds.runoption();
//			rm.switchto_newwindow();
//			Thread.sleep(1000);
//			ds.PyIDtextfield_input(rm.Order1);
//			ds.PODConfirmNumber_input();
//			Thread.sleep(1000);
//			ds.runbtn();
//			Thread.sleep(5000);
//			rm.switchto_newwindow();
//			driver.close();
//			rm.switchto_newwindow();
//			driver.close();
//			rm.switchto_newwindow(); 
//			//ET.log(Status.PASS, "Added confirm number to case as expected");
//			
//			//Approve POD
//			co.Crowleyondock_UI_header();
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame("PegaGadget0Ifr");
//			Thread.sleep(3000);
//			co.POD_review_Header();
//			Thread.sleep(1000);
//			co.PODReview_Bolsearch_txt(rm.BOL_String);
//			Thread.sleep(2000);
//			co.clk_Boldropdown();
//			Thread.sleep(1000);
//			co.POD_review_overallcheckbox();
//			co.ApprovePODbutton();
//			Thread.sleep(1000);
//		    co.AprovePOD_sbt_btn();
//		   // ET.log(Status.PASS, "Approve POD button is working as expected");
//		    driver.switchTo().defaultContent();
//			co.Case_id_header_clk();
//			driver.switchTo().frame("PegaGadget1Ifr");
//			co.CaseID_action_drdn_clk();
//			Thread.sleep(2000);
//			co.Caselvl_refresh();
//			//co.Case_status_text();
//		
//			driver.switchTo().defaultContent();
//			
//			Clipboard clp = new Clipboard(driver);
//			clp.Case_lvl_settings_icon();
//			clp.Clipboard_icon_clk();
//			rm.switchto_newwindow();
//			clp.plus_pyworkpage();
//			clp.clipboard_order_pg_clk();
//	}
//
//}
