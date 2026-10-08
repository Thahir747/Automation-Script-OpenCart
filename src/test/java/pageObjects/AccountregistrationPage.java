package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountregistrationPage extends BasePage {
	
	public AccountregistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement Mail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement cnfpassword;
	@FindBy(xpath="//input[@name='agree']") WebElement agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	
	public void setMail(String mail) {
		Mail.sendKeys(mail);
	}
	
	
	public void setTelephone(String tel) {
		telephone.sendKeys(tel);
	}
	
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	
	public void setConfirmPassword(String pwd) {
		cnfpassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		agree.click();
	}
	
	public void clickContinue() {
		btn_continue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}



}
