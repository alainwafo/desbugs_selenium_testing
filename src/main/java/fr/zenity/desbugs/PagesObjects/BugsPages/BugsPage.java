package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.MyBugsPages.MyBugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugsPage extends Page {

    By container = By.className("MuiContainer-root");

    public enum Column{
        APPLICATION_NAME("Nom du site/application"),
        STATUS("Statut"),
        CRITICITY("Criticité"),
        MODIFICATION_DATE("Modifié le"),
        CREATIONDATE("Créé le");

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

    public void getValueByColumnNameAndLineNumber(Column columnName, int lineNumber){
        table.getValueByColumnNameAndLineNumber(columnName.get(), lineNumber);
    }
}
