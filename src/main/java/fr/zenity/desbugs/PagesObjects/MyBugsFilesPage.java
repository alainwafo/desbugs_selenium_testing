package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyBugsFilesPage extends Page {

    public MyBugsFilesPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.MY_BUGS_FILES, container);
    }

    By container = By.className("");
}
