package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugDetailPage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;

public class NewBugDetailSteps implements En {

    public NewBugDetailSteps(NewBugDetailPage newBugDetailPage
    ) {

        Then("^the New Bug Detail Page should be displayed$", () -> {
            assert newBugDetailPage.isPageOpen();
        });

        And("^I fill the New Bug Detail Form:$", (DataTable dt) -> {
            List<Map<String, String>> detailDt = dt.asMaps(String.class, String.class);
            Map<String, String> bugDetail = detailDt.get(0);
            newBugDetailPage.writeWebsiteName(bugDetail.get("webSiteName"));
            newBugDetailPage.writeWebsiteUrl(bugDetail.get("webSiteUrl"));
            newBugDetailPage.writeDescription(bugDetail.get("bugDescription"));
            newBugDetailPage.clickOs(bugDetail.get("os"));
            newBugDetailPage.clickBrowser(bugDetail.get("browser"));
        });

        When("^I valid the New Bug Form$", () -> {
            newBugDetailPage.submitForm();
        });
    }
}
