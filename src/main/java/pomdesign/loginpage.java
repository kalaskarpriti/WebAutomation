package pomdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;

	public loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement Email;

	@FindBy(id = "Password")
	private WebElement Password;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement Loginbutton;

	@FindBy(xpath = "//span[@id='userNameLabel']")
	private WebElement logout;

	@FindBy(xpath = "//a[normalize-space()='Log off']")
	private WebElement logoutbutton;

	public WebElement enterEmail() {
		return Email;
	}

	public WebElement enterPassword() {
		return Password;
	}

	public WebElement clickLogin() {
		return Loginbutton;
	}

	public WebElement logOut() {
		return logout;
	}

	public WebElement logoutButton() {
		return logoutbutton;
	}

}
