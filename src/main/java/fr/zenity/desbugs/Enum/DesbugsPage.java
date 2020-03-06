package fr.zenity.desbugs.Enum;

public enum DesbugsPage {
    HOME("/"),
    BLOG("/blog"),
    NEW_BUG("/bugs/new"),
    RANKING("/ranking"),
    LEARN_MORE("/learn-more"),
    REGISTER("/register"),
    LOGIN("/login"),
    LOGGED_HOME("/"),
    MY_BUGS("/me/bugs"),
    MY_BUGS_DETAILS("/me/bugs/{{id}}/details"),
    MY_BUGS_FILES("/me/bugs/{{id}}/files"),
    MY_BUGS_COMMENTS("/me/bugs/{{id}}/comments"),
    USERS("/users"),
    BUGS("/bugs"),
    ENTREPRISES_VERIFY("/enterprises/verify"),
    ENTREPRSES_CREATED("/enterprises/created"),
    ENTREPRISE("/enterprises/verify/{{id}}"),
    ACCOUNT_GENERAL("/account/general"),
    ACCOUNT_IDENTIFY("/account/identifier"),
    ACCOUNT_SECURITY("/account/security");

    private String baseUrl = "https://desbugs-landing.herokuapp.com";
    private String loggedBaseUrl = "https://desbugs-app.herokuapp.com";

    private String pageUrl;

    public String getUrl(){
        switch(this){
            case HOME :
            case BLOG :
            case NEW_BUG :
            case RANKING :
            case LEARN_MORE :
                return baseUrl.concat(pageUrl);
            case REGISTER :
            case LOGIN :
            case LOGGED_HOME :
            case MY_BUGS :
            case MY_BUGS_DETAILS :
            case MY_BUGS_FILES :
            case MY_BUGS_COMMENTS :
            case USERS :
            case BUGS :
            case ENTREPRISES_VERIFY :
            case ENTREPRSES_CREATED :
            case ENTREPRISE :
            case ACCOUNT_GENERAL:
            case ACCOUNT_IDENTIFY:
            case ACCOUNT_SECURITY:
                return loggedBaseUrl.concat(pageUrl);
            default:
                return loggedBaseUrl;
        }
    }

    private DesbugsPage(String page){
            this.pageUrl = page;
    }

}