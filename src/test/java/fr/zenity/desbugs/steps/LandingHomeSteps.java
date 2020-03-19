package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LandingPages.HomePage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class LandingHomeSteps implements En {

    public LandingHomeSteps(WebDriverManager driver, HomePage homePage
    ) {
        Given("I am on the Landing Home Page", () -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.HOME.getUrl());

            //refresh to have better css result
            for (int i = 0; i < 12; i++) {
                driver.getInstance().getWebDriver().navigate().refresh();
            }
        });

        When("^I select the (.*) landing menu$", (String menu) -> {
            homePage.waitPageToBeLoad();
            homePage.menu.clickMenu(menu);
        });
    }
}
