package DemoQA

import geb.Page

class BrowserWindowsPage extends Page{
    static at = {
        mainHeader.isDisplayed()
        mainHeader.text() == "Browser Windows"
    }

    static content = {
        mainHeader                      {$(".main-header")}
        newWindowButton                 {$("#windowButton")}
        sampleTextFromNewWindow         {$"#sampleHeading"}
    }

    static url = "https://demoqa.com/browser-windows"

    void clickNewWindowButton() {
        newWindowButton.click()
    }

    void switchToNewWindow() {
        ArrayList<String> windows = new ArrayList<> (getDriver().getWindowHandles())
        getDriver().switchTo().window(windows.get(1))
    }

    void assertTextFromNewWindowIsCorrect() {
        assert sampleTextFromNewWindow.text() == "This is a sample page"
    }
}
