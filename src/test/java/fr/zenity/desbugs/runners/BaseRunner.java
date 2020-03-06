package fr.zenity.desbugs.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.BeforeClass;
import fr.zenity.desbugs.configuration.PropertiesConfig;

public abstract class BaseRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void before_class() {
        BasicConfigurator.configure();
    }

    @BeforeClass
    public static void init_webdriver() {
        if (PropertiesConfig.getInstance().env == null) System.out.println("No env set in the config file. Set the 'environment' variable and try again.");
        else
            PropertiesConfig.getInstance().env.getUrl(false,null);

        System.out.println("-------------- Webdriver initialisation");
    }
}
