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

    public void init(DesbugsPage pageName, By container){
        new WebDriverWait(driver,60).until(ExpectedConditions.urlMatches(pageName.getUrl()));
        waitVisibility(container);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
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

    //Get list of elements
    public List<WebElement> findElements(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }

    //Get first element
    public WebElement findElement(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy);
    }

    public boolean isSelected(By elementBy) {
        waitVisibility(elementBy);
        String selected = driver.findElement(elementBy).getAttribute("aria-selected");
        return !selected.isEmpty() || selected != null ? Boolean.parseBoolean(selected) : false;
    }
}
