package Tranquility.Embrace;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Resources.base;
import Tranquility.Utilities.excelutility;
import pomdesign.CreateUserPage;
import pomdesign.loginpage;

public class CreateUser extends base {
	public WebDriver driver;
	public excelutility file;
	public CreateUserPage user;

	@BeforeSuite(groups={ "Smoke", "Regression" })
	public void stratup() throws IOException {
		System.out.println("driver in before suite");
		driver = initializeBrowser();
		driver.get(seturl);
		file = new excelutility();
		ArrayList<String> data1 = file.getData("SuperAdmin", "Login");
		loginpage login = new loginpage(driver);
		login.enterEmail().sendKeys(data1.get(1));
		login.enterPassword().sendKeys(data1.get(2));
		login.clickLogin().click();
		user = new CreateUserPage(driver);
		WebElement account = user.selectAccount();
		Actions actn = new Actions(driver);
		actn.moveToElement(account).build().perform();
		user.selectUsers();
	}

	@BeforeMethod(groups={ "Smoke", "Regression" })
	public void setbrowser() throws IOException {

		user.selectCreateUsers();
	}

	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void invalidFirstname() throws IOException {
		ArrayList<String> data = file.getData("emptyfirstname", "Createuser");
		user.selectNursingHome().selectByVisibleText("Columbia Asia Hospital");
		user.enterFirstname().sendKeys(" ");
		user.enterLastname().sendKeys(data.get(2));
		user.enterEmail().sendKeys(data.get(3));
		user.enterConfirmEmail().sendKeys(data.get(4));
		user.enterPassword().sendKeys(data.get(5));
		user.enterconfirmPassword().sendKeys(data.get(6));
		user.enterPhoneNumber().sendKeys("+" + data.get(7));
		user.selectGender().selectByValue("2");
		user.createUser().click();
		assertEquals(user.ErrormsgFirstNM(),data.get(1));
	}

	@Test(priority = 2, groups = { "Regression" })
	public void invalidemail() throws IOException {
		ArrayList<String> data = file.getData("emptymail", "Createuser");
		user.selectNursingHome().selectByVisibleText("Columbia Asia Hospital");
		user.enterFirstname().sendKeys(data.get(2));
		user.enterLastname().sendKeys(data.get(3));
		user.enterEmail().sendKeys(" ");
		user.enterConfirmEmail().sendKeys(data.get(5));
		user.enterPassword().sendKeys(data.get(6));
		user.enterconfirmPassword().sendKeys(data.get(7));
		user.enterPhoneNumber().sendKeys("+" + data.get(8));
		user.selectGender().selectByValue("2");
		user.createUser().click();
		assertEquals(user.ErrormsgInvEmail(), data.get(1));

	}

	@Test(priority = 3, groups = { "Regression" })
	public void invalidconfirmemail() throws IOException, InterruptedException {
		ArrayList<String> data = file.getData("emptyconfirmemail", "Createuser");
		user.selectNursingHome().selectByVisibleText("Columbia Asia Hospital");
		user.enterFirstname().sendKeys(data.get(2));
		user.enterLastname().sendKeys(data.get(3));
		user.enterEmail().sendKeys(data.get(4));
		user.enterConfirmEmail().sendKeys(" ");
		user.enterPassword().sendKeys(data.get(6));
		user.enterconfirmPassword().sendKeys(data.get(7));
		user.enterPhoneNumber().sendKeys("+" + data.get(8));
		user.selectGender().selectByValue("2");
		Thread.sleep(4000);
		user.createUser().click();
		assertEquals(user.ErrormsgConfirmEmail(), data.get(1));

	}

	@Test(priority = 4, groups = { "Regression" })
	public void alreayExistsEmail() throws IOException, InterruptedException {
		ArrayList<String> data = file.getData("duplicateemail", "Createuser");
		user.selectNursingHome().selectByVisibleText("Columbia Asia Hospital");
		user.enterFirstname().sendKeys(data.get(2));
		user.enterLastname().sendKeys(data.get(3));
		user.enterEmail().sendKeys(data.get(4));
		user.enterConfirmEmail().sendKeys(data.get(5));
		user.enterPassword().sendKeys(data.get(6));
		user.enterconfirmPassword().sendKeys(data.get(7));
		user.enterPhoneNumber().sendKeys("+" + data.get(8));
		user.selectGender().selectByValue("2");
		Thread.sleep(4000);
		user.createUser().click();
		assertEquals(user.ErrormsgAlreadyExists(), data.get(1));

	}

	@Test(priority = 5, groups = { "Regression" })
	public void emptyPassword() throws IOException, InterruptedException {
		ArrayList<String> data = file.getData("emptypassword", "Createuser");
		user.selectNursingHome().selectByVisibleText("Columbia Asia Hospital");
		user.enterFirstname().sendKeys(data.get(2));
		user.enterLastname().sendKeys(data.get(3));
		user.enterEmail().sendKeys(data.get(4));
		user.enterConfirmEmail().sendKeys(data.get(5));
		user.enterPassword().sendKeys("");
		user.enterconfirmPassword().sendKeys(data.get(6));
		user.enterPhoneNumber().sendKeys("+" + data.get(7));
		user.selectGender().selectByValue("2");
		Thread.sleep(4000);
		user.createUser().click();
		assertEquals(user.emptyPassword(), data.get(1));
	}

	@AfterMethod(groups={ "Smoke", "Regression" })
	public void redirect() {
		user.backClick();
	}

	@AfterSuite(groups={ "Smoke", "Regression" })
	public void endtest() {
		driver.close();
	}
}
