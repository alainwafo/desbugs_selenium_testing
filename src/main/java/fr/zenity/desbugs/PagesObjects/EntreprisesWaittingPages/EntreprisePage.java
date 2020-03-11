package fr.zenity.desbugs.PagesObjects.EntreprisesWaittingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.EntreprisesPages.EntrepriseCreationPopup;
import fr.zenity.desbugs.PagesObjects.MyBugsPages.MyBugsPage;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EntreprisePage extends Page {

    public EntreprisePage(WebDriver driver) {
        super(driver);
        init(DesbugsPage.ENTREPRISE, container);
    }

    By container = By.className("MuiGrid-container");

    //TODO check selectors
    By returnButton = By.className("jss4691");

    By addEntrepriseButton = By.className("div.jss4715 > button");

    By entrepriseInput = By.className("jss4826");

    By entrepriseList = By.className("ul[aria-labelledby=\"enterprise-label\"] > li");

    By submitButton = By.className("jss4827");
    By cancelButton = By.className("jss4721");

    public void openEntrepriseList(){
        click(entrepriseInput);
    }

    public void selectEnpriseInListByPosition(int index){
        List<WebElement> entreprises = findElements(entrepriseList);
        if (index < 1 || index > entreprises.size()) {
            index = 1;
        }
        findElements(entrepriseList).get(index-1).click();
    }

    public void selectEntrepriseByName(String name) {
            List<WebElement> entreprises = findElements(entrepriseList);
            for (WebElement entreprise : entreprises) {
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
