package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.Context;
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;

public class Login extends Hook{

    public Login(ScenarioContext scenarioContext) {

        super(scenarioContext);

        Given("I am on the Login Page", () -> {
            driver.navigate().to(DesbugsPage.LOGIN.getUrl());
            LoginPage loginPage = new LoginPage(driver);
            scenarioContext.set(Context.CURRENT_PAGE, loginPage);
        });

        Given("I fill the Login Form", () -> {
            LoginPage loginPage = (LoginPage)scenarioContext.get(Context.CURRENT_PAGE);
            loginPage.fillForm("admin", "admin");
        });

        When("I valid the Login Form", () -> {
            LoginPage loginPage = (LoginPage)scenarioContext.get(Context.CURRENT_PAGE);
            loginPage.fillForm("admin", "admin");
            loginPage.validForm();
        });

        Then("the logged home should be displayed", () -> {
            assert driver.getCurrentUrl().equals(DesbugsPage.LOGGED_HOME.getUrl());
        });
    }
}
