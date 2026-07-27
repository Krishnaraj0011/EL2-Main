package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Create_crowley_UI extends Constructor_Baseclass {

	public Create_crowley_UI(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//select[@id='9154bf22']")
	public static WebElement Assigntradingpartner_drdn;
	
	@FindBy(xpath="//select[@id='23bfe5c4']")
	public static WebElement Casetype_drdn;
	
	@FindBy(xpath="//select[@id='c8c195d3']")
	public static WebElement Equipment_drdn;
	
	@FindBy(xpath="//select[@id='4f74c8fe']")
	public static WebElement CrowleyMode_drdn;
	
	@FindBy(xpath="//select[@id='b3529740']")
	public static WebElement PaymentTerm_drdn;
	
	@FindBy(xpath="//select[@id='90e90cf6']")
	public static WebElement Servicelevel_drdn;
	
	@FindBy(xpath="//input[@id='611864c8']")
	public static WebElement Pro_number;
	
	@FindBy(xpath="//input[@id='407cfb60']")
	public static WebElement Tracking_number;
	
	@FindBy(xpath="//input[@id='d252b731']")
	public static WebElement Invoice_number;
	
	@FindBy(xpath="//input[@id='e0629024']")
	public static WebElement Pickupnumber;
	
	@FindBy(xpath="//input[@id='a32adbfd']")
	public static WebElement Ponumber;
	
	@FindBy(xpath="//select[@id='e212b21d']")
	public static WebElement Origincompany;
	
	@FindBy(xpath="//select[@id='9ca68f0d']")
	public static WebElement Origin_address1;
	
	@FindBy(xpath="//select[@id='289013ad']")
	public static WebElement Origin_city;
	
	@FindBy(xpath="//select[@id='2a45320a']")
	public static WebElement Origin_state;
	
	@FindBy(xpath="//select[@id='0586958c']")
	public static WebElement Origin_postalcode;
	
	@FindBy(xpath="//input[@id='882963c1']")
	public static WebElement Destination_company;
	
	@FindBy(xpath="//input[@id='fa6c46fe']")
	public static WebElement Destination_address1;
	
	@FindBy(xpath="//input[@id='3458ddbe']")
	public static WebElement Destination_city;
	
	@FindBy(xpath="//input[@id='b10f2586']")
	public static WebElement Destination_state;
	
	@FindBy(xpath="//input[@id='7124e176']")
	public static WebElement Destination_Postalcode;
	
	@FindBy(xpath="//button[@title=\"Click to add Order Items\"]")
	public static WebElement Add_item;
	
	@FindBy(xpath="//a[normalize-space()='Add Items']")
	public static WebElement Popup_additem;
	
	@FindBy(xpath="//input[@id='a821a0e6']")
	public static WebElement Item_name;
	
	@FindBy(xpath="//input[@id='99c174af']")
	public static WebElement Item_quantity;
	
	@FindBy(xpath="//input[@id='7d8b074c']")
	public static WebElement Total_weight;
	
	@FindBy(xpath="//input[@id='3acb9ef']")
	public static WebElement Onhandling_unit;
	
	@FindBy(xpath="//button[@id=\"ModalButtonSubmit\"]")
	public static WebElement Popup_Submitbtn;

	@FindBy(xpath="//button[@title='Click to add Handling Units']")
	public static WebElement Add_handlingunits_btn;
	
	@FindBy(xpath="//a[normalize-space()='Add Handling Units']")
	public static WebElement Popup_Add_handlingunits_btn;
	
	@FindBy(xpath="//input[@id='7f046d8d']")
	public static WebElement Client_id;
	
	@FindBy(xpath="//input[@id='3185b2cd']")
	public static WebElement HandlingUnit_quantity;
	
	@FindBy(xpath="//input[@id='1f332993']")
	public static WebElement HandlingUnit_type;
	
	@FindBy(xpath="//input[@id='a73555d4']")
	public static WebElement Length;
	
	@FindBy(xpath="//input[@id='7886448a']")
	public static WebElement Width;
	
	@FindBy(xpath="//input[@id='53052e69']")
	public static WebElement Height;
	
	@FindBy(xpath="//button[@title=\"Submit\"]")
	public static WebElement submit_btn;
	
	@FindBy(xpath="//button[@title=\"Click to add Accessorials\"]")
	public static WebElement Add_Accessorial;
	
	@FindBy(xpath="//a[normalize-space()='Add Accessorial']")
	public static WebElement Popup_add_accessorial;
	
	@FindBy(xpath="//input[@id='84ed1361']")
	public static WebElement Accessorial_code;
	
	@FindBy(xpath="//input[@id='672ae04c']")
	public static WebElement Accessorial_location;
	
	@FindBy(xpath="//input[@id='a6477fb1']")
	public static WebElement Accessorial_Quantity;
	
	@FindBy(xpath="//button[@id='ModalButtonSubmit']")
	public static WebElement Submit_btn;
	
	@FindBy(xpath="//input[@id='8d4b258d']")
	public static WebElement PickupRequestTWStart;
	
	@FindBy(xpath="//input[@id='b4352c6a']")
	public static WebElement DeliverByTWStart;
	
	@FindBy(xpath="//button[@title='Click to Confirm with Preview Order']")
	public static WebElement Confirm_order_btn;
	
	@FindBy(xpath="//button[@title=\"Click to Create Order\"]")
	public static WebElement Popup_confirm_order;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	public static WebElement Submitbtn;
	
}
