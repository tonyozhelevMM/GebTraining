import geb.Page
import geb.module.DateInput
import org.openqa.selenium.By
import org.openqa.selenium.Keys

class PracticeFormPage extends Page {

    static at = {
        formHeader.isDisplayed()
        formHeader.text() == "Student Registration Form"
    }

    static content = {
        formHeader                   {$("h5")}
        firstNameField               {$("#firstName")}
        lastNameField                {$("#lastName")}
        emailField                   {$("#userEmail")}
        maleRadioButton              {$(By.xpath("//label[text() = 'Male']"))}
        userPhoneNumberField         {$("#userNumber")}
        dateOfBirthField             {$("#dateOfBirthInput").module(DateInput)}
        musicCheckbox                {$(By.xpath("//label[text() = 'Music']"))}
        currentAddressField          {$("#currentAddress")}
        stateSelector                {$("#react-select-3-input")}
        citySelector                 {$("#react-select-4-input")}
        submitButton                 {$("#submit")}
        thankYouMessage              {$(By.id("example-modal-sizes-title-lg"))}
    }

    static url = "https://demoqa.com/automation-practice-form"

    void fillInFirstNameField(String firstName){
        firstNameField << firstName
    }

    void fillInLastName(String lastName){
        lastNameField << lastName
    }

    void fillInEmail(String email){
        emailField << email
    }

    void fillInYourGender(){
        maleRadioButton.click()
    }

    void fillInPhoneNumber(String phoneNumber){
        userPhoneNumberField << phoneNumber
    }

    void fillInDateOfBirth(String fullDate){
        dateOfBirthField.date = fullDate
        dateOfBirthField << Keys.ENTER
    }

    void fillInYourHobbies(){
        musicCheckbox.click()
    }

    void fillInYouCurrentAddress(String currentField){
        currentAddressField << currentField
    }

    void selectYourState(String state){
        stateSelector << state
        stateSelector << Keys.ENTER
        stateSelector << Keys.TAB
    }

    void selectYourCity(String city){
        citySelector << city
        citySelector << Keys.ENTER
        citySelector << Keys.TAB
    }

    void clickSubmitButton(){
        submitButton << Keys.ENTER
    }

    void submitMessageIsDisplayed(){
        assert thankYouMessage.isDisplayed()
    }
}
