package Base_Class;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestNG_listener extends Base_methods implements ITestListener  {
	 
	
	@Override
	public void onStart(ITestContext context)
	{
		 System.out.println("Listener onStart");
		    extentReportSetup();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		ET = ER.createTest(methodName);
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		 System.out.println("onTestSuccess: " + result.getMethod().getMethodName());
		ET.pass("Test Pass");
		 System.out.println("ET = " + ET);
	}
 
	@Override
	public void onTestFailure(ITestResult result) {
		ET.fail(result.getThrowable().toString());	
	}
 
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
	}
 
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}
 
	
 
	@Override
	public void onFinish(ITestContext context)
	{	
		 System.out.println("Listener onFinish");
		    ER.flush();
	}
}