package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LandingPages.HomePage;
<<<<<<< HEAD
=======
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;
>>>>>>> ef727914088beccbfd7f46ae0a177aabd724dad3
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
