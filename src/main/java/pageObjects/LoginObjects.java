package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.VehicleRoutingTestBase;

public class LoginObjects extends VehicleRoutingTestBase {

    @FindBy(xpath = "//span[contains(text(),'Login With Google')]/parent::button")
    WebElement btn_login;

    public LoginObjects () {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        btn_login.click();
    }
}
