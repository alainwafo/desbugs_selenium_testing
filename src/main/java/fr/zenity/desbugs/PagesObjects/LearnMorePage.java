package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LearnMorePage extends Page {

    public LearnMorePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.LEARN_MORE, container);
    }

    By container = By.className("");
}
