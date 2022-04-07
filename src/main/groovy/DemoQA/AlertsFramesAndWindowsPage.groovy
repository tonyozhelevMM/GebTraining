package DemoQA

import geb.Page
import org.openqa.selenium.Alert
import org.openqa.selenium.support.ui.ExpectedConditions

class AlertsFramesAndWindowsPage extends Page {
    static at = {
        mainHeader.isDisplayed()
        mainHeader.text() == "Alerts"
    }

    static content = {
        mainHeader          {$(".main-header")}
        confirmButton       {$("#confirmButton")}
        afterAlertText      {$("#confirmResult")}
    }

    static url = "https://demoqa.com/alerts"

    void clickConfirmButton() {
        confirmButton.click()
    }

    Alert switchToAlert() {
        waitFor() {
            ExpectedConditions.alertIsPresent()
        }
        return getDriver().switchTo().alert()
    }

    void acceptPopUpAlert() {
        Alert alert = switchToAlert()
        alert.accept()
    }

    void dismissPopUpAlert() {
        Alert alert = switchToAlert()
        alert.dismiss()
    }

    boolean youAcceptedTheAlert() {
        return afterAlertText.isDisplayed() && afterAlertText.text() == "You selected Ok"
    }

    boolean youDismissedTheAlert() {
        return afterAlertText.isDisplayed() && afterAlertText.text() == "You selected Cancel"
    }
}
