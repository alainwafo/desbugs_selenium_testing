package fr.zenity.desbugs.PagesObjects.MyBugsPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBugsDetailsPage extends Page {

    public MyBugsDetailsPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.MY_BUGS_DETAILS, container);
    }

    By container = By.className("");
}
