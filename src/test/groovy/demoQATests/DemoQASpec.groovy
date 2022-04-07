package demoQATests

import demoqa.BasePage
import demoqa.FormsPage
import demoqa.PracticeFormPage

class DemoQASpec extends BaseSpec {

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
            practiceFormPage.fillInFirstNameField("Panayot")
            practiceFormPage.fillInLastName("Yanev")
            practiceFormPage.fillInEmail("panayot.yanev@mentormate.com")
            practiceFormPage.fillInYourGender()
            practiceFormPage.fillInPhoneNumber("0895464310")
            practiceFormPage.fillInDateOfBirth("06/18/2000")
            practiceFormPage.fillInYourHobbies()
            practiceFormPage.fillInYouCurrentAddress("Bulgaria, Burgas, Izgrev")
            practiceFormPage.selectYourState("NCR")
            practiceFormPage.selectYourCity("Delhi")
            practiceFormPage.clickSubmitButton()
        then: "Thank user for submitting the form"
            practiceFormPage.submitMessageIsDisplayed()
    }
}
