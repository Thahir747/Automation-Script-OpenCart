package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC008_InvalidSearchTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_invalid_product_search() {
        logger.info("**** Starting TC008_InvalidSearchTest ****");

        try {
            HomePage hp = new HomePage(driver);

            logger.info("Searching for non-existent product: FitBitXYZ123");
            hp.searchText("FitBitXYZ123");
            hp.searchI();

            SearchPage sp = new SearchPage(driver);

            logger.info("Validating 'no product found' message is displayed");
            boolean isMessageDisplayed = sp.isNoProductMessageDisplayed();

            Assert.assertTrue(isMessageDisplayed, "Expected 'no product' message was not displayed.");

        } catch (Exception e) {
            logger.error("Test Failed: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("**** Finished TC008_InvalidSearchTest ****");
    }
}