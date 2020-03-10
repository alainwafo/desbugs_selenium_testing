package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntreprisesCreatedPage extends Page {

    public EntreprisesCreatedPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ENTREPRSES_CREATED, container);
        table = new TableComponant(driver);
    }

    By container = By.className("");

    public enum Column{
        ENTREPRISE_NAME("Nom de l'entreprise"),
        CREATIONDATE("Date de création");

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
