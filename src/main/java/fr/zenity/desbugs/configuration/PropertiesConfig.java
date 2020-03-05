package fr.zenity.desbugs.config;

import fr.zenity.desbugs.Enum.Browser;
import fr.zenity.desbugs.Enum.Device;
import fr.zenity.desbugs.Enum.UrlEnvironment;

public enum PropertiesConfig {

    INSTANCE;

    private PropertiesFile prop = PropertiesFile.getInstance();

    public UrlEnvironment env;
    public Browser browser;
    public Device device;
    public Boolean isProxy;

    PropertiesConfig( ){

        isProxy = Boolean.valueOf(System.getProperty("proxy",prop.get("proxy.enabled","false")));
        env     = UrlEnvironment.init(System.getProperty("env",prop.get("environment","develop")));
        browser = Browser.init(System.getProperty("browser",prop.get("browser.default","chrome")));

    }

    public UrlEnvironment setUrl(String environmentTemporary){
        env.setUrl(environmentTemporary);
        return env;
    }

    public static PropertiesConfig getInstance( ){ return INSTANCE; }

}
