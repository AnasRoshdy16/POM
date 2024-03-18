import Pages.P01_LoginPage;
import Utilities.DataUtils;
import Utilities.Utility;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class TC01_LoginTest {
    private WebDriver driver;


    @BeforeMethod
    public void setupDriver() throws IOException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(DataUtils.getpropertyvalue("environments","LOGIN_URL"));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }
    @Description("this test case verifies that the user is logged in successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Roshdy")
    @Test
    public void validloginTC() throws IOException {
        new P01_LoginPage(driver).enterUsername(DataUtils.getJsonData("validloginData","username"))
                        .enterPassword(DataUtils.getJsonData("validloginData","password"))
                        .clickLoginButton();
        Utility.takingscreenshot(driver,"valid login TC");
        Assert.assertEquals(driver.getCurrentUrl(),DataUtils.getpropertyvalue("environments","HOME_URL"));
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
