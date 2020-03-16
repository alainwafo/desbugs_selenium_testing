package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugPlateformPage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class NewBugPlateformSteps implements En {

    public NewBugPlateformSteps(WebDriverManager driver, NewBugPlateformPage newBugPlateformPage
    ) {

        Then("the New Bug Plateform Page should be displayed", () -> {
            assert newBugPlateformPage.isPageOpen();
        });

        Given("^I am on the New Bug Plateform Page$", () -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.NEW_BUG.getUrl());
        });

        When("^I select the plateform (.*)$", (String plateform) -> {
            newBugPlateformPage.waitPageToBeLoad();
            newBugPlateformPage.clickPlateformType(plateform);
        });

        Given("^I close the information popUp$", () -> {
            newBugPlateformPage.closeInformationPopup();
        });
    }
}
