package PracticalTask

import geb.Page

class ContentPage extends Page{
    static at = {
        createNewButton.isDisplayed()
    }

    static content = {
        createNewButton             {$(".cus-add")}
    }

    void clickCreateNewButton() {
        createNewButton.click()
    }
}
