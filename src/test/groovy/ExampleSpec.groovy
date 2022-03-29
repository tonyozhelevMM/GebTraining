

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
}
