package fr.zenity.desbugs.Enum;

import fr.zenity.desbugs.utils.ResourcesUtils;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum ApiUrlEnvironment{

    DEVELOP,
    NONE,
    CUSTOM;

    private final static Logger LOGGER                  = Logger.getLogger(ApiUrlEnvironment.class);
    private final static String ENVIRONMENT_FILE_NAME   = "src/main/resources/config/apiUrlEnv.properties";

    String urlApi = null;

    private static ApiUrlEnvironment build(String env, boolean custom){
        LOGGER.info(String.format("Test environment :=  %s  ",env.toUpperCase()));
        if(custom){
           ApiUrlEnvironment.CUSTOM.setUrls(env);
            return ApiUrlEnvironment.CUSTOM;
        }
        return ApiUrlEnvironment.valueOf(env.toUpperCase());
    }

    public static ApiUrlEnvironment init(String env){
        return build(env,false);
    }

    public static ApiUrlEnvironment initCustom(String env){
        return build(env,true);
    }

    public void setUrls(String urlsProperties) {
        urlApi = urlsProperties;
    }

    public String getUrl(String endPoint){
        if(urlApi==null) load();
        return getUrl(urlApi, endPoint);
    }

    private String getUrl(String url, String endPoint) {
        return endPoint != null ?
                url+(url.endsWith("/")||endPoint.startsWith("/") ? "" : "/")+endPoint :
                url;
    }

    private void load(){
        try{
            Properties urlProp = new Properties();
            urlProp.load(
                    new FileInputStream(ENVIRONMENT_FILE_NAME)
            );
            urlProp.forEach((key,value)->{
                ApiUrlEnvironment.valueOf(key.toString().toUpperCase()).setUrls(value.toString());
            });

        }catch( IOException | NullPointerException e){
            LOGGER.error(String.format("Cannot load [ %s ] properties file !",ENVIRONMENT_FILE_NAME));
            throw new RuntimeException(e.getMessage());
        }
    }
}
