package fr.zenity.desbugs.classes;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static fr.zenity.desbugs.utils.RandomUtils.createParameter;

public class Bug {

    public void setDetail(DataTable dt) {
        List<Map<String, String>> detailDt = dt.asMaps(String.class, String.class);
        Map<String, String> bugDetail = detailDt.get(0);
        setWebSiteName(bugDetail.get("webSiteName"));
        setWebSiteUrl(bugDetail.get("webSiteUrl"));
        setDescription(bugDetail.get("bugDescription"));
        setOs(bugDetail.get("os"));
        setBrowser(bugDetail.get("browser"));
    }

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

    private String os;

    private String browser;

    public DeviceType getDevice() {
        return device;
    }

    public void setDevice(String deviceString) {
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

    public void setPlateform(String plateformString) {
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

    public void setWebSiteName(String webSiteName) {
        this.webSiteName = createParameter(webSiteName, true);
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = String.format("www.%s.com", createParameter(webSiteUrl, false));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = createParameter(description, true);
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = createParameter(os, false);
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser =  createParameter(browser, false);
    }
}
