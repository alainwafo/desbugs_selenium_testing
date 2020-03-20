package fr.zenity.desbugs.classes;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static fr.zenity.desbugs.utils.RandomUtils.createParameter;

public class User {

    private enum UserType {
        ADMIN,
        ENTREPRISE,
        TESTER,
        HUNTER
    }

    public void setHunter(DataTable dt) {
        List<Map<String, String>> detailDt = dt.asMaps(String.class, String.class);
        Map<String, String> userDetail = detailDt.get(0);

        this.userType = UserType.HUNTER;
        setFirstname(userDetail.get("firstname"));
        setLastname(userDetail.get("lastname"));
        setUsername(userDetail.get("username"));
        setEmail(userDetail.get("email"));
        setPassword(userDetail.get("password"));

        if (userDetail.get("pwdConfirmation").equals(userDetail.get("password"))) {
            this.confirmPassword = this.password;
        } else {
            setConfirmPassword(userDetail.get("pwdConfirmation"));
        }

        setCguValidated(userDetail.get("cgu"));
    }

    public UserType getUserType() {
        return userType;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = createParameter(firstname, false);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = createParameter(lastname, false);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = createParameter(username, true);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String value = createParameter(email, false);
        int lenght = value.length();
        int cutLenght = lenght/2;
        this.email = String.format("%s@%s.com", value.substring(0, cutLenght), value.substring(cutLenght+1,lenght));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = createParameter(password, true);
    }

    private void setConfirmPassword(String pwdConfirmation) {
        this.confirmPassword = createParameter(pwdConfirmation, true);
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    private void setCguValidated(String cguValidated){
        this.cguValidated = false;
        if (cguValidated.equals("true") || cguValidated.equals("oui") || cguValidated.equals("yes")){
            this.cguValidated = true;
        }
    }

    public boolean isCguValidated() {
        return cguValidated;
    }

    private UserType userType;
    private String firstname;
    private String  lastname;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean cguValidated;

}
