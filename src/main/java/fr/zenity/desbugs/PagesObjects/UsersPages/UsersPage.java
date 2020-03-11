package fr.zenity.desbugs.PagesObjects.UsersPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.MyBugsPages.MyBugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.PagesObjects.TableComponant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends Page {

    public UsersPage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.RANKING, container);
        table = new TableComponant(driver);
    }

    @FindBy(className = "jss2")
    private WebElement  container ;

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
