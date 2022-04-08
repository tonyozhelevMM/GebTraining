package amazon

import geb.Page

class AmazonSignInPhoneOrEmailPage extends Page{
    static at = {
        signInText.isDisplayed()
        signInText.text() == "Sign-In"
    }

    static content = {
        signInText                  {$("h1")}
        phoneOrEmailInputField      {$("#ap_email")}
        continueButton              {$(".a-button-input")}
    }

    void fillPhoneOrEmailInputField(String input) {
        phoneOrEmailInputField << input
    }

    void clickContinueButton() {
        continueButton.click()
    }
}
