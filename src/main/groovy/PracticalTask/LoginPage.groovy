package PracticalTask

import geb.Page

class LoginPage extends Page{
    static at = {
        usernameField.isDisplayed()
        passwordField.isDisplayed()
        loginButton.isDisplayed()
    }

    static content = {
        usernameField           {$("#UserUsername")}
        passwordField           {$("#UserPassword")}
        loginButton             {$(".cus-key")}
    }

    void populateUsernameField(String username) {
        usernameField << username
    }

    void populatePasswordField(String password) {
        passwordField << password
    }

    void clickLoginButton() {
        loginButton.click()
    }
}
