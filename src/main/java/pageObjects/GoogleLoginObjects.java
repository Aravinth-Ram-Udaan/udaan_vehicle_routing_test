package pageObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.VehicleRoutingTestBase;

import java.util.HashMap;

public class GoogleLoginObjects extends VehicleRoutingTestBase {

    @FindBy(xpath = "//input[@id='identifierId']")
    WebElement txt_identifierId;

    @FindBy(id = "identifierNext")
    WebElement btn_identifierNext;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txt_password;

    @FindBy(id = "passwordNext")
    WebElement btn_passwordNext;

    public GoogleLoginObjects () {
        PageFactory.initElements(driver, this);
    }

    public void fillLogin(HashMap<String, String> testData) {

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(txt_identifierId)).sendKeys(testData.get("identifierId"));
        btn_identifierNext.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(txt_password)).sendKeys(testData.get("password"));
        btn_passwordNext.click();

    }
}
