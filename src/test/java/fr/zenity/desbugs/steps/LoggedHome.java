package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoggedHomePage;
import fr.zenity.desbugs.context.ScenarioContext;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class LoggedHome implements En {

    public LoggedHome(
            ScenarioContext scenarioContext,
            LoggedHomePage homePage,
            WebDriverManager driver
    ) {

        Then("the Logged Home should be displayed", () -> {
            homePage.waitPageToBeLoad();
            String currentUrl = driver.getWebDriver().getCurrentUrl();
            String pageUrl = DesbugsPage.LOGGED_HOME.getUrl();
            assert currentUrl.equals(pageUrl);
        });
    }
}
