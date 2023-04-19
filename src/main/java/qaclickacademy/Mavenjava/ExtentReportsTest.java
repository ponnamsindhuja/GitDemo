package qaclickacademy.Mavenjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportsTest {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		//Extent Reports, Extent Spark Reporter classes
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Chaithanya_Automation_Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Chaithanya");
		extent.setSystemInfo("time", "7AM");
		
	}

	
	@Test
	public void initialDemo() {
		
        ExtentTest test   = extent.createTest("InitialDemo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ponna\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
		
	}

}
