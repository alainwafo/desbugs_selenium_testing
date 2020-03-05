package fr.zenity.desbugs;


import fr.zenity.desbugs.config.PropertiesConfig;
import fr.zenity.desbugs.config.PropertiesFile;
import fr.zenity.desbugs.context.ScenarioContext;
import org.apache.log4j.Logger;
import sun.security.krb5.Config;

import static fr.zenity.desbugs.Enum.Context.LOL;
import static fr.zenity.desbugs.Enum.Context.TEST;

public class Test {

    public static Logger LOGGER = Logger.getLogger(Test.class);

    public static PropertiesFile lol = PropertiesFile.getInstance();

    public static void main(String[] args){


       lol.get("test");


        PropertiesConfig config = PropertiesConfig.getInstance();

        System.out.println(config.env);
        System.out.println(config.browser);
        System.out.println(config.isProxy);

        System.out.println(config.env.getUrl(null));
        System.out.println(config.browser.getPath());

        ScenarioContext context = new ScenarioContext();

        context.set(TEST,"msdrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        context.set(LOL,new Object[]{ ScenarioContext.class });
        System.out.println( (String)context.get(TEST) );
        System.out.println( (Object)context.get(LOL).toString() );


    }

}
