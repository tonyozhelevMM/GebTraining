package practicalTestPackage

import PracticalTask.ContentPage
import PracticalTask.DashboardPage
import PracticalTask.HomePage
import PracticalTask.LoginPage
import PracticalTask.EditProductPage
import PracticalTask.TabletsPage
import regularlyUsed.BaseSpec

class practicalTaskSpec extends BaseSpec {
    void "clickTextThatRedirectsYouToLoginPage"() {
        given: "You navigate to the correct page"
            navigateToPage(HomePage.url)
            HomePage homePage = at HomePage
        when: "You click the text that redirects you"
            homePage.clickLogInRedirect()
        then: "You expect to be on login page"
            at LoginPage
        when: "We are on the login page"
            LoginPage loginPage = at LoginPage
            loginPage.populateUsernameField("admin")
            loginPage.populatePasswordField("password")
            loginPage.clickLoginButton()
        then:
            at DashboardPage
        when:
            DashboardPage dashboardPage = at DashboardPage
            dashboardPage.clickCategoriesAndProducts()
        then:
            at ContentPage
        when:
            ContentPage contentPage = at ContentPage
            contentPage.clickCreateNewButton()
        then:
            at EditProductPage
        when:
            EditProductPage editProductPage = at EditProductPage
            editProductPage.selectContentTablet()
            editProductPage.setNameForTheTablet("GoldenTablet")
            editProductPage.fillDescription("Tablet tablet")
            editProductPage.fillShortenedDescription("Tablet")
            editProductPage.switchToDataTab()
            editProductPage.selectNewFromProductLabel()
            editProductPage.clickSubmitButton()
        then:
            at TabletsPage
    }

}
