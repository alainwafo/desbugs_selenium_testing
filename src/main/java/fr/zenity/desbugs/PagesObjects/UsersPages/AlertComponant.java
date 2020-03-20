package fr.zenity.desbugs.PagesObjects.UsersPages;

import fr.zenity.desbugs.PagesObjects.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class AlertComponant extends Page {

    private static By errorMessageBy = By.className("Mui-error");

    private static By alertMessageBy = By.cssSelector("div.MuiSnackbarContent-root[role=\"alert\"]");

    private static String newBugValidationMessage = "Le bug a été signalé";

    private static String registerValidationMessage = "";

    public static boolean isErrorMessageDisplayed() {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(errorMessageBy));
    }

    private static boolean isAlertMessageDisplayed(String message) {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(alertMessageBy)) &&
                driver.findElement(alertMessageBy).getText().equals(message);
    }

    public static boolean isNewBugValidationMessageDisplayed(){
        return isAlertMessageDisplayed(newBugValidationMessage);
    }

    public static boolean isRegisterValidationMessageDisplayed() {
        return isAlertMessageDisplayed(registerValidationMessage);
    }
}
