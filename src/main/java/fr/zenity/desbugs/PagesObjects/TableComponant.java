package fr.zenity.desbugs.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableComponant extends Page {
    public TableComponant(WebDriver driver) {
        super(driver);
        waitVisibility(container);
    }

    By container = By.cssSelector("table.MuiTable-root");

    By headersContainer = By.cssSelector("thead.MuiTableHead-root > tr > th");
    By sortIconContainer = By.className("MuiTableSortLabel-icon");
    By cellContainer = By.cssSelector("td.MuiTableCell-body");

    //get lines with data
    By linesContainer = By.cssSelector("tbody.MuiTableBody-root > tr[index]");

    public void orderColumnByHeaderName(String headerName) {
        getHeaderWithName(headerName).findElement(sortIconContainer).click();
    }

    public String getValueByColumnNameAndLineNumber(String columnName, int lineNumber) {
        return getCellByColumnNameAndLineNumber(columnName, lineNumber).getText();
    }

    public void clickLineByLineNumber(int lineNumber) {
        getLineByNumber(lineNumber).click();
    }

    public void clickLineByColumnValue(String columnName, String searchValue) {
        getCellByColumnValue(columnName, searchValue).click();
    }

    private WebElement getLineByNumber(int lineNumber) {
        List<WebElement> linesList = findElements(linesContainer);
        //if lineNumber is not between 1 and max lines number return first line
        if (lineNumber < 1 || lineNumber > linesList.size()) {
            lineNumber = 1;
        }
        return linesList.get(lineNumber - 1);
    }

    private WebElement getHeaderWithName(String headerName) {
        for (WebElement header : findElements(headersContainer)) {
            if (header.getText().equalsIgnoreCase(headerName)) {
                return header;
            }
        }
        return null;
    }

    private Integer getHeaderIndexWithName(String headerName) {
        int index = 0;
        for (WebElement header : findElements(headersContainer)) {
            if (header.getText().equalsIgnoreCase(headerName)) {
                return index;
            }
            index++;
        }
        return null;
    }

    private WebElement getCellByColumnNameAndLineNumber(String columnName, int lineNumber) {
        List<WebElement> cellList = getLineByNumber(lineNumber).findElements(cellContainer);
        //return text conains in the given column of the line
        return cellList.get(getHeaderIndexWithName(columnName));
    }

    private WebElement getCellByColumnValue(String columnName, String searchValue) {
        int headerIndex = getHeaderIndexWithName(columnName);
        List<WebElement> linesList = findElements(linesContainer);
        //for each line of the table
        for (WebElement line : linesList) {
            WebElement cell = line.findElements(cellContainer).get(headerIndex);
            //if the text of cell of the header id equals the searched text
            if (cell.getText().equalsIgnoreCase(searchValue)){
                return cell;
            }
        }
        return null;
    }
}
