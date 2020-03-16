package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.InformationPopup;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewBugPlateformPage extends Page {

    public enum PlateformType {
        WEB, SOFTWARE;
    }

    private InformationPopup popup;

    private By containerBy = By.cssSelector("div.MuiContainer-root > div > div > section > div.MuiGrid-container");

    private By webContainerBy = By.cssSelector("div.MuiGrid-item:nth-child(1)");

    private By  softwareContainerBy = By.cssSelector("div.MuiGrid-item:nth-child(2)");

    public void clickPlateformType (PlateformType type) {
        switch (type) {
            case SOFTWARE:
                click(driver.findElement(softwareContainerBy));
            break;
            case WEB:
                click(driver.findElement(webContainerBy));
                break;
        }
    }

    public void clickPlateformType(String plateform) {
        PlateformType pform = null;
        try{
            pform = PlateformType.valueOf(plateform);
        }catch(Exception e) {
            LOGGER.error(String.format("The plateform \"%s\" does not exist.", plateform));
        }
        clickPlateformType(pform);
    }

    public void waitPageToBeLoad() {
        try{
            init(DesbugsPage.NEW_BUG, containerBy);
        }catch(Exception e) {

        }
        popup = new InformationPopup();
    }

    public boolean isPageOpen(){
        return isPageOpened(DesbugsPage.NEW_BUG, containerBy);
    }

    public void closeInformationPopup() {
        popup.clickButtonWithText("CONTINUER");
        init(DesbugsPage.NEW_BUG, containerBy);
    }

}