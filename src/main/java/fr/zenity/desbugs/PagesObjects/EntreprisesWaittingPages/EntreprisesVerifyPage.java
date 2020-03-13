package fr.zenity.desbugs.PagesObjects.EntreprisesWaittingPages;

import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.PagesObjects.TableComponant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntreprisesVerifyPage extends Page {

    @FindBy(className = "MuiGrid-container")
    private WebElement container ;

    public enum Column{
        ENTREPRISE_NAME("Nom de l'entreprise"),
        EMAIL("Email"),
        USERNAME("Identifiant"),
        FISTNAME("Prénom"),
        LASTNAME("Nom");

        private String columnText;

        private String get(){ return columnText; }

        private Column(String text){
            this.columnText = text;
        }
    }

    private TableComponant table;

    public void orderColumnByHeaderName(Column columnName){
        table.orderColumnByHeaderName(columnName.get());
    }

    public String getValueByColumnNameAndLineNumber(Column columnName, int lineNumber){
        return table.getValueByColumnNameAndLineNumber(columnName.get(), lineNumber);
    }

    public void clickLineByLineNumber(int lineNumber){
        table.clickLineByLineNumber(lineNumber);
    }

    public void clickLineByColumnValue(String columnName, String searchValue){
        table.clickLineByColumnValue(columnName, searchValue);
    }

}
