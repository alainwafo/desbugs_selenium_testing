package fr.zenity.desbugs.step_definitions;


import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.context.ScenarioContext;
import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
//import cucumber.api.java8.En;

public class Login implements En {

    public WebDriver driver;

    public Login(
            ScenarioContext scenarioContext,
            LoginPage loginPage
    ) {

        Given("I am on the Login Page", () -> {

            loginPage.navigateToLoginPage();
            //driver.navigate().to(DesbugsPage.LOGIN.getUrl());
            //LoginPage loginPage = new LoginPage(driver);
            //scenarioContext.set(Context.CURRENT_PAGE, loginPage);
        });

        Given("I fill the Login Form", () -> {
            //LoginPage loginPage = (LoginPage)scenarioContext.get(Context.CURRENT_PAGE);
            //loginPage.fillForm("admin", "admin");
        });

        When("I valid the Login Form", () -> {
           // LoginPage loginPage = (LoginPage)scenarioContext.get(Context.CURRENT_PAGE);
           // loginPage.fillForm("admin", "admin");
            //loginPage.validForm();
        });

        Then("the logged home should be displayed", () -> {
           // assert driver.getCurrentUrl().equals(DesbugsPage.LOGGED_HOME.getUrl());
        });
    }
}
