package fr.zenity.desbugs.config;

import fr.zenity.desbugs.utils.ResourcesUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    private static final Logger LOGGER              = Logger.getLogger(Properties.class);
    private static final PropertiesFile INSTANCE    = new PropertiesFile();

    private static final String PROPERTY_FILE_NAME  = "config/test1.properties";
    private Properties prop = null;

    public PropertiesFile( ){

      try{
            (prop = new Properties())
            .load(
                   ResourcesUtils.getStreamResources(PROPERTY_FILE_NAME)
            );
      }catch(IOException | java.lang.NullPointerException e){
          LOGGER.error(String.format("Cannot load %s properties file !",PROPERTY_FILE_NAME));
          throw new RuntimeException(e.getMessage());
      }

    }

    public String get(String key){
        if( prop.getProperty(key) == null ){
            LOGGER.warn("[ "+key+" ] property doesn't exists !");
        }
        return prop.getProperty(key);
    }

    public String get(String key, String defaultValue){
        String ret;
        return  ( ret = get(key) ) == null ? defaultValue : ret;
    }

    public Boolean getBool(String key){ return Boolean.valueOf(get(key)); }

    public static final PropertiesFile getInstance(){ return INSTANCE; }

}
