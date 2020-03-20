package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.PagesObjects.UsersPages.AlertComponant;
import io.cucumber.java8.En;

public class Hook implements En{

    public Hook(){

        Then("^An error message field should be displayed$", () -> {
            assert AlertComponant.isErrorMessageDisplayed();
        });

        And("^the new bug validation message should be displayed$", () -> {
            assert AlertComponant.isNewBugValidationMessageDisplayed();
        });
        Then("^the Registration validation Message should be displayed$", () -> {
            assert AlertComponant.isRegisterValidationMessageDisplayed();
        });

    }
}
