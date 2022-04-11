package PracticalTask

import geb.Page
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

class EditProductPage extends Page{
    static at = {
        contentParentSelect.isDisplayed()
    }

    static content = {
        productTitleLocator                         {$("#ContentDescription\\]\\[1\\]\\[name1")}
        productDescriptionLocator                   {$("#tinymce")}
        shortenedProductDescriptionLocator          {$("#tinymce")}
        dataTabSelector                             {$("#myTab > li:nth-child(2) > a > i")}
        productLabelSelector                        {$("#ContentProductLabelId")}
        contentTableLocator                         {$(".contentTable")}
        checkboxLocator                             {$("#ContentModify][")}
        dropdownDivLocator                          {$(".multiAction")}
        dropdownMenuLocator                         {$("#multiaction")}
        contentParentSelect                         {$("#ContentParentId")}
        productLableText                            {$("#content_type_fields > div:nth-child(14) > label")}
        submitButton                                {$("#submitbutton > i")}
    }

    void selectContentTablet() {
        waitFor {
            ExpectedConditions.elementToBeClickable(contentParentSelect as WebElement)
        }

        contentParentSelect.find("option").find{it.value() == "36"}.click()
    }

    void setNameForTheTablet(String tabletName) {
        productTitleLocator << tabletName
    }

    void fillDescription(String description) {
        getDriver().switchTo().frame("content_description_1_ifr")
        productDescriptionLocator << description
        getDriver().switchTo().defaultContent()
    }

    void fillShortenedDescription(String shortenedDescription) {
        getDriver().switchTo().frame("content_short_description_1_ifr")
        shortenedProductDescriptionLocator << shortenedDescription
        getDriver().switchTo().defaultContent()
    }

    void switchToDataTab() {
        interact {
            moveToElement(dataTabSelector)
        }
        dataTabSelector.click()

        waitFor {
            ExpectedConditions.visibilityOf(productLableText as WebElement)
        }
    }

    void selectNewFromProductLabel() {
        productLabelSelector.find("option").find{it.value() == "1"}.click()
    }

    void clickSubmitButton() {
        submitButton.click()
    }
}
