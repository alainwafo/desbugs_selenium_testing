package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.MyBugsPages.MyBugsPage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class MyBugsSteps implements En {

    public MyBugsSteps(WebDriverManager driver, MyBugsPage myBugsPage
    ) {

        Then("the My Bugs Page should be displayed", () -> {
            assert myBugsPage.isPageOpen();
        });

        When("^I click the Add New Bug button of the My Bugs Page$", () -> {
            myBugsPage.waitPageToBeLoad();
            myBugsPage.clickAddNewBugButton();
        });

        And("^I am on the My Bugs Page$", () -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.LOGIN.getUrl());
        });
    }
}
