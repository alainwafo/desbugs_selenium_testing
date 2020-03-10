package fr.zenity.desbugs.driver;

import fr.zenity.desbugs.configuration.Config;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.io.File;

public interface Driver {

    WebDriver getWebDriver();
    void closeDriver();

    default ChromeOptions ChromeOptions(){
        ChromeOptions chromeOpts = new ChromeOptions();

        chromeOpts.setAcceptInsecureCerts(true)
                  .setHeadless(Config.propConfig.headless);

        if(Config.propConfig.isProxy){
            chromeOpts.setProxy(getProxy());
        }

        if(Config.propConfig.device.isRealDevice()){
            chromeOpts.addArguments("--start-maximized");
        }

        chromeOpts.addArguments("--enable-automation");
        chromeOpts.addArguments("--no-sandbox");
        chromeOpts.addArguments("--disable-infobars");
        chromeOpts.addArguments("--disable-browser-side-navigation");
        chromeOpts.addArguments("--disable-gpu");
        chromeOpts.setCapability("acceptSslCerts",true);

        return chromeOpts;
    }

    default FirefoxOptions FirefoxOptions( ){
        FirefoxOptions firefoxOpts    = new FirefoxOptions();
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile.setPreference("geo.prompt.testing", true);
        firefoxProfile.setPreference("geo.prompt.testing.allow", true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
        firefoxProfile.setAcceptUntrustedCertificates(true);

        firefoxOpts.setAcceptInsecureCerts(true)
                   .setHeadless(Config.propConfig.headless);

        if(Config.propConfig.isProxy){
            firefoxOpts.setProxy(getProxy());
           firefoxProfile.setPreference("network.proxy.no_proxies_on","localhost, 127.0.0.1");
        }

        firefoxOpts.setCapability("AcceptSslCerts",true);
        return firefoxOpts;
    }

    default OperaOptions OperaOptions(){
        OperaOptions operaOpts = new OperaOptions();

        operaOpts.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        operaOpts.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        //operaOpts.addExtensions(new File[]{(new File(Config.propConfig.extensionPath))});

        if(Config.propConfig.isProxy){
            operaOpts.setProxy(getProxy());
        }

        return operaOpts;
    }

    default EdgeOptions EdgeOptions(){
        EdgeOptions edgeOpts = new EdgeOptions();

        if(Config.propConfig.isProxy){
            edgeOpts.setProxy(getProxy());
        }

        // Unsupported for this moment
        edgeOpts.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        edgeOpts.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);

        return edgeOpts;
    }

    default Proxy getProxy(){
        String proxy = Config.propFile.get("proxy.config");
    return (new Proxy()).setHttpProxy(proxy)
            .setSslProxy(proxy)
            .setFtpProxy(proxy);
    }

}
