package fr.zenity.desbugs.PagesObjects.UsersPages;

import fr.zenity.desbugs.Enum.DesbugsPage;
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

    /*@FindBy(css = "header.MuiAppBar-root > div.MuiToolbar-root > div > div > ul > li::nth-child(1) > a")
    private WebElement blogMenu;

    @FindBy(css = "header.MuiAppBar-root > div.MuiToolbar-root > div > div > ul > li::nth-child(2) > a")
    private WebElement newBugMenu;

    @FindBy(css = "header.MuiAppBar-root > div.MuiToolbar-root > div > div > ul > li::nth-child(3) > a")
    private WebElement rankingMenu;

    @FindBy(css = "header.MuiAppBar-root > div.MuiToolbar-root > div > div > ul > li::nth-child(4) > a")
    private WebElement learnMoreMenu;

    @FindBy(css = "header.MuiAppBar-root > div.MuiToolbar-root > div > div > ul > li::nth-child(5) > a.MuiButtonBase-root")
    private WebElement registerMenu;

    @FindBy(css = "header.MuiAppBar-root > div.MuiToolbar-root > div > div > ul > li::nth-child(6)")
    private WebElement loginMenu;*/

    private By blogMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.BLOG + "\"]");

    private By newBugMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.NEW_BUG + "\"]");

    private By rankingMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.RANKING + "\"]");

    private By learnMoreMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.LEARN_MORE + "\"]");

    private By registerMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.REGISTER + "\"]");

    private By loginMenuBy = By.cssSelector("a[href=\"" + DesbugsPage.LOGIN + "\"]");

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

}
