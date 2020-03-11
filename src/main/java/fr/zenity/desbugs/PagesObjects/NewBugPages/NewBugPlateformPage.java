package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewBugPlateformPage extends Page {

    public enum PlateformType {
        WEB, SOFTWARE;
    }

    public NewBugPlateformPage(WebDriver driver) {
        super();
        init(DesbugsPage.NEW_BUG, container);
    }

    By container = By.className("MuiGrid-container");
    By webContainer = By.className("#root > section > div > divMuiGrid-item:nth-child(1)");
    By softwareContainer = By.className("#root > section > div > div.MuiGrid-item:nth-child(2)");

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


