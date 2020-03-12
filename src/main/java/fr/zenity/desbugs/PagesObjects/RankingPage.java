package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RankingPage extends Page {

    public RankingPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.RANKING, container);
    }

    By container = By.className("");

}
