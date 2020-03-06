package fr.zenity.desbugs.steps;

import fr.zenity.desbugs.Enum.Context;
import fr.zenity.desbugs.context.ScenarioContext;
import fr.zenity.desbugs.driver.LocalDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Hook {

    protected ScenarioContext scenarioContext;
    private LocalDriver LocalDriver;
    public WebDriver driver;

    public Hook(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void beforeInitWebdriver(){
        driver = LocalDriver.getWebDriver();
    }

    @After
    public void afterClosewebdriver(){
        LocalDriver.closeDriver();
    }
}
