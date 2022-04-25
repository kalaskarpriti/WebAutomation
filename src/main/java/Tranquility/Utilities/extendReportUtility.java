package Tranquility.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendReportUtility {

	public static ExtentReports ExReport;

	static public ExtentReports Report() {
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Tranquility Test");
		report.config().setDocumentTitle("Embrace Sensor Testing");

		ExReport = new ExtentReports();
		ExReport.attachReporter(report);
		ExReport.setSystemInfo("Tester", "Priti Kalaskar");

		return ExReport;

	}
}
