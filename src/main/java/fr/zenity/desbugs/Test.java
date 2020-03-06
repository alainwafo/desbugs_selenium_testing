package fr.zenity.desbugs;


import fr.zenity.desbugs.configuration.PropertiesConfig;
import fr.zenity.desbugs.configuration.PropertiesFile;
import fr.zenity.desbugs.context.ScenarioContext;
import org.apache.log4j.Logger;

import static fr.zenity.desbugs.Enum.Context.*;

public class Test {

    public static Logger LOGGER = Logger.getLogger(Test.class);

    public static PropertiesFile lol = PropertiesFile.getInstance();

    public static void main(String[] args){

       lol.get("test");

        PropertiesConfig config = PropertiesConfig.getInstance();

        System.out.println(config.env);
        System.out.println(config.browser);
        System.out.println(config.isProxy);

        System.out.println(config.env.getUrl(false, null));
        System.out.println(config.browser.getPath());

        ScenarioContext context = new ScenarioContext();
    }

}
