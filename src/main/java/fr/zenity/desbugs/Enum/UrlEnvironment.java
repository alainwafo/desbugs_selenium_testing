package fr.zenity.desbugs.Enum;

import com.google.common.base.Splitter;
import fr.zenity.desbugs.utils.ResourcesUtils;
import jdk.nashorn.internal.runtime.options.Option;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public enum UrlEnvironment {

    DEVELOP,
    CUSTOM;

    private final static Logger LOGGER                  = Logger.getLogger(UrlEnvironment.class);
    private final static String ENVIRONMENT_FILE_NAME   = "config/urlEnv.properties";
    private String urlLanding                           = null;
    private String urlApp                               = null;


    private static UrlEnvironment build(String env, boolean custom){
        LOGGER.info(String.format("Test environment :=  %s  ",env.toUpperCase()));
        if(custom){
           UrlEnvironment.CUSTOM.setUrls(env);
            return UrlEnvironment.CUSTOM;
        }
        return UrlEnvironment.valueOf(env.toUpperCase());
    }

    public static UrlEnvironment init(String env){
        return build(env,false);
    }

    public static UrlEnvironment initCustom(String env){
        return build(env,true);
    }

    public void setUrls(String urlsProperties){
        Map<String, String> urls = Splitter.on(",").withKeyValueSeparator("=").split(urlsProperties.replaceAll("\\s+", ""));
        urlLanding = urls.get("urlLanding");
        urlApp = urls.get("urlApp");
    }

    public String getUrl(Boolean isApp, String endPoint){
        if(urlLanding==null) load();
        return isApp ?
                getUrl(this.urlApp, endPoint)
                : getUrl(this.urlLanding, endPoint);
    }

    private String getUrl(String url, String endPoint) {
        return endPoint != null ?
                url + (url.endsWith("/") || endPoint.startsWith("/") ? "" : "/") + endPoint
                : url;
    }

    private void load(){
        try{
            Properties urlProp = new Properties();
            urlProp.load(
                    ResourcesUtils.getStreamResources(ENVIRONMENT_FILE_NAME)
            );
            urlProp.forEach((key,value)->{
                UrlEnvironment.valueOf(key.toString().toUpperCase()).setUrls(value.toString());
            });

        }catch( IOException | NullPointerException e){
            LOGGER.error(String.format("Cannot load [ %s ] properties file !", ENVIRONMENT_FILE_NAME));
            throw new RuntimeException(e.getMessage());
        }
    }
}
