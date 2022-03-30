import DemoQA.AlertsFramesAndWindowsPage
import DemoQA.BrowserWindowsPage
import DemoQA.PracticeFormPage
import DemoQA.SelectMenuPage
import IFrame.IFramePage
import TablePress.TablePress
import geb.spock.GebReportingSpec

class BaseSpec extends GebReportingSpec {

    void setup() {
        browser.driver = browser.config.driver
        browser.go()
    }

    void cleanup() {
        driver.quit()
    }

    void navigateToPracticeFormPage() {
        driver.get(PracticeFormPage.url)
    }

    void navigateToSelectMenuPage() {
        driver.get(SelectMenuPage.url)
    }

    void navigateToAlertsPage() {
        driver.get(AlertsFramesAndWindowsPage.url)
    }

    void navigateToBrowserWindowsPage() {
        driver.get(BrowserWindowsPage.url)
    }

    void navigateToIFramePage() {
        driver.get(IFramePage.url)
    }

    void navigateToTablePress() {
        driver.get(TablePress.url)
    }
}
