package fr.zenity.desbugs.PagesObjects.LandingPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
import fr.zenity.desbugs.PagesObjects.LoggedMenuComponant;
import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;

public class LandingMenuComponant extends Page {

    public enum Menu{
        BLOG,
        NEW_BUG,
        RANKING,
        LEARN_MORE,
        REGISTER,
        LOGIN
    }

    private By blogMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.BLOG.value() + "\"]");

    private By newBugMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.NEW_BUG.getUrl() + "\"]");

    private By rankingMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.RANKING.value() + "\"]");

    private By learnMoreMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.LEARN_MORE.value() + "\"]");

    private By registerMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.REGISTER.getUrl() + "\"]");

    private By loginMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.LOGIN.getUrl() + "\"]");

    public void clickMenu(Menu menu){
        By by = null;
        switch (menu){
            case BLOG:
                by = blogMenuBy;
                break;
            case NEW_BUG:
                by = newBugMenuBy;
                break;
            case RANKING:
                by = rankingMenuBy;
                break;
            case LEARN_MORE:
                by = learnMoreMenuBy;
                break;
            case REGISTER:
                by = registerMenuBy;
                break;
            case LOGIN:
                by = loginMenuBy;
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
