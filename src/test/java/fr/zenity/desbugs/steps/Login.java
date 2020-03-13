package fr.zenity.desbugs.steps;

import io.cucumber.datatable.DataTable;
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.java8.En;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login implements En {

    public Login(
            ScenarioContext scenarioContext,
            LoginPage loginPage,
            WebDriverManager driver
    ) {

        Given("I am on the Login Page", () -> {
            driver.getWebDriver().navigate().to(DesbugsPage.LOGIN.getUrl());
            loginPage.waitPageToBeLoad();
        });

        Given("^I fill the Login Form:$", (DataTable dt) -> {
            List<Map<String, String>> credential = dt.asMaps(String.class, String.class);
            loginPage.writeUser(credential.get(0).get("username"));
            loginPage.writePassword(credential.get(0).get("password"));
        });

        When("I valid the Login Form", () -> {
            loginPage.submitForm();
        });
    }
}
