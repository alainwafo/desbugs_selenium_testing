package fr.zenity.desbugs.PagesObjects.EntreprisesPages;

import fr.zenity.desbugs.PagesObjects.Page;
import fr.zenity.desbugs.PagesObjects.TableComponant;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntreprisesCreatedPage extends Page {


    @FindBy(className = "MuiContainer-root")
    private WebElement container ;

    @FindBy(className = "div.MuiGrid-root > button.MuiButtonBase-root")
    private WebElement  addButton ;

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

    private EntrepriseCreationPopup creationPopup;

    public void orderColumnByHeaderName(Column columnName){
        table.orderColumnByHeaderName(columnName.get());
    }

    public void getValueByColumnNameAndLineNumber(Column columnName, int lineNumber){
        table.getValueByColumnNameAndLineNumber(columnName.get(), lineNumber);
    }

    public void openAddEntreprisePopup(){
        click(addButton);
        creationPopup = new EntrepriseCreationPopup();
    }

    public void closeAddEntreprisePopup(){
        click(container);
        creationPopup = null;
    }
}
