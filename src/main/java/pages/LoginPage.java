package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage 
{
	AndroidDriver driver;
	
    public LoginPage(AndroidDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    //------------------   Elements --------------------------------
    
    @FindBy(id = "name")
    private WebElement userName;
    
    @FindBy(id = "password")
    private WebElement password;
    
    @FindBy(id = "login")
    private WebElement login;
    
    @FindBy(id = "country")
    private WebElement country;
    
    @FindBy(id = "address")
    private WebElement address;
    
    @FindBy(id = "email")
    private WebElement email;
    
    @FindBy(id = "phone")
    private WebElement phoneNo;
    
    @FindBy(id = "save")
    private WebElement save;
    
    @FindBy(id = "saved")
    private WebElement profileSaved;
    
    //---------------------- Methods ----------------------------
    
    public void enterName(String name) 
    {
    	userName.sendKeys(name);
    }
    
    public void enterPassword(String pwd) 
    {
    	password.sendKeys(pwd);
    }
    
    public void clickLogin() 
    {
    	login.click();
    }
    
    public void enterCountry(String con) 
    {
    	country.sendKeys(con);
    }
    
    public void enterAddress(String addr) 
    {
    	address.sendKeys(addr);
    }
    
    public void enterEmail(String mail) 
    {
    	email.sendKeys(mail);
    }
    
    public void enterPhoneNo(String mobile) 
    {
    	phoneNo.sendKeys(mobile);
    }
    
    public void clickSave() 
    {
    	save.click();
    	
    }
    
    public void waitForElement(WebElement element, int seconds) 
    {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
    
    public void login(String name, String password) 
    {
        //hideKeyboardIfVisible();
        enterName(name);
        enterPassword(password);
        clickLogin();
    }
    
    public void enterDetails(String con, String addr, String mail, String mobile)
    {
    	enterCountry(con);
    	enterAddress(addr);
    	enterEmail(mail);
    	enterPhoneNo(mobile);
    	clickSave();
    }
    
    public boolean profileSaved_Check() 
    {
    	if (profileSaved.isDisplayed()) 
    	{
			return true;
		}
		return false;
	}
}
