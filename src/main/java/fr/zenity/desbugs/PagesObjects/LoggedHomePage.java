package fr.zenity.desbugs.PagesObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends Page {

    @FindBy(className = "MuiGrid-container")
    private WebElement container ;
}
