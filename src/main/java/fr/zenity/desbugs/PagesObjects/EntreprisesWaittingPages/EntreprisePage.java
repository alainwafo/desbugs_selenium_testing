package fr.zenity.desbugs.PagesObjects.EntreprisesWaittingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EntreprisePage extends Page {

    @FindBy(className = "MuiGrid-container")
    private WebElement  container ;

    //TODO check selectors
    @FindBy(className = "jss4691")
    private WebElement  returnButton ;

    @FindBy(className = "div.jss4715 > button")
    private WebElement  addEntrepriseButton ;

    @FindBy(className = "jss4826")
    private WebElement  entrepriseInput ;

    @FindBy(className = "ul[aria-labelledby=\"enterprise-label\"] > li")
    private List<WebElement>  entrepriseList ;

    @FindBy(className = "jss4827")
    private WebElement  submitButton ;
    @FindBy(className = "jss4721")
    private WebElement  cancelButton ;

    public void openEntrepriseList(){
        click(entrepriseInput);
    }

    public void selectEnpriseInListByPosition(int index){
        if (index < 1 || index > entrepriseList.size()) {
            index = 1;
        }
        entrepriseList.get(index-1).click();
    }

    public void selectEntrepriseByName(String name) {
            for (WebElement entreprise : entrepriseList) {
                if (entreprise.getText().equalsIgnoreCase(name)) {
                    entreprise.click();
                    return;
                }
            }
    }

    public void submitForm(){
        click(submitButton);
    }

    public void cancelForm(){
        click(cancelButton);
    }

}
