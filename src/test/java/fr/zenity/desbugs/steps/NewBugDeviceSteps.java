package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugDeviceTypePage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class NewBugDeviceSteps implements En {

    public NewBugDeviceSteps(NewBugDeviceTypePage newBugDeviceTypePage
    ) {

        Then("^the New Bug Device Page should be displayed$", () -> {
            assert newBugDeviceTypePage.isPageOpen();
        });

        When("^I select the device ([a-zA-Z]*)$", (String device) -> {
            newBugDeviceTypePage.waitPageToBeLoad();
            newBugDeviceTypePage.clickDeviceType(device);
        });
    }
}
