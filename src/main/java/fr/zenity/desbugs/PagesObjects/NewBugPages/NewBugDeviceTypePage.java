package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewBugDeviceTypePage extends Page {

    public enum DeviceType {
        COMPUTER, PAD, SMARTPHONE;
    }

    private By containerBy = By.cssSelector("div.MuiContainer-root > div > div > div > div.MuiGrid-container");

    @FindBy(className = "#root > div:nth-child(2) > div > h3")
    private WebElement  returnButton ;

    private By computerContainerBy = By.cssSelector("div.MuiGrid-item:nth-child(1)");

    private By  padContainerBy = By.cssSelector("div.MuiGrid-item:nth-child(2)");

    private By  smartphoneContainerBy = By.cssSelector("div.MuiGrid-item:nth-child(3)");

    public void clickDeviceType (DeviceType type) {
        switch (type) {
            case COMPUTER:
                click(driver.findElement(computerContainerBy));
                break;
            case PAD:
                click(driver.findElement(padContainerBy));
                break;
            case SMARTPHONE:
                click(driver.findElement(smartphoneContainerBy));
                break;
        }
    }

    public void clickDeviceType(String device) {
        DeviceType dv = null;
        try{
            dv = DeviceType.valueOf(device);
        }catch(Exception e) {
            LOGGER.error(String.format("The device \"%s\" does not exist.", device));
        }
        clickDeviceType(dv);
    }

    public void waitPageToBeLoad() {
        init(DesbugsPage.NEW_BUG, containerBy);
    }

    public boolean isPageOpen(){
        return isPageOpened(DesbugsPage.NEW_BUG, containerBy);
    }
}
