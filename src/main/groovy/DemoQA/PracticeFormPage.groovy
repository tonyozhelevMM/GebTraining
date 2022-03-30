package DemoQA

import geb.Page

class PracticeFormPage extends Page {

    static at = {
        formHeader.isDisplayed()
        formHeader.text() == "Student Registration Form"
    }

    static content = {
        formHeader                   {$("h5")}
    }

    static url = "https://demoqa.com/automation-practice-form"

}
