package fr.zenity.desbugs.PagesObjects.UsersPages;

import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.PagesObjects.TableComponant;
import org.openqa.selenium.By;

public class UsersPage extends Page {

    By container = By.className("jss2");

    public enum Column{
        EMAIL("Email"),
        USERNAME("Identifiant"),
        FISTNAME("Prénom"),
        LASTNAME("Nom"),
        ROLE("Role");

        private String columnText;

        public String get(){ return columnText; }

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
