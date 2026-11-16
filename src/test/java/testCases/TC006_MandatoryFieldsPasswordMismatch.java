package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountregistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC006_MandatoryFieldsPasswordMismatch extends BaseClass {
	
	@Test
	public void MandotoryAndMismatch() {
		
		logger.info("*****Starting test ******");
		try{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("clicked on my account");
		
		AccountregistrationPage ar=new AccountregistrationPage(driver);
		
		logger.info("Providing cutomer details");
		ar.setFirstName(randomString().toUpperCase());
		ar.setLastName(randomString().toUpperCase());
		ar.setMail( p.getProperty("email"));
		ar.setTelephone(randomNumber());
		
		//String password= randomAlphaNumeric();
		
		ar.setPassword(p.getProperty("Password"));
		ar.setConfirmPassword(p.getProperty("ConfirmPassword"));
		
		
		//Thread.sleep(3000);
		
		//ar.setPrivacyPolicy();
		ar.clickContinue();
		
		logger.info("validating");
		
		String privacymsg=ar.privacyConfirmation();
		
		if(privacymsg.equals("Warning: You must agree to the Privacy Policy!")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
		String passwordMismatchMsg=ar.passwordMismatch();
		
		if(passwordMismatchMsg.equals("Password confirmation does not match password!")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		
	
	}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*****Finished test ******");
}
		
		
		
		
	
	

}
