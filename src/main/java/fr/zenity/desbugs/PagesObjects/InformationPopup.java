package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class InformationPopup extends Page{

    public InformationPopup(WebDriver driver) {
        super(driver);
        waitVisibility(container);
    }

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
