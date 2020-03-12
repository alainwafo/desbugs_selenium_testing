package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.Device;
import fr.zenity.desbugs.Enum.UrlEnvironment;
import fr.zenity.desbugs.configuration.Config;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

public class Page {


    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;
    protected Wait shortWait;

    public final static Device          DEVICE  = Config.propConfig.device;

    public Page(){
        driver      = WebDriverManager.getWebDriver();
        js          = (JavascriptExecutor)driver;
        shortWait   = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    protected <T>boolean waitUntil(Function<? super WebDriver,T> isTrue){
        try{
            shortWait.until(isTrue);
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
