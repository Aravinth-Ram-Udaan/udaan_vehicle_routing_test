package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.GoogleLoginObjects;
import pageObjects.LoginObjects;
import pageObjects.VehicleRoutingConsoleObjects;
import reusableComponents.PropertiesOperations;

import java.util.concurrent.TimeUnit;

public class VehicleRoutingTestBase extends ObjectsRepo {

    public void LaunchBrowserAndNavigate () throws Exception {

        String browser = PropertiesOperations.getPropertyValueByKey("browser");
        String url = PropertiesOperations.getPropertyValueByKey("url");

        if(browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(url);

    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        LaunchBrowserAndNavigate();
        vehicleRoutingConsoleObjects = new VehicleRoutingConsoleObjects();
        loginObjects = new LoginObjects();
        googleLoginObjects = new GoogleLoginObjects();
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }

}
