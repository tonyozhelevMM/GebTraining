package PracticalTask

import geb.Page

class HomePage extends Page{
    static at = {
        loginPageRedirect.isDisplayed()
    }

    static content = {
        loginPageRedirect         {$("#ajaxcontent > div.content.page > a")}
    }

    static url = "https://demo.vamshop.com/"

    void clickLogInRedirect() {
        loginPageRedirect.click()
    }
}
