package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountregistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void loginTest() {
		
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
		ar.setMail( randomString() + "@gmail.com");
		ar.setTelephone(randomNumber());
		
		String password= randomAlphaNumeric();
		
		ar.setPassword(password);
		ar.setConfirmPassword(password);
		
		ar.setPrivacyPolicy();
		ar.clickContinue();
		
		logger.info("validating");
		String confmsg=ar.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed.......");
			logger.debug("debug logs....");
			Assert.assertTrue(false);
		}
		
	}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*****Finished test ******");
}

	
	

}
