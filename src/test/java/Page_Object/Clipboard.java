package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Clipboard extends Constructor_Baseclass {

	public Clipboard(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button/i[@class='pz-pi pi-gear']")
	public static WebElement Case_lvl_settings;
	
	public void Case_lvl_settings_icon() {
		Case_lvl_settings.click();
	}

	@FindBy(xpath="//i[@class='pz-pi pi-clipboard']")
	public static WebElement Clipboard_icon;
	
	public void Clipboard_icon_clk() {
		Clipboard_icon.click();
	}
	
	@FindBy(xpath="(//span[contains(text(), 'pyWorkPage')])[1]/ancestor::li[2]/ul/li/div/div[1]")
	public static WebElement plus_pyworkpage;
	
	public void plus_pyworkpage() {
		plus_pyworkpage.click();
	}
	
	@FindBy(xpath="//span[@title=\"OrderPage (ESTES-Data-Order)\"]")
	public static WebElement clipboard_order_pg;
	
	public void clipboard_order_pg_clk() {
		clipboard_order_pg.click();
	}
	
	@FindBy(xpath="(//span[@title=\"OrderPage (ESTES-Data-Order)\"])[1]//ancestor::li[2]/ul/li/div/div/a")
	public static WebElement Plus_orderpage;
	
	public void Plus_orderpage() {
		Plus_orderpage.click();
	}
	
	@FindBy(xpath="//span[@title=\"OrderRefs (ESTES-Data-Order)\"]")
	public static WebElement Order_refs;
	
	public void Order_ref() {
		Order_refs.click();
	}

	@FindBy(xpath="//span[@title='OrderOrigin (ESTES-Data-Order)']")
	public static WebElement Order_origin;
	
	public void Order_origin_clk() {
		Order_origin.click();
	}
	
	@FindBy(xpath="//span[@title='OrderDestination (ESTES-Data-Order)']")
	public static WebElement Order_destination;
	
	public void Order_destination_clk() {
		Order_destination.click();
	}
}
