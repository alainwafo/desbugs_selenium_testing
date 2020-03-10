package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewBugDetailPage extends Page {

    public NewBugDetailPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.NEW_BUG, container);
    }

    By container = By.className("jss16");
    By returnButton = By.className("jss18");
    By webSiteNameInput = By.id("name-website");
    By webSiteUrlInput = By.id("address-website");
    By bugDescriptionInput = By.cssSelector("div.public-DraftStyleDefault-block > span > span");
    By osInput = By.id("mui-component-select-os");
    By browserInput = By.id("mui-component-select-browser");
    By osInputList = By.cssSelector("ul.MuiMenu-list[aria-labelledby=\"os-label\"] > li.MuiMenuItem-root");
    By browserInputList = By.cssSelector("ul.MuiMenu-list[aria-labelledby=\"browser-label\"] > li.MuiMenuItem-root");
    By submitButton = By.cssSelector("button[type=\"submit\"]");

    public void writeWebsiteName(String name) {
        writeText(webSiteNameInput, name);
    }

    public void writeWebsiteUrl(String url) {
        writeText(webSiteUrlInput, url);
    }

    public void writeDescription(String desc) {
        writeText(bugDescriptionInput, desc);
    }

    public void writeOs(String os) {
        click(osInput);
        List<WebElement> list = findElements(osInputList);
        for ( WebElement li:
                list ) {
            if (li.getText() == os) {li.click();break;}
        }
    }

    public void writeBrowser(String browser) {
        click(browserInput);
        List<WebElement> list = findElements(browserInputList);
        for ( WebElement li:
                list ) {
            if (li.getText() == browser) {li.click();break;}
        }
    }

    public void returnToPreviousPage(){
        click(returnButton);
    }

    public void submitForm(){
        click(submitButton);
    }

}