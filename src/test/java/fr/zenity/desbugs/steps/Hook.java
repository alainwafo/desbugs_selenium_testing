package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.Context;
import fr.zenity.desbugs.context.ScenarioContext;
import fr.zenity.desbugs.driver.LocalDriver;
import io.cucumber.java8.En;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Hook {

    protected ScenarioContext scenarioContext;
    private LocalDriver LocalDriver;
    public WebDriver driver;

    public Hook(ScenarioContext scenarioContext){
        System.out.println("-------------- Hook initialisation");
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void beforeInitWebdriver() {
        System.out.println("-------------- Run @Before function");
        driver = LocalDriver.getWebDriver();
        //TODO : delete DRVIER context
        scenarioContext.set(Context.DRIVER, driver);
    }

    @After
    public void afterClosewebdriver(){
        System.out.println("-------------- Run @After function");
        LocalDriver.closeDriver();
    }
}
