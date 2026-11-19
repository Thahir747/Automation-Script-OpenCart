package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	//@FindBy(xpath="//a[normalize-space()='iPhone']") WebElement iPhone;
	
	
	//@FindBy(xpath = "//div[contains(@class, 'product-layout')]//h4/a")
	@FindBy(xpath = "//h4/a")
	
	
	
    List<WebElement> searchProducts;

    // Iterate through the results to see if the target product exists
    public boolean isProductExist(String productName) {
        boolean flag = false;
        for (WebElement product : searchProducts) {
            if (product.getText().equalsIgnoreCase(productName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
	
	

}
