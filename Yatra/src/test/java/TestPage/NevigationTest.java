package TestPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PomClasses.AbstractClass;
import PomClasses.CabPage;
import PomClasses.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NevigationTest{
	

	WebDriver driver;
	HomePage homePage;
	CabPage cabPage;
	
//	@BeforeTest
//	public void openBrowser()
//	{
//		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
//		ChromeOptions co = new ChromeOptions();
//		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
//		co.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(co);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		//or
//		//WebDriverManager.chromedriver().setup();
//		//driver = new ChromeDriver();
//	}
	
	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browserName)//is string me testng se value aa rahi hai firefox
	{
		//String browserName=b;
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}
	
	@BeforeClass
	public void CreatePomObject()
	{
		homePage = new HomePage(driver);
		cabPage = new CabPage(driver);
	}
	
	@BeforeMethod
	public void applicaton()
	{
		driver.get("https://www.yatra.com/");
	}
	
	@Test
	public void checkInternational() throws InterruptedException
	{
		homePage.clickOnCabs();
		
		cabPage.sendpickUpLocation();
		
		String actualText = cabPage.getOnTimeText();
		String expectedText = "On Time, Every Time. Book Now.";
		System.out.println(actualText);
//		if(actualText.equalsIgnoreCase(expectedText)) 
//		{
//			System.out.println("pass text is right");
//		}
//		else
//		{
//			System.out.println("fail text is wrong");
//		}
	}
	
//	@Test
//	public void validateCabText()
//	{
//		String actualText = cabPage.getOnTimeText();
//		String expectedText = "On Time, Every Time. Book Now.";
//		if(actualText.equalsIgnoreCase(expectedText)) {
//			System.out.println("pass text is right");
//		}
//		else
//		{
//			System.out.println("fail text is wrong");
//		}
//	}
	
	@Test(enabled=false)
	public void selectinternationl()
	{
		cabPage.selectInternational();
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		homePage = null;
	}
	
	@AfterTest(enabled=false)
	public void afterTest()
	{
		driver.quit();
		System.gc();
	}
}
