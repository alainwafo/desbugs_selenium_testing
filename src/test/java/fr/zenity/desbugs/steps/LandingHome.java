package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.LandingPages.HomePage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class LandingHome implements En {

    public LandingHome(
            ScenarioContext scenarioContext,
            HomePage homePage,
            WebDriverManager driver
    ) {
        Given("I am on the Landing Home Page", () -> {
            driver.getWebDriver();
            homePage.waitPageToBeLoad();
        });
    }
}
