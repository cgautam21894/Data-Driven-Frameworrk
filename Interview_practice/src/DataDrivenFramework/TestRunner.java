package DataDrivenFramework;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {
	
	public static void main()
	{
		TestNG tng = new TestNG();
		List<String> list = new ArrayList<String>();
		list.add("C:\\Users\\A638108\\Desktop\\Selenium\\Workspace\\Interview_practice\\test-output\\Failed suite [SmokeTestSuites]\\testng-failed.xml");
		tng.setTestSuites(list);
		tng.run();
	}

}
