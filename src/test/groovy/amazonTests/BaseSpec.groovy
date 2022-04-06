package amazonTests

import geb.spock.GebReportingSpec

class BaseSpec extends GebReportingSpec {
    void setup(){
        browser.driver = browser.config.driver
        browser.go()
    }

    void cleanup(){
        driver.quit()
    }

    void navigateToPage(String url) {
        driver.get(url)
    }
}
