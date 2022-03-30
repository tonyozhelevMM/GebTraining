package TablePress

import geb.Page
import geb.navigator.Navigator

class TablePress extends Page{
    static at = {
        tablePressInfo.isDisplayed()
        tableRows.isDisplayed()
    }

    static content = {
        tablePressInfo      {$("#tablepress-demo_info")}
        tableRows           {$(".row-hover")}
        columnOne           {$(".row-hover").find(".column-1")}
        columnTwo           {$(".row-hover").find(".column-2")}
        columnThree         {$(".row-hover").find(".column-3")}
    }

    static url = "https://tablepress.org/demo"

    void printTablePressInformation() {
        println(tablePressInfo.text())
    }

    void printTableRow() {
        println(tableRows.text())
    }

    void printLastNames() {
        for (Navigator lastName : columnTwo) {
            println(lastName.text())
        }
    }
}
