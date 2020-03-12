package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewBugPlateformPage extends Page {

    public enum PlateformType {
        WEB, SOFTWARE;
    }

    @FindBy(className = "MuiGrid-container")
    private WebElement container ;
    @FindBy(className = "#root > section > div > divMuiGrid-item:nth-child(1)")
    private WebElement  webContainer ;
    @FindBy(className = "#root > section > div > div.MuiGrid-item:nth-child(2)")
    private WebElement  softwareContainer ;

    public void selectPlateformType (PlateformType type) {
        switch (type) {
            case SOFTWARE:
                click(softwareContainer);
                break;
            case WEB:
                click(webContainer);
                break;
        }
    }
}


