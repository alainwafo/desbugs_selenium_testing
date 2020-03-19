package fr.zenity.desbugs.PagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InformationPopup extends Page{

    @FindBy(className = "MuiDialog-container")
    private WebElement  container ;
    @FindBy(className = "MuiButton-containedPrimary")
    private WebElement  primaryButton ;
    @FindBy(css = "div.MuiDialogActions-root > button.MuiButton-root")
    private List<WebElement>  buttons ;

    public InformationPopup(){
        waitVisibility(container);
    }

    public void clickPrimarybutton() {
        click(primaryButton);
    }

    public void clickButtonWithText(String text) {
        //click on the first button with text
        buttons.stream()
                .filter(button->button.getText().equals(text))
                .findFirst()
                .get()
                .click();
    }
}
