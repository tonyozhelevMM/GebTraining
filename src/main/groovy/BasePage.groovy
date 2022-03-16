import geb.Page
import geb.waiting.Wait
import org.openqa.selenium.By

class BasePage extends Page {

    static at = {
        elementsLink.isDisplayed()
        formsLink.isDisplayed()
        alertsFramesLink.isDisplayed()
    }

    static content = {
        elementsLink                {$(By.xpath("//h5[text() = 'Elements']"))}
        formsLink                   {$(By.xpath("//h5[text() = 'Forms']"))}
        alertsFramesLink            {$(By.xpath("//h5[text() = 'Alerts, Frame & Windows']"))}
    }

    void clickElementsLink(){
        elementsLink.click()
    }

    void clickFormLink(){
        formsLink.click()
    }

    void clickAlertsFramesLink(){
        alertsFramesLink.click()
    }

    // BROWSER ACTIONS

    void clickBrowserBackButton(){
        getDriver().navigate().back()
        Wait.sleep(500)
    }

    void refreshTheBrowser(){
        getDriver().navigate().refresh()
        Wait.sleep(500)
    }
}
