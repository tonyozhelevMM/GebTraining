package amazon

import geb.Page

class AmazonSignInPasswordPage extends Page{
    static at = {
        signInText.isDisplayed()
        signInText.text() == "Sign-In"
        passwordInputField.isDisplayed()
    }

    static content = {
        signInText                  {$("h1")}
        passwordInputField          {$("#ap_password")}
        signInButton                {$("#signInSubmit")}
    }

    void fillPasswordInputField(String input) {
        passwordInputField << input
    }

    void clickSignInButton() {
        signInButton.click()
    }
}
