package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

@FindBy(xpath="//input[@id='input-email']") WebElement MailAddress;
@FindBy(xpath="//input[@id='input-password']") WebElement lpassword;

@FindBy(xpath="//input[@value='Login']") WebElement login;

public void setEmail(String em) {
	MailAddress.sendKeys(em);
}


public void setPAssword(String lgn) {
	lpassword.sendKeys(lgn);
}

public void clcLogin() {
	login.click();
	
}
	
	

}
