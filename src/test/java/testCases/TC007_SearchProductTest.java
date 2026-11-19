package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC007_SearchProductTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void verify_product_search() {
        logger.info("**** Starting TC007_SearchProductTest ****");

        try {
            HomePage hp = new HomePage(driver);
            
            logger.info("Searching for product: MacBook");
            hp.searchText(p.getProperty("ProductName"));
            hp.searchI();

            SearchPage sp = new SearchPage(driver);
            
            logger.info("Validating product exists in search results");
            boolean targetPage = sp.isProductExist(p.getProperty("ProductName"));
            
            Assert.assertTrue(targetPage, "Expected product was not found in the search results.");

        } catch (Exception e) {
            logger.error("Test Failed: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("**** Finished TC007_SearchProductTest ****");
    }
}