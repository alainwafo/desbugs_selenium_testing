package fr.zenity.desbugs.PagesObjects.MyBugsPages;

import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.PagesObjects.TableComponant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBugsPage extends Page {

    @FindBy(className = "MuiContainer-root")
    private WebElement container ;

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
