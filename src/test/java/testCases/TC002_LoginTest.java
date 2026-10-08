package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
@Test(groups={"Sanity","Master"})
public void loginTest() {
		
		logger.info("*****Starting test ******");
		try{
			
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
			hp.clickLogin();
			logger.info("clicked on my Login");
			
			LoginPage lp=new LoginPage(driver);
			
			
		logger.info("Providing cutomer details");
		lp.setEmail(p.getProperty("email"));
		lp.setPAssword(p.getProperty("password"));
		lp.clcLogin();
		
		//My Account
		
		MyAccountPage myac= new MyAccountPage(driver);
		boolean target= myac.isMyAccountPageExists();
		
		Assert.assertTrue(target); //Assert.assertEquals(target, true,"Login failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished test ******");

}
}
