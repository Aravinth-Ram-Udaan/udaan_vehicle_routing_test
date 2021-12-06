package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.VehicleRoutingTestBase;

public class VehicleRoutingConsoleObjects extends VehicleRoutingTestBase {

    @FindBy(xpath = "//tr[@id='0']")
    WebElement tr_vehicleRow;

    public VehicleRoutingConsoleObjects () {
        PageFactory.initElements(driver, this);
    }

}
