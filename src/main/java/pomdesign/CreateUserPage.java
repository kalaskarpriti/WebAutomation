package pomdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateUserPage {

	public WebDriver driver;

	public CreateUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-left']/li[1]")
	private WebElement selectAccount;

	@FindBy(xpath = "//a[normalize-space()='Users']")
	private WebElement selectUsers;

	@FindBy(xpath = "//a[normalize-space()='Create New']")
	private WebElement selectCreateUser;

	@FindBy(xpath = "//select[@id='HospitalID']")
	private WebElement selectNursingHome;

	@FindBy(id = "FirstName")
	private WebElement enterFirstname;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement enterLastname;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement enterEmail;

	@FindBy(xpath = "//input[@id='ConfirmEmail']")
	private WebElement enterConfirmEmail;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement enterPassword;

	@FindBy(id = "ConfirmPassword")
	private WebElement enterconfirmPassword;

	@FindBy(id = "PhoneNumber")
	private WebElement enterPhoneNumber;

	@FindBy(xpath = "//select[@id='Gender']")
	private WebElement selectGender;

	@FindBy(xpath = "//select[@id='Type']")
	private WebElement selectPosition;

	@FindBy(xpath = "//input[@value='Create']")
	private WebElement createUser;

	@FindBy(xpath = "//span[normalize-space()='The First Name field is required.']")
	private WebElement ErrormsgFirsname;

	@FindBy(xpath = "//span[normalize-space()='The Email Address field is required.']")
	private WebElement ErrormsginvalidEmail;

	@FindBy(xpath = "//span[normalize-space()='The Confirmed Email Address field is required.']")
	private WebElement ErrormsginvalidConfirmEmail;

	@FindBy(xpath = "//li[normalize-space()='Email ID already exist.']")
	private WebElement ErrormsgMailAlreadyexists;

	@FindBy(xpath = "//span[normalize-space()='The Password field is required.']")
	private WebElement Emptypassword;

	@FindBy(xpath = "//a[normalize-space()='Back to List']")
	private WebElement backClick;

	public WebElement selectAccount() {
		return selectAccount;
	}

	public void selectUsers() {
		selectUsers.click();
	}

	public void selectCreateUsers() {
		selectCreateUser.click();
	}

	public Select selectNursingHome() {

		Select selNursingHM = new Select(selectNursingHome);
		return selNursingHM;
	}

	public WebElement enterFirstname() {
		return enterFirstname;
	}

	public String ErrormsgFirstNM() {
		String FirstnameErrMsg = ErrormsgFirsname.getText();
		return FirstnameErrMsg;
	}

	public WebElement enterLastname() {
		return enterLastname;
	}

	public WebElement enterEmail() {
		return enterEmail;
	}

	public String ErrormsgInvEmail() {
		String InvalidEmailErrMsg = ErrormsginvalidEmail.getText();
		return InvalidEmailErrMsg;
	}

	public WebElement enterConfirmEmail() {
		return enterConfirmEmail;
	}

	public String ErrormsgConfirmEmail() {
		String confirmemailErrMsg = ErrormsginvalidConfirmEmail.getText();
		return confirmemailErrMsg;
	}

	public String ErrormsgAlreadyExists() {
		String AlreadyExistsEmailErrMsg = ErrormsgMailAlreadyexists.getText();
		return AlreadyExistsEmailErrMsg;
	}

	public WebElement enterPassword() {
		return enterPassword;
	}

	public String emptyPassword() {
		String emptyPassword = Emptypassword.getText();
		return emptyPassword;
	}

	public WebElement enterconfirmPassword() {
		return enterconfirmPassword;
	}

	public WebElement enterPhoneNumber() {

		return enterPhoneNumber;
	}

	public Select selectGender() {

		Select selgender = new Select(selectGender);
		return selgender;
	}

	public Select selectPosition() {

		Select selPosition = new Select(selectPosition);
		return selPosition;
	}

	public WebElement createUser() {
		return createUser;
	}

	public void backClick() {
		backClick.click();
	}

}
