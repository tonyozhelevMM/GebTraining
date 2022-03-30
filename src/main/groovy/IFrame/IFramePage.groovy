package IFrame

import geb.Page
import org.openqa.selenium.By

class IFramePage extends Page{
    static at = {
        getDriver().getCurrentUrl() == url
        pageHeading.isDisplayed()
        pageHeading.text() == "Frames And Windows"
    }

    static content = {
        pageHeading         {$(".page_heading")}
        searchBar           {$("#s")}
        searchButton        {$(".button_search")}
        facebookButton      {$(By.xpath("//*[@id=\\\"footer\\\"]/div[2]/div/div/div/div/a[5]"))}
    }

    static url = "https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame"

    void switchToGlobalSQAFrame() {
        getDriver().switchTo().frame("globalSqa")
    }

    void searchForGebBookInSearchBar() {
        searchBar << "Geb"
        searchButton.click()
    }

    void moveToFacebookButtonAndClickIt() {
        interact {
            moveToElement(facebookButton)
        }
        facebookButton.click()
    }

    void switchToFacebookTab() {
        ArrayList<String> tabs = new ArrayList<> (getDriver().getWindowHandles())
        getDriver().switchTo().window(tabs.get(1))
    }
}
