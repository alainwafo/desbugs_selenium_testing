package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntreprisesVerifyPage extends Page {

    By container = By.className("MuiGrid-container");

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