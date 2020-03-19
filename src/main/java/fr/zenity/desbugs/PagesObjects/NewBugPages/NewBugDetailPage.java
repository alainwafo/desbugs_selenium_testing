package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.classes.Bug;
import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewBugDetailPage extends Page {

    private By containerBy = By.cssSelector("div.MuiContainer-root > div > div > section > section");

    //TODO find better selector
    @FindBy(className = "#root > div:nth-child(2) > div > h3")
    private WebElement returnButton;
    @FindBy(id = "name-website")
    private WebElement webSiteNameInput;
    @FindBy(id = "address-website")
    private WebElement webSiteUrlInput;
    @FindBy(css = "div.public-DraftStyleDefault-block")
    private WebElement bugDescriptionInput;
    @FindBy(id = "mui-component-select-os")
    private WebElement osInput;
    @FindBy(id = "mui-component-select-browser")
    private WebElement browserInput;
    @FindBy(css = "ul.MuiMenu-list[aria-labelledby=\"os-label\"] > li.MuiMenuItem-root")
    private List<WebElement> osInputList;
    @FindBy(css = "ul.MuiMenu-list[aria-labelledby=\"browser-label\"] > li.MuiMenuItem-root")
    private List<WebElement> browserInputList;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submitButton;

    public void writeWebsiteName(String name) {
        writeText(webSiteNameInput, name);
    }

    public void writeWebsiteUrl(String url) {
        writeText(webSiteUrlInput, url);
    }

    public void writeDescription(String desc) {
        click(bugDescriptionInput);
        writeText(driver.switchTo().activeElement(), desc);
    }

    public void clickOs(String os) {
        //if os is not empty, select on
        if (!os.isEmpty() || os != null) {
            click(osInput);
            for (WebElement li :
                    osInputList) {
                if (li.getText() == os) {
                    li.click();
                    return;
                }
            }
            //if os not find, click on first
            LOGGER.info(String.format("The os \"%s\" does not exist. First element will be selected", os));
            osInputList.get(0).click();
        }
    }

    public void clickBrowser(String browser) {
        //if os is not empty, select on
        if (!browser.isEmpty() || browser != null) {
            click(browserInput);
            for (WebElement li :
                    browserInputList) {
                if (li.getText() == browser) {
                    li.click();
                    return;
                }
            }
            //if os not find, click on first
            LOGGER.info(String.format("The os \"%s\" does not exist. First element will be selected", browser));
            browserInputList.get(0).click();
        }
    }

    public void returnToPreviousPage() {
        click(returnButton);
    }

    public void submitForm() {
        click(submitButton);
    }

    public boolean isPageOpen(){
        return isPageOpened(DesbugsPage.NEW_BUG, containerBy);
    }

    public void waitPageToBeLoad() {
            init(DesbugsPage.NEW_BUG, containerBy);
    }
}