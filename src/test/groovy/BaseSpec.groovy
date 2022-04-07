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

    void cleanupSpec() {
        driver.quit()
    }

    void navigateToPage(String url) {
        driver.get(url)
    }
}