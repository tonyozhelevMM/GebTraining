package PracticalTask

import geb.Page

class TabletsPage extends Page{
    static at = {
        newProductName.isDisplayed()
    }

    static content = {
        newProductName              {$("#ContentAdminForm > table > tbody > tr:nth-child(11) > td:nth-child(1) > a")}
    }

}
