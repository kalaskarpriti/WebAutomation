package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {
	public WebDriver driver;
	public Properties prop;
	public String seturl;
	public String validLoginURL;
	public String invalidLoginURL;

	public WebDriver initializeBrowser() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		seturl = prop.getProperty("url");
		validLoginURL = prop.getProperty("validloginurl");
		invalidLoginURL = prop.getProperty("invalidloginurl");

		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
			 driver = new ChromeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Dimension dimension = new Dimension(1920, 1080);
		driver.manage().window().setSize(dimension);
		return driver;

	}

	/*
	 * To take a screenshot in Selenium, we use an interface called TakesScreenshot,
	 * which enables the Selenium WebDriver to capture a screenshot and store it in
	 * different ways. It has a got a method "getScreenshotAs() " which captures the
	 * screenshot and store it in the specified location.*?
	 */

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
