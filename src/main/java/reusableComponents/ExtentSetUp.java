package reusableComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testBase.ObjectsRepo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentSetUp extends ObjectsRepo {

    public static ExtentReports setUpExtentReport () {

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Document Title");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("ReportName");

        return extent;

    }
}
