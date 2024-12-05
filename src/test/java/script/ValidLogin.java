package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.HomePage;
import page.LoginPage;

public class ValidLogin extends BaseTest
{

	@Test(priority = 1,groups= {"login"})
	public void testValidLogin()
	{
		String un=Utility.getExcelData(xlpath, "ValidLogin",1,0);
		String pw=Utility.getExcelData(xlpath, "ValidLogin",1,1);
//		1. enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
//		2. enter valid pw
		loginPage.setPassword(pw);
//		3. click on login
		loginPage.clickGoButton();
//		4. home page should be displayed
		HomePage homePage=new HomePage(driver);
		boolean result = homePage.verifyHomePageIsDisplayed(wait);
		Assert.assertTrue(result);
	}
	
}
