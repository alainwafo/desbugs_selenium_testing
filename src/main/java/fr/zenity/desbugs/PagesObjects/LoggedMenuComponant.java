package fr.zenity.desbugs.PagesObjects;

import fr.zenity.desbugs.Enum.DesbugsPage;
import org.openqa.selenium.By;

public class LoggedMenuComponant extends Page {

    public enum Menu{
        DASHBOARD,
        USERS,
        NEW_BUG,
        MY_BUGS,
        ENTREPRISES_WAITTING,
        ENTREPRISES_VALIDATED,
        ACCOUNT,
        LOGOUT
    }

    private By dashboardMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.LOGGED_HOME.value() + "\"]");

    private By usersMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.USERS.value() + "\"]");

    private By newBugMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.NEW_BUG.value() + "\"]");

    private By myBugsMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.MY_BUGS.value() + "\"]");

    private By entrepriseWaittingMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.ENTREPRISES_VERIFY.value() + "\"]");

    private By entreprisesValidatedMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.ENTREPRSES_CREATED.value() + "\"]");

    private By accountMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.ACCOUNT_GENERAL.value() + "\"]");

    private By logoutMenuBy = By.cssSelector("div.MuiPaper-root.MuiDrawer-paper > button");

    public void clickMenu(Menu menu){
        By by = null;
        switch (menu){
            case DASHBOARD:
                by = dashboardMenuBy;
                break;
            case USERS:
                by = usersMenuBy;
                break;
            case NEW_BUG:
                by = newBugMenuBy;
                break;
            case MY_BUGS:
                by = myBugsMenuBy;
                break;
            case ENTREPRISES_WAITTING:
                by = entrepriseWaittingMenuBy;
                break;
            case ENTREPRISES_VALIDATED:
                by = entreprisesValidatedMenuBy;
                break;
            case ACCOUNT:
                by = accountMenuBy;
                break;
            case LOGOUT:
                by = logoutMenuBy;
                break;
        }
        click(driver.findElement(by));
    }

    public void clickMenu(String menu) {
        try{
            clickMenu(Menu.valueOf(menu));
        }catch(Exception e){
            LOGGER.error(String.format("The menu \"%s\" does not exist.",menu));
        }
    }
}
