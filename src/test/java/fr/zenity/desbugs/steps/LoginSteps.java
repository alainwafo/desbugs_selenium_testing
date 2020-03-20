package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.PagesObjects.Page;
import io.cucumber.datatable.DataTable;
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;
import java.util.List;
import java.util.Map;

public class LoginSteps implements En {

    public LoginSteps(WebDriverManager driver, LoginPage loginPage
    ) {

        Given("I am on the Login Page", () -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.LOGIN.getUrl());
        });

        Given("^I fill the Login Form:$", (DataTable dt) -> {
            loginPage.waitPageToBeLoad();
            List<Map<String, String>> credential = dt.asMaps(String.class, String.class);
            loginPage.writeUser(credential.get(0).get("username"));
            loginPage.writePassword(credential.get(0).get("password"));
        });

        When("I valid the Login Form", () -> {
            loginPage.waitPageToBeLoad();
            loginPage.submitForm();
        });

        Given("^I login with:$", (DataTable dt) -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.LOGIN.getUrl());
            loginPage.waitPageToBeLoad();
            List<Map<String, String>> credential = dt.asMaps(String.class, String.class);
            loginPage.writeUser(credential.get(0).get("username"));
            loginPage.writePassword(credential.get(0).get("password"));
            loginPage.submitForm();
        });

        Then("the Login Page should be displayed", () -> {
            assert loginPage.isPageOpen();
        });
    }
}
