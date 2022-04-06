package IFrame

import geb.Page
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

class IFramePage extends Page{
    static at = {
        pageHeading.isDisplayed()
        pageHeading.text() == "Frames And Windows"
    }

    static content = {
        pageHeading         {$(".page_heading")}
        searchBar           {$("#s")}
        searchButton        {$(".button_search")}
        facebookButton      {$(".icon_facebook")}
        facebookPageName    {$(By.xpath(".//h1[contains(text(), 'Globalsqa')]"))}
    }

    static url = "https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame"

    void switchToGlobalSQAFrame() {
        getDriver().switchTo().frame("globalSqa")
    }

    void searchForGebBookInSearchBar(String input) {
        searchBar << input
        searchButton.click()
    }

    void moveToFacebookButtonAndClickIt() {
        interact {
            moveToElement(facebookButton)
        }
        facebookButton << Keys.ENTER
    }

    void switchToFacebookTab() {
        ArrayList<String> tabs = new ArrayList<> (getDriver().getWindowHandles())
        getDriver().switchTo().window(tabs.get(1))
    }

    void assertFacebookPageName() {
        waitFor {
            ExpectedConditions.visibilityOf(facebookPageName as WebElement)
        }

        assert facebookPageName.text() == "Globalsqa"
    }
}
