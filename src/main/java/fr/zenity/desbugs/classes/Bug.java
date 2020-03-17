package fr.zenity.desbugs.classes;

import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugDeviceTypePage;
import fr.zenity.desbugs.PagesObjects.NewBugPages.NewBugPlateformPage;
import gherkin.lexer.De;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static fr.zenity.desbugs.utils.RandomUtils.createParameter;

public class Bug {

    public enum DeviceType {
        COMPUTER, PAD, SMARTPHONE;
    }

    private DeviceType device;

    public enum PlateformType {
        WEB, SOFTWARE;
    }

    private PlateformType plateform;

    private String webSiteName;

    private String webSiteUrl;

    private String description;

    //TODO : implement enum
    public enum OsType{

    }

    private OsType os;

    //TODO : implement enum
    public enum BrowserType{

    }

    private BrowserType browser;

    public DeviceType getDevice() {
        return device;
}

    private void setDevice(String deviceString) {
        try{
            this.device = DeviceType.valueOf(deviceString.toUpperCase());
        }catch(Exception e) {
            //if specified device not found, return the first one
            this.device = DeviceType.values()[0];
        }
    }

    public PlateformType getPlateform() {
        return plateform;
    }

    private void setPlateform(String plateformString) {
        try{
            this.plateform = PlateformType.valueOf(plateformString.toUpperCase());
        }catch(Exception e) {
            //if specified plateform not found, return the first one
            this.plateform = PlateformType.values()[0];
        }
    }

    public String getWebSiteName() {
        return webSiteName;
    }

    private void setWebSiteName(String webSiteName) {
        this.webSiteName = createParameter(webSiteName);
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    private void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = createParameter(webSiteUrl);
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = createParameter(description);
    }

    public OsType getOs() {
        return os;
    }

    private void setOs(String osString) {
        try{
            this.os = OsType.valueOf(osString.toUpperCase());
        }catch(Exception e) {
            //if specified plateform not found, return the first one
            this.os = OsType.values()[0];
        }
    }

    public BrowserType getBrowser() {
        return browser;
    }

    private void setBrowser(String browserString) {
        try{
            this.browser = BrowserType.valueOf(browserString.toUpperCase());
        }catch(Exception e) {
            //if specified plateform not found, return the first one
            this.browser = BrowserType.values()[0];
        }
    }

    //TODO : implement constructor
}
