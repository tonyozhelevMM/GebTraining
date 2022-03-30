import DemoQA.AlertsFramesAndWindowsPage
import DemoQA.BasePage
import DemoQA.BrowserWindowsPage
import DemoQA.FormsPage
import DemoQA.PracticeFormPage
import DemoQA.SelectMenuPage
import IFrame.IFramePage
import TablePress.TablePress

class ExampleSpec extends BaseSpec {

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
            navigateToPracticeFormPage()
            PracticeFormPage practiceFormPage = at PracticeFormPage
        when: "Fill out the form"
            sleep(30)
        then: "Verify something"
            sleep(30)
    }

    void "selectRandomColorFromDropdownMenu"(){
        given: "User is on the Select Menu Page"
            navigateToSelectMenuPage()
        SelectMenuPage selectMenuPage = at SelectMenuPage
        when:
            selectMenuPage.chooseRandomNumber()
        then:
            sleep(3000)
    }

    void "clickAndAcceptConfirmButtonAndAcceptAlert"() {
        given:
            navigateToAlertsPage()
            AlertsFramesAndWindowsPage alertsFramesAndWindowsPage = at AlertsFramesAndWindowsPage
        when:
            alertsFramesAndWindowsPage.clickConfirmButton()
            alertsFramesAndWindowsPage.acceptPopUpAlert()
        then:
            sleep(3000)
    }

    void "clickAndAcceptConfirmButtonAndDismissAlert"() {
        given:
            navigateToAlertsPage()
            AlertsFramesAndWindowsPage alertsFramesAndWindowsPage = at AlertsFramesAndWindowsPage
        when:
            alertsFramesAndWindowsPage.clickConfirmButton()
            alertsFramesAndWindowsPage.dismissPopUpAlert()
        then:
            sleep(3000)
    }

    void "clickNewWindowButtonAndPrintTextFromNewWindow"() {
        given:
            navigateToBrowserWindowsPage()
            BrowserWindowsPage browserWindowsPage = at BrowserWindowsPage
        when:
            browserWindowsPage.clickNewWindowButton()
            browserWindowsPage.switchToNewWindow()
            browserWindowsPage.printTextFromNewWindow()
        then:
            sleep(3000)
    }

    void "IFrameTest"() {
        given:
            navigateToIFramePage()
            IFramePage iFramePage = at IFramePage
        when:
            iFramePage.switchToGlobalSQAFrame()
            iFramePage.searchForGebBookInSearchBar()
            iFramePage.moveToFacebookButtonAndClickIt()
            iFramePage.switchToFacebookTab()
            iFramePage.printFacebookPageName()
        then:
            sleep(3000)
    }

    void "TablePress"() {
        given:
            navigateToTablePress()
            TablePress tablePress = at TablePress
        when:
            tablePress.printTablePressInformation()
            tablePress.printTableRow()
            tablePress.printLastNames()
        then:
            sleep(3000)
    }
}
