package fr.zenity.desbugs.PagesObjects.NewBugPages;


import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewBugDeviceTypePage extends Page {

    public enum DeviceType {
        COMPUTER, PAD, SMARTPHONE;
    }

    @FindBy(className = "MuiGrid-container")
    private WebElement container ;
    @FindBy(className = "#root > div:nth-child(2) > div > h3")
    private WebElement  returnButton ;
    @FindBy(css = "#root > section > div > div.MuiGrid-item:nth-child(1)")
    private WebElement  computerContainer ;
    @FindBy(css = "#root > section > div > div.MuiGrid-item:nth-child(2)")
    private WebElement  padContainer ;
    @FindBy(css = "#root > section > div > div.MuiGrid-item:nth-child(3)")
    private WebElement  smartphoneContainer ;

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
