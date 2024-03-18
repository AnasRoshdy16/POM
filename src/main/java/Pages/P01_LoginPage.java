package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final WebDriver driver;
    private final By username = By.id("inputUsername");
    private final By password = By.id("inputPassword");
    private final By loginButton = By.id("loginButton");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage enterUsername(String usernameText)
    {
        Utility.sendText(driver,username,usernameText);
        return this;
    }

    public P01_LoginPage enterPassword(String PasswordText)
    {
        Utility.sendText(driver,password,PasswordText);
        return this;
    }

    public P02_HomePage clickLoginButton()
    {
        Utility.ClickOnElement(driver,loginButton);
        return new P02_HomePage(driver);
    }

    public P02_HomePage LoginSteps(String usernameText,String PasswordText)
    {
       return enterUsername(usernameText)
                .enterPassword(PasswordText)
                .clickLoginButton();
    }

}
