package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.InformationPopup;
import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.classes.Bug;
import org.openqa.selenium.By;

public class NewBugPlateformPage extends Page {

    private InformationPopup popup;

    private By containerBy = By.id("typeSelection");

    private By webContainerBy = By.cssSelector("section#typeSelection > div > div.MuiGrid-item:nth-child(1)");

    private By  softwareContainerBy = By.cssSelector("section#typeSelection > div > div.MuiGrid-item:nth-child(2)");

    public void clickPlateformType (Bug.PlateformType type) {
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
        Bug.PlateformType pform = null;
        try{
            pform = Bug.PlateformType.valueOf(plateform);
        }catch(Exception e) {
            LOGGER.error(String.format("The plateform \"%s\" does not exist.", plateform));
        }
        clickPlateformType(pform);
    }

    public void waitPageToBeLoad() {
        init(DesbugsPage.NEW_BUG, containerBy);
        //if user is not logged, popup showed
        try{
            popup = new InformationPopup();
        }catch(Exception e) {
            LOGGER.info("The user is not logged, you should call the closeInformationPopup function before to continue.");
        }
    }

    public boolean isPageOpen(){
        return isPageOpened(DesbugsPage.NEW_BUG, containerBy);
    }

    public void closeInformationPopup() {
        popup.clickButtonWithText("CONTINUER");
        init(DesbugsPage.NEW_BUG, containerBy);
    }

}