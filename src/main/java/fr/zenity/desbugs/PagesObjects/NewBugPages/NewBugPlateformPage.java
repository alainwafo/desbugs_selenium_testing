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

    By container = By.className("jss4");
    By returnButton = By.className("jss18");
    By webContainer = By.className("jss5");
    By softwareContainer = By.className("jss6");

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


