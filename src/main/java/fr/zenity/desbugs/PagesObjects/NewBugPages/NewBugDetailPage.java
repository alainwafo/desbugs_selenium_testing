package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewBugDetailPage extends Page {

    public NewBugDetailPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.NEW_BUG, container);
    }

    @FindBy(className = "MuiGrid-container")
    private WebElement  container ;
    //TODO find better selector
    @FindBy(className = "#root > div:nth-child(2) > div > h3")
    private WebElement  returnButton ;
    @FindBy(id = "name-website")
    private WebElement  webSiteNameInput ;
    @FindBy(id = "address-website")
    private WebElement  webSiteUrlInput ;
    @FindBy(css = "div.public-DraftStyleDefault-block > span > span")
    private WebElement  bugDescriptionInput ;
    @FindBy(id = "mui-component-select-os")
    private WebElement  osInput ;
    @FindBy(id = "mui-component-select-browser")
    private WebElement  browserInput ;
    @FindBy(css = "ul.MuiMenu-list[aria-labelledby=\"os-label\"] > li.MuiMenuItem-root")
    private List<WebElement>  osInputList ;
    @FindBy(css = "ul.MuiMenu-list[aria-labelledby=\"browser-label\"] > li.MuiMenuItem-root")
    private List<WebElement>  browserInputList ;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement  submitButton ;

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
        for ( WebElement li:
                osInputList ) {
            if (li.getText() == os) {li.click();break;}
        }
    }

    public void writeBrowser(String browser) {
        click(browserInput);
        for ( WebElement li:
                browserInputList ) {
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