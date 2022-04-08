package alertsFramesAndTables

import DemoQA.AlertsFramesAndWindowsPage
import DemoQA.BasePage
import DemoQA.BrowserWindowsPage
import DemoQA.FormsPage
import DemoQA.PracticeFormPage
import DemoQA.SelectMenuPage
import IFrame.IFramePage
import TablePress.TablePress
import regularlyUsed.BaseSpec

class AlertsFramesAndTablesSpec extends BaseSpec {

    void "navigateToPracticeFormPageTest"() {
        given: "User is on Base Page"
            BasePage basePage = at BasePage
        when: "User clicks the Form Link"
            basePage.clickFormLink()
        then: "Verify User is on Forms Page"
            FormsPage formsPage = at FormsPage
        when: "User clicks Practice Form Link"
            formsPage.clickPracticeFormLink()
        then: "Verify User is on Practice Form Page"
            at PracticeFormPage
    }

    void "fillOutFormTest"() {
        given: "User is on the Practice Form Page"
            navigateToPage(PracticeFormPage.url)
            PracticeFormPage practiceFormPage = at PracticeFormPage
        when: "Fill out the form"
            sleep(30)
        then: "Verify something"
            sleep(30)
    }

    void "selectRandomColorFromDropdownMenu"(){
        given: "User is on the Select Menu Page"
            navigateToPage(SelectMenuPage.url)
            SelectMenuPage selectMenuPage = at SelectMenuPage
        when:
            selectMenuPage.chooseRandomColor()
        then:
            sleep(3000)
    }

    void "clickAndAcceptConfirmButtonAndAcceptAlert"() {
        given:
            navigateToPage(AlertsFramesAndWindowsPage.url)
            AlertsFramesAndWindowsPage alertsFramesAndWindowsPage = at AlertsFramesAndWindowsPage
        when:
            alertsFramesAndWindowsPage.clickConfirmButton()
            alertsFramesAndWindowsPage.acceptPopUpAlert()
        then:
            alertsFramesAndWindowsPage.youAcceptedTheAlert()
    }

    void "clickAndAcceptConfirmButtonAndDismissAlert"() {
        given:
            navigateToPage(AlertsFramesAndWindowsPage.url)
            AlertsFramesAndWindowsPage alertsFramesAndWindowsPage = at AlertsFramesAndWindowsPage
        when:
            alertsFramesAndWindowsPage.clickConfirmButton()
            alertsFramesAndWindowsPage.dismissPopUpAlert()
        then:
            alertsFramesAndWindowsPage.youDismissedTheAlert()
    }

    void "clickNewWindowButtonAndPrintTextFromNewWindow"() {
        given:
            navigateToPage(BrowserWindowsPage.url)
            BrowserWindowsPage browserWindowsPage = at BrowserWindowsPage
        when:
            browserWindowsPage.clickNewWindowButton()
            browserWindowsPage.switchToNewWindow()
        then:
            browserWindowsPage.assertTextFromNewWindowIsCorrect()
    }

    void "IFrameTest"() {
        given:
            navigateToPage(IFramePage.url)
            IFramePage iFramePage = at IFramePage
        when:
            iFramePage.switchToGlobalSQAFrame()
            iFramePage.searchForASpecificBook("Geb")
            iFramePage.moveToFacebookButtonAndClickIt()
            iFramePage.switchToFacebookTab()
        then:
            iFramePage.assertFacebookPageName()
    }

    void "TablePress"() {
        when:
            navigateToPage(TablePress.url)
            TablePress tablePress = at TablePress
        then:
            tablePress.assertLastNamesAreDisplayed()
            tablePress.assertTablePressInformationIsDisplayed()
            tablePress.assertTableRowIsNotEmpty()
    }
}
