package pomdesign;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditSensorPage {

	WebDriver driver;

	public EditSensorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-left']/li[2]")
	private WebElement ManageSensorMenu;

	@FindBy(xpath = "//ul[@class=\"nav navbar-nav navbar-left\"]/li[2]/ul/li[3]")
	private WebElement SensorsinDropdown;

	@FindBy(xpath = "(//a[@class='chosen-single'])[1]")
	private WebElement Opendropdown;

	@FindBy(xpath = "(//a[@class='chosen-single'])[1]")
	private WebElement clickNursingHome;

	@FindBy(xpath = "(//input[@class='chosen-search-input'])[1]")
	private WebElement enterNursingHome;

	// @FindBy(xpath="(//a[@title='Edit'])[1]")
	@FindBy(xpath = "//tbody/tr[2]/td[12]/a[1]")
	private WebElement selectEdit;

	@FindBy(xpath = "(//input[@type='text'])[16]")
	private WebElement editMAxMove;

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement SaveChanges;

	public WebElement sensorDropdownMenu() {

		return ManageSensorMenu;
	}

	public WebElement selectsensors() {
		return SensorsinDropdown;
	}

	public WebElement selectHospitaldropdown() {
		return Opendropdown;
	}

	public void selectHospital() {
		String keys = Keys.chord("Columbia Asia Hospital", Keys.ENTER);
		clickNursingHome.click();
		enterNursingHome.sendKeys(keys);
	}

	public void selecteditoption() {
		selectEdit.click();
	}

	public void editMAxMove() {
		editMAxMove.clear();
		editMAxMove.sendKeys("60");
	}

	public void saveChanges() {
		SaveChanges.click();
	}

}
