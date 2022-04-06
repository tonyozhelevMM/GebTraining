package amazon

import geb.Page
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

class AmazonBasePage extends Page{
    static at = {
        navigationToolsAccountList.isDisplayed()
    }

    static content = {
        navigationToolsAccountList          {$("#nav-link-accountList-nav-line-1")}
        browsingHistoryButton               {$("#nav-recently-viewed")}
        yourProfileButton                   {$("#nav-subnav > a:nth-child(5) > span")}
    }

    static url = "https://www.amazon.com/"

    void clickAccountList() {
        navigationToolsAccountList.click()
    }

    boolean isLoggedIn(String userName) {
        return navigationToolsAccountList.text() == "Hello, " + userName
    }

    void clickBrowsingHistory() {
        browsingHistoryButton.click()

        waitFor {
            ExpectedConditions.visibilityOf(yourProfileButton as WebElement)
        }
    }

    void clickYourProfileButton() {
        yourProfileButton.click()
    }
}
