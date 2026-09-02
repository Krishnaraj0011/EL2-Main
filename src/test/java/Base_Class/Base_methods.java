package Base_Class;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Test_Utilities.Wait_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Listeners(TestNG_listener.class)

public class Base_methods {

    public static WebDriver driver;
    public Properties p;
    public static ExtentReports ER;
    public static ExtentTest ET;
    public static Wait_Utilities wait;
    
   

    public void Constructor_Baseclass(WebDriver driver)
    {
        this.driver=driver;

        PageFactory.initElements(driver,this);
    }
    

    public static void extentReportSetup() {
    	
	
	   String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
	   
        String path = System.getProperty("user.dir") + "/Reports/TestReport_" + timeStamp + ".html";
        
        ExtentSparkReporter spark = new ExtentSparkReporter(path);

        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("EL2 Automation Report" + timeStamp );
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Krishnaraj Ramesh");   
       
        ER = new ExtentReports();
        ER.attachReporter(spark);
    }

   @BeforeMethod
//   @Parameters({"OS","Browser"})
   
    public void  Launchurl() throws Exception 
    {
        FileInputStream file =new FileInputStream("./src/test/resources/Config.properties");

        p = new Properties();
        p.load(file);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("EL2-url"));
    }
    
    public void Launchurl(String OS , String Browser) throws Exception
    {
    	FileInputStream file =new FileInputStream("./src/test/resources/Config.properties");

        p = new Properties();
        p.load(file);
        
        switch (Browser.toLowerCase())
      {
      case "chrome" : driver=new ChromeDriver(); break;
      case "edge" : driver=new EdgeDriver(); break;
      case "firefox" : driver = new FirefoxDriver(); break;
      default : System.out.println("Invalid browser"); return;
      }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("EL2-url"));
        
    }
    
}