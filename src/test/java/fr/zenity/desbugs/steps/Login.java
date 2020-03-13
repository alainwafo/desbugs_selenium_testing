package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.Context;
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class Login implements En {

    public Login(
            ScenarioContext scenarioContext,
            LoginPage loginPage
    ) {

        Given("I am on the Login Page", () -> {
            loginPage.navigateToLoginPage();
            loginPage.waitPageToBeLoad();
        });

        Given("I fill the Login Form", () -> {
            // TODO : variabilise user credential
            loginPage.writeUser("admin");
            loginPage.writePassword("admin");
        });

        When("I valid the Login Form", () -> {
            loginPage.submitForm();
        });

        Then("the logged home should be displayed", () -> {
            //assert driver.getCurrentUrl().equals(DesbugsPage.LOGGED_HOME.getUrl());
        });
    }
}
