package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugPlateformPage;
import fr.zenity.desbugs.classes.Bug;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class NewBugPlateformSteps implements En {

    public NewBugPlateformSteps(WebDriverManager driver, NewBugPlateformPage newBugPlateformPage, Bug bug
    ) {

        Then("the New Bug Plateform Page should be displayed", () -> {
            assert newBugPlateformPage.isPageOpen();
        });

        Given("^I am on the New Bug Plateform Page$", () -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.NEW_BUG.getUrl());
        });

        When("^I select the plateform (.*)$", (String plateform) -> {
            bug.setPlateform(plateform);

            newBugPlateformPage.waitPageToBeLoad();
            newBugPlateformPage.clickPlateformType(bug.getPlateform());
        });

        Given("^I close the information popUp$", () -> {
            newBugPlateformPage.waitPageToBeLoad();
            newBugPlateformPage.closeInformationPopup();
        });
    }
}
