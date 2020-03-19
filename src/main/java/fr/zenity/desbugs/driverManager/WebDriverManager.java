package fr.zenity.desbugs.driverManager;


import fr.zenity.desbugs.configuration.Config;
import fr.zenity.desbugs.driver.LocalDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public final class WebDriverManager {

    //private final static WebDriverManager INSTANCE = new WebDriverManager();

    private static ThreadLocal<LocalDriver> driver = new ThreadLocal<>();

    public static WebDriver getWebDriver( ){
        return driver.get().getWebDriver();
    }

    public static void initWebDriver(){
        driver.set(new LocalDriver());
        setWindowSize();
    }

    private WebDriverManager(){}

    /*public static WebDriverManager getInstance( ){
        return INSTANCE;
    }*/

    private static void setWindowSize(){
        WebDriver.Window window = getWebDriver().manage().window();

        /***
        * Real device like desktop
        */
        if( Config.propConfig.device.isRealDevice() ){
           if(Config.propConfig.headless){
               window.setPosition(new Point(0,0));
           }
           window.maximize();

        /***
        * specific device
        */
        }else{
            window.setSize(new Dimension(
                    Config.propConfig.device.getWidth(),
                    Config.propConfig.device.getHeight()
            ));
        }

    }
}
