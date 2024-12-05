package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;

public class InvalidLogin extends BaseTest
{

	@Test(priority =2,groups={"login"})
	public void testInvalidLogin()
	{
		String un=Utility.getExcelData(xlpath, "InvalidLogin",1,0);
		String pw=Utility.getExcelData(xlpath, "InvalidLogin",1,1);
//		1. enter invalid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
//		2. enter invalid pw
		loginPage.setPassword(pw);
//		3. click on go button
		loginPage.clickGoButton();
//		4. should display error msg
		boolean result = loginPage.verifyErrMsgIsDisplayed(wait);
		Assert.assertTrue(result);
	}
}
