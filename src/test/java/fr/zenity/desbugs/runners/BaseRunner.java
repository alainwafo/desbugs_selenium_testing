package fr.zenity.desbugs.runners;

import org.testng.annotations.BeforeClass;
import fr.zenity.desbugs.configuration.PropertiesConfig;

public abstract class BaseRunner {

    @BeforeClass
    public static void init_webdriver() {
        if (PropertiesConfig.getInstance().env == null) System.out.println("No env set in the config file. Set the 'environment' variable and try again.");
        else
            PropertiesConfig.getInstance().env.getUrl(false,null);

        System.out.println("-------------- Webdriver initialisation");
    }
}
