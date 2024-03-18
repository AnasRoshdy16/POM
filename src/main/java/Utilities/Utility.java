package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Utility {
    private static String SCREENSHOTS_PATH= "Test-outputs/Screenshots/";
    /**
     * Utility Function for finding and clicking on elements after waiting to be clickable
     * @param driver
     * @param locator
     */
    //TODO: Clicking on element
    public static void ClickOnElement(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //TODO: Sending data to elements
    public static void sendText (WebDriver driver, By locator, String Text)
    {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(Text);
    }

    //TODO: Selecting from Dropdown


    //TODO: Taking Screenshots
    public static void  takingscreenshot(WebDriver driver, String screenshotname) throws IOException {
        File screenshotSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screendest = new File(SCREENSHOTS_PATH+screenshotname+".png");
        FileUtils.copyFile(screenshotSrc,screendest);
        Allure.addAttachment(screenshotname, Files.newInputStream(Path.of(screendest.getPath())));
    }

    //TODO: Converting to by to web element

    //TODO: Scrolling to element

    //TODO: General wait

    //TODO: Uploading Files using robot

    //TODO: get time stamp


}
