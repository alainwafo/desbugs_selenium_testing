package fr.zenity.desbugs.Enum;

import com.google.common.base.Splitter;
import fr.zenity.desbugs.utils.ResourcesUtils;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public enum FrontUrlEnvironment{

    DEVELOP,
    NONE,
    CUSTOM;

    private final static Logger LOGGER                  = Logger.getLogger(ApiUrlEnvironment.class);
    private final static String ENVIRONMENT_FILE_NAME   = "src/main/resources/config/frontUrlEnv.properties";

    String urlLanding = null;
    String urlApp = null;

    private static FrontUrlEnvironment build(String env, boolean custom){
        LOGGER.info(String.format("Test environment :=  %s  ",env.toUpperCase()));
        if(custom){
           FrontUrlEnvironment.CUSTOM.setUrls(env);
            return FrontUrlEnvironment.CUSTOM;
        }
        return FrontUrlEnvironment.valueOf(env.toUpperCase());
    }

    public static FrontUrlEnvironment init(String env){
        return build(env,false);
    }

    public static FrontUrlEnvironment initCustom(String env){
        return build(env,true);
    }

    public void setUrls(String urlsProperties) {
        if(urlsProperties.equals("null"))
            urlLanding = urlApp = null;
        else if (Pattern.compile("(\\w+\\s*\\=\\s*([^\\,]+)?(\\,|))+").matcher(urlsProperties).find()){

            Map<String, String> urls = Splitter.on(",")
                                        .withKeyValueSeparator("=")
                                        .split(urlsProperties.replaceAll("\\s+", ""));
            urlLanding  = urls.get("urlLanding");
            urlApp      = urls.get("urlApp");
        }
        else
            LOGGER.error("Format error : the env parameter should respect the format \"urlLanding=.*, urlApp=.*\".");
    }

    public String getUrl(Boolean isApp, String endPoint){
        if(urlLanding==null || urlApp==null) load();
        return isApp ?
                getUrl(urlApp, endPoint) :
                getUrl(urlLanding, endPoint);
    }

    private String getUrl(String url, String endPoint) {
        return !endPoint.isEmpty() || endPoint != null ?
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
                FrontUrlEnvironment.valueOf(key.toString().toUpperCase()).setUrls(value.toString());
            });

        }catch( IOException | NullPointerException e){
            LOGGER.error(String.format("Cannot load [ %s ] properties file !",ENVIRONMENT_FILE_NAME));
            throw new RuntimeException(e.getMessage());
        }
    }
}
