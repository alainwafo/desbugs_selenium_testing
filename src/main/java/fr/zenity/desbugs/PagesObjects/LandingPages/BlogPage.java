package fr.zenity.desbugs.PagesObjects.LandingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends Page {

    public BlogPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.BLOG, container);
    }

    By container = By.className("");
}
