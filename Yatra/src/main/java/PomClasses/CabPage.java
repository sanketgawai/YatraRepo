package PomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CabPage extends AbstractClass {

	WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait; 
	
	@FindBy(xpath="//select[@id='travelTypeSelect']")
	private WebElement transferdd;

	@FindBy(xpath="//section[@class='topsection']/child::h2")
	private WebElement cabText;
	
	@FindBy(xpath="//input[@id='pac-input']")
	private WebElement pickUpLocation;
	
	@FindBy(xpath="//iframe[@id='ifd']")
	private WebElement changeFrame;
	
	public CabPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
		act = new Actions(driver);
		js =(JavascriptExecutor)driver;
		wait = new WebDriverWait(driver,20);
	}
	
	public void selectInternational()
	{
		waitForElementToVisiable(transferdd);
		selectByVisibleText(transferdd,"International Transfers");
	}
	
	public String getOnTimeText()
	{
		waitForElementToVisiable(cabText);
		String cabtx =cabText.getText();
		return cabtx;
	}

	public void sendpickUpLocation()
	{
		switchToFrame(changeFrame);
		waitForElementToVisiable(pickUpLocation);
		act.moveToElement(pickUpLocation).click().sendKeys("kaido").build().perform();
	}
}
