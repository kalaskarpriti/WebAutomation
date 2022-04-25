package Tranquility.Embrace;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Resources.base;
import Tranquility.Utilities.excelutility;
import pomdesign.loginpage;

public class login extends base {

	public WebDriver driver;
	excelutility file = new excelutility();

	@BeforeSuite(groups = { "Smoke","Regression" })
	public void setbrowser() throws IOException {

		driver = initializeBrowser();
		driver.get(seturl);
	}

	@Test(priority = 1, groups = { "Smoke","Regression" })
	public void Vadlidlogin() throws IOException {
		ArrayList<String> data = file.getData("SuperAdmin", "Login");
		loginpage login = new loginpage(driver);
		login.enterEmail().sendKeys(data.get(1));
		login.enterPassword().sendKeys(data.get(2));
		login.clickLogin().click();
		String actualLoginURL = driver.getCurrentUrl();
		assertEquals(actualLoginURL, validLoginURL);
		login.logOut().click();
		login.logoutButton().click();

	}

	@Test(priority = 3, groups = "Regression")
	public void InValidlogin() throws IOException {
		ArrayList<String> data = file.getData("OtherUser", "Login");
		loginpage login = new loginpage(driver);
		login.enterEmail().sendKeys(data.get(1));
		login.enterPassword().sendKeys(data.get(2));
		login.clickLogin().click();
		String actualLoginURL = driver.getCurrentUrl();
		assertEquals(actualLoginURL, invalidLoginURL);
	}

	@Test(priority = 2, groups = { "Smoke","Regression" })
	public void NhLogin() throws IOException {
		ArrayList<String> data = file.getData("NursingHomeAdmin", "Login");
		loginpage login = new loginpage(driver);
		login.enterEmail().sendKeys(data.get(1));
		login.enterPassword().sendKeys(data.get(2));
		login.clickLogin().click();
		assertTrue(driver.getCurrentUrl().endsWith("azurewebsites.net/#"));
		login.logOut().click();
		login.logoutButton().click();
	}

	@AfterSuite(groups = { "Smoke","Regression" })
	public void closing() {
		driver.close();
	}

}
