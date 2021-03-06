package fr.zenity.desbugs.configuration;

import fr.zenity.desbugs.Enum.Browser;
import fr.zenity.desbugs.Enum.Device;
import fr.zenity.desbugs.Enum.UrlEnvironment;
import org.apache.log4j.Logger;

public enum PropertiesConfig {

    INSTANCE;

    private final Logger LOGGER = Logger.getLogger(PropertiesConfig.class);

    private PropertiesFile prop = PropertiesFile.getInstance();

    public UrlEnvironment env;
    public UrlEnvironment apiEnv;

    public Browser browser;
    public Device device;
    public Boolean isProxy;
    public Boolean isFrontal;
    public Boolean headless;

    PropertiesConfig( ) {

        isProxy       = Boolean.valueOf(System.getProperty("proxy",prop.get("proxy.enabled","false")));
        isFrontal     = Boolean.valueOf(System.getProperty("frontal",prop.get("test.frontOffice","true")));
        env           = UrlEnvironment.init(System.getProperty("env",prop.get("front.environment","develop")));
        device        = Device.valueOf(System.getProperty("device",prop.get("device","desktop").toUpperCase()));
        apiEnv        = UrlEnvironment.init(System.getProperty("apiEnv",prop.get("api.environment","none")));
        browser       = Browser.init(System.getProperty("browser",prop.get("browser.default","chrome")));
        headless      = Boolean.valueOf(System.getProperty("headless",prop.get("headless","false")));

        LOGGER.info("Proxy is enabled = "+isProxy.toString());
        LOGGER.info("Front-Office test is enabled = "+isFrontal.toString());
        LOGGER.info("Device tested = "+device.toString());
        LOGGER.info("Front environment tested = "+env.toString());
        LOGGER.info("Api environment tested = "+apiEnv.toString());
        LOGGER.info("Browser used for testing = "+browser.toString());
        LOGGER.info("has mode headless = "+headless.toString());

    }

    public static PropertiesConfig getInstance( ){ return INSTANCE; }

}
