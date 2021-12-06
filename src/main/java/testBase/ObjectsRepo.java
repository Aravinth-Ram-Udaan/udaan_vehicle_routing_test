package testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import pageObjects.GoogleLoginObjects;
import pageObjects.LoginObjects;
import pageObjects.VehicleRoutingConsoleObjects;
import reusableComponents.CommonMethods;

public class ObjectsRepo {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static VehicleRoutingConsoleObjects vehicleRoutingConsoleObjects;
    public static LoginObjects loginObjects;
    public static GoogleLoginObjects googleLoginObjects;

    public CommonMethods cm = new CommonMethods();

}
