package PracticalTask

import geb.Page

class DashboardPage extends Page{
    static at = {
        pageName.isDisplayed()
        categoriesAndProducts.isDisplayed()
    }

    static content = {
        pageName                    {$("#hoe-header > div.hoe-right-header.affix-top > ul.left-navbar.breadcrumb > li")}
        categoriesAndProducts       {$("#pageContent > div:nth-child(3) > div > div > div.panel-body.text-left > a:nth-child(3)")}
    }

    void clickCategoriesAndProducts() {
        categoriesAndProducts.click()
    }
}
