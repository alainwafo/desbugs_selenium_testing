package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LandingPages.HomePage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class LandingHomeSteps implements En {

    public LandingHomeSteps(WebDriverManager driver, HomePage homePage
    ) {
        Given("I am on the Landing Home Page", () -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.LOGIN.getUrl());
        });
    }
}
