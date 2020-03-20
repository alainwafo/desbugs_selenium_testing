package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.ApiUrlEnvironment;
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.Enum.Device;
import fr.zenity.desbugs.configuration.Config;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

public class Page {

    protected static WebDriver driver;
    protected static JavascriptExecutor js;
    protected static WebDriverWait wait;
    protected static Wait shortWait;
    protected boolean isLoaded = false;

    public final static Device DEVICE   = Config.propConfig.device;

    protected final static Logger LOGGER  = Logger.getLogger(Page.class);

    protected Page(){
        this.driver = WebDriverManager.getInstance().getWebDriver();
        js          = (JavascriptExecutor) this.driver;
        wait   = new WebDriverWait(this.driver,5);
        shortWait   = new WebDriverWait(this.driver,5);
        PageFactory.initElements(this.driver,this);
    }

    protected void init(DesbugsPage pageName, WebElement container){
        if (!isLoaded) {
            new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(pageName.getUrl()));
            waitVisibility(container);
            isLoaded = true;
        }
    }

    protected void init(DesbugsPage pageName, By containerBy){
        if (!isLoaded) {
            new WebDriverWait(driver, 60).until(ExpectedConditions.urlToBe(pageName.getUrl()));
            wait.until(ExpectedConditions.visibilityOfElementLocated(containerBy));
            isLoaded = true;
        }
    }

    protected boolean isPageOpened(DesbugsPage pageName, WebElement container){
        try{
            init(pageName, container);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    protected boolean isPageOpened(DesbugsPage pageName, By containerBy){
        try{
            init(pageName, containerBy);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    //Wait Wrapper Method
    protected void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitLoading(WebElement progressbar) {
        if (waitUntil(ExpectedConditions.visibilityOf(progressbar))){
            waitUntil(ExpectedConditions.invisibilityOf(progressbar));
        }
    }

    //Click Method
    protected void click (WebElement element) {
        waitVisibility(element);
        scrollToElement(element);
        element.click();
    }

    protected void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Write Text
    protected void writeText (WebElement element, String text) {
        waitVisibility(element);
        scrollToElement(element);
        element.sendKeys(text);
        element.sendKeys(Keys.TAB);
    }

    //Read Text
    protected String readText (WebElement element) {
        waitVisibility(element);
        scrollToElement(element);
        return element.getText();
    }

    protected boolean isSelected(WebElement element) {
        waitVisibility(element);
        scrollToElement(element);
        String selected = element.getAttribute("aria-selected");
        return !selected.isEmpty() || selected != null ? Boolean.parseBoolean(selected) : false;
    }

    protected static <T>boolean waitUntil(Function<? super WebDriver,T> isTrue){
        try{
            shortWait.until(isTrue);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
