package fr.zenity.desbugs.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TableComponant extends Page {

    @FindBy(css = "table.MuiTable-root")
    private WebElement  container ;

    @FindBy(css = "thead.MuiTableHead-root > tr > th")
    private List<WebElement> headersContainer ;

    private By sortIconBy = By.className("MuiTableSortLabel-icon");

    private By cellBy = By.cssSelector("td.MuiTableCell-body");

    //get lines with data
    @FindBy(css = "tbody.MuiTableBody-root > tr[index]")
    private List<WebElement> linesContainer ;

    public void orderColumnByHeaderName(String headerName) {
        getHeaderWithName(headerName).findElement(sortIconBy).click();
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
        //if lineNumber is not between 1 and max lines number return first line
        if (lineNumber < 1 || lineNumber > linesContainer.size()) {
            lineNumber = 1;
        }
        return linesContainer.get(lineNumber - 1);
    }

    private WebElement getHeaderWithName(String headerName) {
        for (WebElement header : headersContainer) {
            if (header.getText().equalsIgnoreCase(headerName)) {
                return header;
            }
        }
        return null;
    }

    private Integer getHeaderIndexWithName(String headerName) {
        int index = 0;
        for (WebElement header : headersContainer) {
            if (header.getText().equalsIgnoreCase(headerName)) {
                return index;
            }
            index++;
        }
        return null;
    }

    private WebElement getCellByColumnNameAndLineNumber(String columnName, int lineNumber) {
        List<WebElement> cellList = getLineByNumber(lineNumber).findElements(cellBy);
        //return text conains in the given column of the line
        return cellList.get(getHeaderIndexWithName(columnName));
    }

    private WebElement getCellByColumnValue(String columnName, String searchValue) {
        int headerIndex = getHeaderIndexWithName(columnName);
        //for each line of the table
        for (WebElement line : linesContainer) {
            WebElement cell = line.findElements(cellBy).get(headerIndex);
            //if the text of cell of the header id equals the searched text
            if (cell.getText().equalsIgnoreCase(searchValue)){
                return cell;
            }
        }
        return null;
    }
}
