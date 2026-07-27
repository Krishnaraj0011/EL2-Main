package EL2_Test_Runner;

import org.testng.annotations.Test;

import Test_Case.COD_UI_ordercreate;
import Test_Case.Crowley_on_dock_test;

public class Runner_class {
	
	@Test
	public void crowley_test1() throws Exception
	{
		Crowley_on_dock_test test1 = new Crowley_on_dock_test();
		test1.COD_bulk_action(); 
	}
	
	@Test
	public void crowley_test2() throws Exception
	{
		COD_UI_ordercreate test2 =new COD_UI_ordercreate();
		test2.COD_UI_order();
	}

}
