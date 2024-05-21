package PomClasses;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractClass {
	
	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait; 
		
	@FindBy(id="booking_engine_cabs")
	private WebElement Cabs;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
		act = new Actions(driver);
		js =(JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,20);
		
	}
	
	public void clickOnCabs() throws InterruptedException 
	{
		Cabs.click();
		
//		Thread.sleep(4000);
//		switchToWindow(1);
//		 if(addrr.size() > 1) {
//		        switchToWindow(1);
//		    } else {
//		        System.out.println("There is only one window open. Cannot switch to the second window.");
//		    }
		
	}
	
}
