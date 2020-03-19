package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.MyBugsPages.MyBugsPage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class MyBugsSteps implements En {

    public MyBugsSteps(MyBugsPage myBugsPage
    ) {

        Then("^the My Bugs Page should be displayed$", () -> {
            assert myBugsPage.isPageOpen();
        });
    }
}
