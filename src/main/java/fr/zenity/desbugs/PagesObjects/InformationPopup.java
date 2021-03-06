package fr.zenity.desbugs.PagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InformationPopup extends Page{

    @FindBy(className = "MuiDialog-container")
    private WebElement  container ;
    @FindBy(className = "MuiButton-containedPrimary")
    private WebElement  primaryButton ;
    @FindBy(css = "MuiButton-root > span")
    private List<WebElement>  buttons ;

    public void clickPrimarybutton() {
        click(primaryButton);
    }

    public void clickButtonWithText(String text) {
        for ( WebElement button:
                buttons ) {
            if (button.getText() == text) {button.click();break;}
        }
    }
}
