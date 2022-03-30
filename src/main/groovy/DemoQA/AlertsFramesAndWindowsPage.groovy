package DemoQA

import geb.Page
import org.openqa.selenium.Alert
import org.openqa.selenium.support.ui.ExpectedConditions

class AlertsFramesAndWindowsPage extends Page {
    static at = {
        getDriver().getCurrentUrl() == url
        mainHeader.isDisplayed()
        mainHeader.text() == "Alerts"
    }

    static content = {
        mainHeader          {$(".main-header")}
        confirmButton       {$("#confirmButton")}
    }

    static url = "https://demoqa.com/alerts"

    void clickConfirmButton() {
        confirmButton.click()
    }

    void acceptPopUpAlert() {
        waitFor() {
            ExpectedConditions.alertIsPresent()
        }
        Alert alert = getDriver().switchTo().alert()
        alert.accept()
    }

    void dismissPopUpAlert() {
        waitFor() {
            ExpectedConditions.alertIsPresent()
        }
        Alert alert = getDriver().switchTo().alert()
        alert.dismiss()
    }
}
