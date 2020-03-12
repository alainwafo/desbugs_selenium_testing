package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntreprisesCreatedPage extends Page {


    By container = By.className("MuiContainer-root");

    By addButton = By.className("div.MuiGrid-root > button.MuiButtonBase-root");

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
        creationPopup = new EntrepriseCreationPopup(driver);
    }

    public void closeAddEntreprisePopup(){
        click(container);
        creationPopup = null;
    }
}
