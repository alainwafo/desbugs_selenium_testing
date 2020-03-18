package fr.zenity.desbugs.steps;

<<<<<<< HEAD
import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugDeviceTypePage;
=======
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugDeviceTypePage;
import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugPlateformPage;
>>>>>>> ef727914088beccbfd7f46ae0a177aabd724dad3
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

public class NewBugDeviceSteps implements En {

    public NewBugDeviceSteps(WebDriverManager driver, NewBugDeviceTypePage newBugDeviceTypePage
    ) {

        Then("the New Bug Device Page should be displayed", () -> {
            assert newBugDeviceTypePage.isPageOpen();
        });

        When("^I select the device (.*)$", (String device) -> {
            newBugDeviceTypePage.waitPageToBeLoad();
            newBugDeviceTypePage.clickDeviceType(device);
        });
    }
}
