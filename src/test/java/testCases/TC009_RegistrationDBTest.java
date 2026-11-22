package testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import pageObjects.AccountregistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DatabaseUtility;

public class TC009_RegistrationDBTest extends BaseClass {

	@Test(groups = {"LocalDB"})
	
	public void loginTest() {
		
		if ("remote".equalsIgnoreCase(System.getProperty("execution_env"))) {
		    throw new SkipException("Skipping MySQL DB test in remote CI environment.");
		}

		logger.info("*****Starting test ******");
		try {
			HomePage hp = new HomePage(driver);

			hp.clickMyAccount();
			hp.clickRegister();
			logger.info("clicked on my account");

			AccountregistrationPage ar = new AccountregistrationPage(driver);

			logger.info("Providing customer details");
			ar.setFirstName(randomString().toUpperCase());
			ar.setLastName(randomString().toUpperCase());

			// Save email to a variable so we can verify it in MySQL later
			String email = randomString() + "@gmail.com";
			ar.setMail(email);
			ar.setTelephone(randomNumber());

			String password = randomAlphaNumeric();
			ar.setPassword(password);
			ar.setConfirmPassword(password);

			ar.setPrivacyPolicy();
			ar.clickContinue();

			logger.info("validating UI confirmation message");
			String confmsg = ar.getConfirmationMsg();
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
				logger.info("UI Registration successful. Verifying in MySQL database...");

				DatabaseUtility db = new DatabaseUtility(
						p.getProperty("db.url"),
						p.getProperty("db.user"),
						p.getProperty("db.password")
				);

				boolean isPresentInDB = db.isCustomerEmailPresent(email);
				Assert.assertTrue(isPresentInDB, "UI passed, but email was NOT found in MySQL: " + email);
				logger.info("Database verification passed for email: " + email);
			} else {
				logger.error("Test failed.......");
				logger.debug("debug logs....");
				Assert.fail("UI confirmation message did not match.");
			}

		} catch (Exception e) {
			logger.error("Exception occurred: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

		logger.info("*****Finished test ******");
	}
}