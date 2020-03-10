package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.Context;
import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class Login implements En {

    public WebDriver driver;

    public Login(ScenarioContext scenarioContext) {
        System.out.println("-------------- Login steps initialisation");

        Given("I am on the Login Page", () -> {
            //TODO : delete DRIVER context
            driver = (WebDriver)scenarioContext.get(Context.DRIVER);
            driver.navigate().to(DesbugsPage.LOGIN.getUrl());
            LoginPage loginPage = new LoginPage(driver);
            scenarioContext.set(Context.CURRENT_PAGE, loginPage);
        });

        Given("I fill the Login Form", () -> {
            LoginPage loginPage = (LoginPage)scenarioContext.get(Context.CURRENT_PAGE);
            // TODO : variabilise user credential
            loginPage.writeUser("admin");
            loginPage.writeUser("admin");
        });

        When("I valid the Login Form", () -> {
            LoginPage loginPage = (LoginPage)scenarioContext.get(Context.CURRENT_PAGE);
            loginPage.submitForm();
        });

        Then("the logged home should be displayed", () -> {
            assert driver.getCurrentUrl().equals(DesbugsPage.LOGGED_HOME.getUrl());
        });
    }
}
