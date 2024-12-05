package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(id="input-username")
	private WebElement userNameTB;
	
	@FindBy(id="input-password")
	private WebElement passwordTB;
	
	@FindBy(name="login-button")
	private WebElement goButton;
	
	@FindBy(xpath = "//div[@class='error']")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUserName(String un)
	{
		userNameTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		passwordTB.sendKeys(pw);
	}
	
	public void clickGoButton()
	{
		goButton.click();
	}
	
	public boolean verifyErrMsgIsDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			String msg=errMsg.getText();
			Reporter.log("Error Message is Displayed:"+msg,true);
			return true;
		}
		catch (Exception e)
		{
			Reporter.log("Error Message is Not Displayed",true);
			e.printStackTrace();
			return false;
		}
	}
	
}
