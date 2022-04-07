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

    void assertTablePressInformationIsDisplayed() {
        assert tablePressInfo.text() != null
    }

    void assertTableRowIsNotEmpty() {
        assert tableRows.text() != null
    }

    void assertLastNamesAreDisplayed() {
        for (Navigator lastName : columnTwo) {
            assert lastName.text() != null
        }
    }
}
