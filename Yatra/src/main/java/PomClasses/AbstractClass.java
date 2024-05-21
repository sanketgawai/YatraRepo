package PomClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractClass {

	WebDriver driver;
	ArrayList<String> addrr;
	
	public AbstractClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		addrr = new ArrayList<String>(driver.getWindowHandles());
	}
	
	public void switchToWindow(Integer winodowNo)
	{
		driver.switchTo().window(addrr.get(winodowNo));
	}
	
//	public void switchToChildWindow()
//	{
//		driver.switchTo().window(addr.get(1));
//	}
//	
//	public void switchToSecondChildWindow()
//	{
//		
//		driver.switchTo().window(addr.get(2));
//	}
//	public void switchToParentWindow()
//	{
//		driver.switchTo().window(addr.get(0));
//	}
	
	public void waitForElementToVisiable(WebElement el)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	public void selectByVisibleText(WebElement ele,String text)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void switchToFrame(WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
}
