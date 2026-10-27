package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement mssgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout; // added in step 6
	@FindBy(xpath="//ul[@class='breadcrumb']//li[1]/a") WebElement account;
	
	public boolean isMyAccountPageExists() {
		
		try {
			
		return (mssgHeading.isDisplayed());
		
		}catch(Exception e) {
			
			return false;
		}
	}
	
	public void homeClick() {
		account.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	
}
