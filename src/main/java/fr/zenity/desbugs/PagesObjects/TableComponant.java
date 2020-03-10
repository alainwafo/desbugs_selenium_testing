package fr.zenity.desbugs.PagesObjects;

import com.google.common.collect.Table;
import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableComponant extends Page{
    public TableComponant(WebDriver driver) {
        super(driver);
        waitVisibility(container);
    }

    By container = By.cssSelector("table.MuiTable-root");

    By headers = By.cssSelector("thead.MuiTableHead-root > tr > th.jss2681");
    By sortIcon = By.className("MuiTableSortLabel-icon");
    By cell = By.cssSelector("td.MuiTableCell-body");

    //get lines with data
    By lines = By.cssSelector("tbody.MuiTableBody-root > tr[index]");

    public void orderColumnByHeaderName(String headerName){
        getHeaderWithName(headerName).findElement(sortIcon).click();
    }

    public String getValueByColumnNameAndLineNumber(String columnName, int lineNumber){
        List<WebElement> cellList = getLineByNumber(lineNumber).findElements(cell);
        //return text conains in the given column of the line
        return cellList.get(getHeaderIndexWithName(columnName)).getText();
    }

    private WebElement getLineByNumber(int lineNumber) {
        List<WebElement>  linesList = findElements(lines);
        //if lineNumber is not between 1 and max lines number return first line
        if (lineNumber < 1 || lineNumber >= linesList.size()) { lineNumber = 1; }
        return linesList.get(lineNumber-1);
    }

    private WebElement getHeaderWithName(String headerName){
        for (WebElement header : findElements(headers)) {
            if (header.getText().equalsIgnoreCase(headerName)) {
                return header;
            }
        }
        return null;
    }

    private Integer getHeaderIndexWithName(String headerName){
        int index = 0;
        for (WebElement header : findElements(headers)) {
            if (header.getText().equalsIgnoreCase(headerName)) {
                return index;
            }
            index++;
        }
        return null;
    }
}
