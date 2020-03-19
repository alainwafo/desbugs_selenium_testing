package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.ApiUrlEnvironment;
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.Enum.Device;
import fr.zenity.desbugs.configuration.Config;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

public class Page {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected WebDriverWait wait;
    protected Wait shortWait;

    public final static Device DEVICE   = Config.propConfig.device;

    protected final static Logger LOGGER  = Logger.getLogger(Page.class);

    protected Page(){
        this.driver = WebDriverManager.getWebDriver();
        js          = (JavascriptExecutor) this.driver;
        wait   = new WebDriverWait(this.driver,5);
        shortWait   = new WebDriverWait(this.driver,5);
        PageFactory.initElements(this.driver,this);
    }

    protected void init(DesbugsPage pageName, WebElement container){
        new WebDriverWait(driver,60).until(ExpectedConditions.urlToBe(pageName.getUrl()));
        waitVisibility(container);
    }

    protected void init(DesbugsPage pageName, By containerBy){
        new WebDriverWait(driver,60).until(ExpectedConditions.urlToBe(pageName.getUrl()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(containerBy));
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

    protected <T>boolean waitUntil(Function<? super WebDriver,T> isTrue){
        try{
            shortWait.until(isTrue);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
