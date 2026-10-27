package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_E2E extends BaseClass {
	
	@Test
	public void login() throws InterruptedException {
		
		
		// HomePage
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		// Login page
		LoginPage lp=new LoginPage (driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPAssword(p.getProperty("password"));
		lp.clcLogin();
		
		// my account
		MyAccountPage ap =new MyAccountPage(driver);
		ap.homeClick();
		
		Thread.sleep(5000);
		
		//Homepage
		hp.searchText(p.getProperty("searchProductName"));
		hp.searchI();
		
		SearchPage sp= new SearchPage(driver);
		
		sp.iphoneS();
		
		
		
		
		
		
		
	}

}
