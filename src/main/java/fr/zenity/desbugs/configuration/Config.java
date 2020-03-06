package fr.zenity.desbugs.configuration;

public interface Config {

    PropertiesConfig propConfig = PropertiesConfig.getInstance();
    PropertiesFile   propFile   = PropertiesFile.getInstance();

}
