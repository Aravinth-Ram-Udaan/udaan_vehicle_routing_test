package vehicleRoutingConsole;

import com.aventstack.extentreports.Status;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reusableComponents.ExcelOperations;
import testBase.VehicleRoutingTestBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class EndToEndTest_VehicleRoutingConsole extends VehicleRoutingTestBase {

    ExcelOperations excelOperations = new ExcelOperations("Sheet1");

    @Test (dataProvider = "VehData")
    public void vehicleRoutingLogin (Object obj) throws InterruptedException {
        HashMap<String, String> testData = (HashMap<String, String>) obj;

        System.out.println("testData" + testData);
        test.log(Status.INFO, "Test data used for execution is " + testData);

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("parentWindowHandle" + parentWindowHandle);
        loginObjects.clickLoginButton();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles" + allWindowHandles);
        for (String window : allWindowHandles) {
            if (!parentWindowHandle.equals(window)) {
                driver.switchTo().window(window);
                googleLoginObjects.fillLogin(testData);
            }
        }
        Thread.sleep(5000);
    }

    @DataProvider (name = "VehData")
    public Object[][] testDataSupplier() throws IOException {
        Object[][] obj = new Object[excelOperations.getRowCount()][1];
        for(int i=1; i<= excelOperations.getRowCount(); i++){
            HashMap<String, String> testData = excelOperations.getTestDataInMap(i);
            obj[i-1][0] = testData;
        }
        return obj;
    }

}
