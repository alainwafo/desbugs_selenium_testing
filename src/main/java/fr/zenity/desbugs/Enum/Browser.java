package fr.zenity.desbugs.Enum;

import fr.zenity.desbugs.utils.ResourcesUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public enum Browser {

    CHROME,
    FIREFOX,
    OPERA,
    EDGE;

    private final static Logger LOGGER              = Logger.getLogger(Browser.class);
    private final static String BROWSER_FILE_NAME   = "config/browser.properties";

    private String webDriverPath;
    private String webDriverSystemProperty;

    public static Browser build( String browserName ){
        LOGGER.info(String.format("Browser that will be launched := %s",browserName.toUpperCase()));
        return Browser.valueOf(browserName.toUpperCase());
    }

    public static Browser init(String browserName){
        return build(browserName);
    }

    private void setPath(String path){
        this.webDriverPath = path;
        this.webDriverSystemProperty = String.format("webdriver.%s.driver",this.equals(Browser.FIREFOX) ? "gecko" : this.toString().toLowerCase());
    }

    public String getPath(){
        if(webDriverPath==null) load();
        return webDriverPath;
    }

    public String getProperty(){
        if(webDriverPath==null) load();
        return this.webDriverSystemProperty;
    }

    private void load(){
        try{
            Properties browserProp = new Properties();
            browserProp.load(ResourcesUtils.getStreamResources(BROWSER_FILE_NAME));
            browserProp.forEach((key,value)->{
                Browser.valueOf(key.toString().toUpperCase()).setPath(value.toString());
            });
        }catch (IOException | java.lang.NullPointerException e ){
            LOGGER.error(String.format("Cannot load [%s] properties files !",BROWSER_FILE_NAME));
            throw new RuntimeException(e.getMessage());
        }
    }

}
