import geb.Page
import geb.module.DateInput
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import java.time.Duration

class PracticeFormPage extends Page {

    static at = {
        formHeader.isDisplayed()
        formHeader.text() == "Student Registration Form"
    }

    static content = {
        formHeader                   {$("h5")}
        firstNameField               {$(By.id("firstName"))}
        lastNameField                {$(By.id("lastName"))}
        emailField                   {$(By.id("userEmail"))}
        maleRadioButton              {$(By.xpath("//label[text() = 'Male']"))}
        userPhoneNumberField         {$(By.id("userNumber"))}
        dateOfBirthField             {$(By.id("dateOfBirthInput")).module(DateInput)}
        musicCheckbox                {$(By.xpath("//label[text() = 'Music']"))}
        currentAddressField          {$(By.id("currentAddress"))}
        stateCityWrapper             {$(By.id("stateCity-wrapper"))}
        stateSelector                {$(By.xpath("//div[text() = 'Select State']"))}
        citySelector                 {$(By.id("city"))}
        submitButton                 {$(By.id("submit"))}
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
        assert waitFor {stateSelector}.isDisplayed()
        stateSelector.click()
        stateSelector << state
        stateSelector << Keys.ENTER
    }

    void selectYourCity(String city){
        assert citySelector.isDisplayed()
        citySelector.click()
        citySelector << city
        citySelector << Keys.ENTER
    }

    void clickSubmitButton(){
        submitButton.click()
    }
}
