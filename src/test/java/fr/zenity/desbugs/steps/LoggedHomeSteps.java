package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.LoggedHomePage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class LoggedHomeSteps implements En {

    public LoggedHomeSteps(WebDriverManager driver, LoggedHomePage homePage
    ) {

        Then("the Logged Home should be displayed", () -> {
            assert homePage.isPageOpen();
        });

        When("^I select the (.*) menu$", (String menu) -> {
            homePage.waitPageToBeLoad();
            homePage.menu.clickMenu(menu);
        });
    }
}
