package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.MyBugsPages.MyBugsPage;
<<<<<<< HEAD
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

=======
import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugDetailPage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;

>>>>>>> ef727914088beccbfd7f46ae0a177aabd724dad3
public class MyBugsSteps implements En {

    public MyBugsSteps(WebDriverManager driver, MyBugsPage myBugsPage
    ) {

        Then("the My Bugs Page should be displayed", () -> {
            assert myBugsPage.isPageOpen();
        });
    }
}
