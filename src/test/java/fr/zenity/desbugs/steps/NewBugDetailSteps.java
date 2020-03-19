package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugDetailPage;
import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.classes.Bug;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

public class NewBugDetailSteps implements En {

    public NewBugDetailSteps(WebDriverManager driver, NewBugDetailPage newBugDetailPage, Bug bug
    ) {

        Then("the New Bug Detail Page should be displayed", () -> {
            assert newBugDetailPage.isPageOpen();
        });

        And("^I fill the New Bug Detail Form:$", (DataTable dt) -> {
            bug.setDetail(dt);

            newBugDetailPage.waitPageToBeLoad();

            newBugDetailPage.writeWebsiteName(bug.getWebSiteName());
            newBugDetailPage.writeWebsiteUrl(bug.getWebSiteUrl());
            newBugDetailPage.writeDescription(bug.getDescription());
            newBugDetailPage.clickOs(bug.getOs());
            newBugDetailPage.clickBrowser(bug.getBrowser());
        });

        When("^I valid the New Bug Form$", () -> {
            newBugDetailPage.waitPageToBeLoad();
            newBugDetailPage.submitForm();
        });

        When("^I fill the Description on New Bug Detail Form with (.*)$", (String description) -> {
            bug.setDescription(description);

            newBugDetailPage.waitPageToBeLoad();
            newBugDetailPage.writeDescription(bug.getDescription());
        });

        When("^I fill the Website name on New Bug Detail Form with (.*)$", (String websiteName) -> {
            bug.setWebSiteName(websiteName);

            newBugDetailPage.waitPageToBeLoad();
            newBugDetailPage.writeWebsiteName(bug.getWebSiteName());
        });

        Then("^An error message field should be displayed$", () -> {
            assert Page.isErrorMessageDisplayed();
        });
    }
}
