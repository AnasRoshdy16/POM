package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {
    private final WebDriver driver;

    private final By Logout_Button = By.xpath("//button[contains(@class,logout)]");

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage ClickLogoutButton()
    {
        Utility.ClickOnElement(driver,Logout_Button);
       return new P01_LoginPage(driver);
    }
}
