package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage extends Page {

    public BlogPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.BLOG, container);
    }

    By container = By.className("");
}