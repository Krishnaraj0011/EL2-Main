package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Constructor_Baseclass {

	WebDriver driver;

    public Constructor_Baseclass(WebDriver driver)
    {
        this.driver=driver;

        PageFactory.initElements(driver,this);
    }

}