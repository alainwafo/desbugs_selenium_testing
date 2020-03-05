package fr.zenity.desbugs.Enum;

import fr.zenity.desbugs.utils.ResourcesUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public enum UrlEnvironment {

    DEVELOP,
    DEMO,
    SINT,
    PROD,
    CUSTOM;

    private final static Logger LOGGER                  = Logger.getLogger(UrlEnvironment.class);
    private final static String ENVIRONMENT_FILE_NAME   = "config/urlEnv.properties";
    private String url                                  = null;


    private static UrlEnvironment build(String env, boolean custom){
        LOGGER.info(String.format("Test environment :=  %s  ",env.toUpperCase()));
        if(custom){
           UrlEnvironment.CUSTOM.setUrl(env.toUpperCase());
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

    public void setUrl(String url){ this.url = url; }

    public String getUrl(String endPoint){
        if(url==null) load();
        return endPoint != null ?
                url+(url.endsWith("/")||endPoint.startsWith("/") ? "" : "/")+endPoint
                : url;
    }

    private void load(){
        try{
            Properties urlProp = new Properties();
            urlProp.load(
                    ResourcesUtils.getStreamResources(ENVIRONMENT_FILE_NAME)
            );
            urlProp.forEach((key,value)->{
                UrlEnvironment.valueOf(key.toString().toUpperCase()).setUrl(value.toString());
            });

        }catch( IOException |java.lang.NullPointerException e){
            LOGGER.error(String.format("Cannot load [ %s ] properties file !",ENVIRONMENT_FILE_NAME));
            throw new RuntimeException(e.getMessage());
        }
    }
}
