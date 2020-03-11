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

    By container = By.className("MuiGrid-container");
    By returnButton = By.className("#root > div:nth-child(2) > div > h3");
    By computerContainer = By.cssSelector("#root > section > div > div.MuiGrid-item:nth-child(1)");
    By padContainer = By.cssSelector("#root > section > div > div.MuiGrid-item:nth-child(2)");
    By smartphoneContainer = By.cssSelector("#root > section > div > div.MuiGrid-item:nth-child(3)");

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
