package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")  //getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {
		
		logger.info("*****Starting test case*******");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPAssword(pwd);
		lp.clcLogin();
			
			//My Account
			
		MyAccountPage myac= new MyAccountPage(driver);
		boolean targetPage= myac.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			
			if(targetPage==true) {
				
				myac.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetPage==true) {
				
				myac.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
	
		logger.info("*****finished test case*******");
	}
}
