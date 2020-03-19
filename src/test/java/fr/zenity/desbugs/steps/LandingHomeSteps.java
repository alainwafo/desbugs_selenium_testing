package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LandingPages.HomePage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class LandingHomeSteps implements En {

    public LandingHomeSteps(HomePage homePage
    ) {
        Given("^I am on the Landing Home Page$", () -> {
            WebDriverManager.getWebDriver().navigate().to(DesbugsPage.LOGIN.getUrl());
        });
    }
}
