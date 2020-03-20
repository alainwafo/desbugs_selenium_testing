package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoginPage;
import fr.zenity.desbugs.PagesObjects.RegisterPages.RegisterPage;
import fr.zenity.desbugs.classes.User;
import fr.zenity.desbugs.driverManager.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;

public class RegisterSteps implements En {

    public RegisterSteps(WebDriverManager driver, RegisterPage registerPage, User user
    ) {
        Given("^I am on the Register Page$", () -> {
            driver.getInstance().getWebDriver().navigate().to(DesbugsPage.REGISTER.getUrl());
        });

        And("^I fill the Register Hunter Form:$", (DataTable dt) -> {
            user.setHunter(dt);

            registerPage.waitPageToBeLoad();

            registerPage.hunterForm.writeLastname(user.getLastname());
            registerPage.hunterForm.writeFirstname(user.getFirstname());
            registerPage.hunterForm.writeUsername(user.getUsername());
            registerPage.hunterForm.writeEmail(user.getEmail());
            registerPage.hunterForm.writePassword(user.getPassword());
            registerPage.hunterForm.writeConfirmPassword(user.getConfirmPassword());
            registerPage.hunterForm.selectCgu(user.isCguValidated());
        });

        When("^I valid the Register Form$", () -> {
            registerPage.waitPageToBeLoad();
            registerPage.submitForm();
        });
    }
}
