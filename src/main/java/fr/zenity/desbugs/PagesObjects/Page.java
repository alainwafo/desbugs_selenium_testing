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
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public Page (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,2);
    }

    public void init(DesbugsPage pageName, WebElement container){
        new WebDriverWait(driver,60).until(ExpectedConditions.urlMatches(pageName.getUrl()));
        waitVisibility(container);
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
}
