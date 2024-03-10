package UtilityClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reportGenrateor {
	
	public static ExtentReports reports() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//index.html") ;
		reporter.config().setDocumentTitle("Ecommerce Application Testing");
		reporter.config().setReportName("Raj Prasad");
		reporter.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
		
	}

}
