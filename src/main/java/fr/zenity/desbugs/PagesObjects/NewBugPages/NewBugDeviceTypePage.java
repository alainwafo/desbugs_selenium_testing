package fr.zenity.desbugs.PagesObjects.NewBugPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewBugDeviceTypePage extends Page {

    public enum DeviceType {
        COMPUTER, PAD, SMARTPHONE;
    }

    public NewBugDeviceTypePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.NEW_BUG, container);
    }

    By container = By.className("jss23");
    By returnButton = By.className("jss18");
    By computerContainer = By.cssSelector("div.jss23 > div.MuiGrid-item[0]");
    By padContainer = By.cssSelector("div.jss23 > div.MuiGrid-item[1]");
    By smartphoneContainer = By.cssSelector("div.jss23 > div.MuiGrid-item[2]");

    public void selectBugPlateform (DeviceType type) {
        switch (type) {
            case COMPUTER:
                click(computerContainer);
                break;
            case PAD:
                click(padContainer);
                break;
            case SMARTPHONE:
                click(smartphoneContainer);
                break;
        }
    }
}
