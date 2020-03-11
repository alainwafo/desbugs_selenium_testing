package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Page {


    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;
    protected Wait shortWait;

    public void init(DesbugsPage pageName, WebElement container){
        new WebDriverWait(driver,60).until(ExpectedConditions.urlMatches(pageName.getUrl()));
        waitVisibility(container);
    public final static Device          DEVICE  = Config.propConfig.device;

    public Page(){
        driver      = WebDriverManager.getWebDriver();
        js          = (JavascriptExecutor)driver;
        shortWait   = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    //Wait Wrapper Method
    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    //Click Method
    public void click (WebElement element) {
        waitVisibility(element);
        element.click();
    }

    //Write Text
    public void writeText (WebElement element, String text) {
        waitVisibility(element);
        element.sendKeys(text);
    }

    //Read Text
    public String readText (WebElement element) {
        waitVisibility(element);
        return element.getText();
    }

    public boolean isSelected(WebElement element) {
        waitVisibility(element);
        String selected = element.getAttribute("aria-selected");
        return !selected.isEmpty() || selected != null ? Boolean.parseBoolean(selected) : false;
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
