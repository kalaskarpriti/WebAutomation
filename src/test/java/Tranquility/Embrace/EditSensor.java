package Tranquility.Embrace;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.base;
import Tranquility.Utilities.excelutility;
import pomdesign.EditSensorPage;
import pomdesign.loginpage;

public class EditSensor extends base {
	public WebDriver driver;

	@BeforeMethod(groups = { "Smoke","Regression" })
	public void setbrowser() throws IOException {
		driver = initializeBrowser();
		driver.get(seturl);
	}

	@Test(groups = { "Smoke", "Regression" })
	public void editsensor() throws IOException {
		excelutility file = new excelutility();
		ArrayList<String> data = file.getData("SuperAdmin", "Login");
		loginpage login = new loginpage(driver);
		login.enterEmail().sendKeys(data.get(1));
		login.enterPassword().sendKeys(data.get(2));
		login.clickLogin().click();
		EditSensorPage edit = new EditSensorPage(driver);
		WebElement sensor = edit.sensorDropdownMenu();
		Actions action = new Actions(driver);
		action.moveToElement(sensor).build().perform();
		edit.selectsensors().click();
		edit.selectHospitaldropdown().click();
		edit.selectHospital();
		edit.selecteditoption();
		edit.editMAxMove();
		edit.saveChanges();
		assertTrue(driver.getCurrentUrl().endsWith("HospitalID=5b95fe5d-3532-4a22-88f8-9299dcf45adf"));
	}

	@AfterMethod(groups = { "Smoke","Regression" })
	public void endtest() {
		driver.close();
	}

}
