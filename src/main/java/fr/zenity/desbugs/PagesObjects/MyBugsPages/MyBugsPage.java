package fr.zenity.desbugs.PagesObjects.MyBugsPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.PagesObjects.TableComponant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Dictionary;

public class MyBugsPage extends Page {

    public MyBugsPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.MY_BUGS, container);
        table = new TableComponant(driver);
    }

    By container = By.className("jss2450");

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
