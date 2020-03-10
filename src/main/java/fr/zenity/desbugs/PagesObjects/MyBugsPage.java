package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBugsPage extends Page {

    public MyBugsPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.MY_BUGS, container);
    }

    By container = By.className("");
}
