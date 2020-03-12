package fr.zenity.desbugs.Enum;

import fr.zenity.desbugs.configuration.PropertiesConfig;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

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
    MY_BUGS_DETAILS("/me/bugs/%s/details"),
    MY_BUGS_FILES("/me/bugs/%s/files"),
    MY_BUGS_COMMENTS("/me/bugs/%s/comments"),
    USERS("/users"),
    BUGS("/bugs"),
    ENTREPRISES_VERIFY("/enterprises/verify"),
    ENTREPRSES_CREATED("/enterprises/created"),
    ENTREPRISE("/enterprises/verify/%s"),
    ACCOUNT_GENERAL("/account/general"),
    ACCOUNT_IDENTIFY("/account/identifier"),
    ACCOUNT_SECURITY("/account/security");

    private String pageUrl;

    public String getUrl(String ... args){
        AtomicReference<String> urlA = new AtomicReference<>(null);

        switch(this){
            case HOME :
            case BLOG :
            case NEW_BUG :
            case RANKING :
            case LEARN_MORE :
                urlA.set(PropertiesConfig.getInstance().env.getUrl( false, pageUrl));
                break;
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
                urlA.set(PropertiesConfig.getInstance().env.getUrl( true, pageUrl));
                break;
            default:
                urlA.set(PropertiesConfig.getInstance().env.getUrl( false,null));
                break;
        }

        if( args.length > 0 ){

            Arrays.asList(args)
            .stream()
            .forEach(elementValue->{
                urlA.set( String.format( urlA.get(), elementValue ) );
            });
        }

        return urlA.get();
    }

    private DesbugsPage(String page){
            this.pageUrl = page;
    }

}
