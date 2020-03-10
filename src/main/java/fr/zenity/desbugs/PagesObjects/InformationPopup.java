package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InformationPopup extends Page{

    By container = By.className("MuiDialog-container");
    By primaryButton = By.className("MuiButton-containedPrimary");
    By buttons = By.cssSelector("MuiButton-root > span");

    public void clickPrimarybutton() {
        click(primaryButton);
    }

    public void clickButtonWithText(String text) {
        List<WebElement> list = findElements(buttons);
        for ( WebElement button:
                list ) {
            if (button.getText() == text) {button.click();break;}
        }
    }
}
