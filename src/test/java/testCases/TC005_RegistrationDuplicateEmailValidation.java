package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountregistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC005_RegistrationDuplicateEmailValidation extends BaseClass {
	
	

	@Test(groups={"Regression"})
	public void duplicateEmail() {
		
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
		
		String password= randomAlphaNumeric();
		
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		
		ar.setPrivacyPolicy();
		ar.clickContinue();
		
		logger.info("validating");
		
		String dpmsg=ar.duplicatemsg();
		
		if(dpmsg.equals("Warning: E-Mail Address is already registered!")) {
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
