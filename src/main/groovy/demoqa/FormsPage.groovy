package demoqa

import org.openqa.selenium.By
class FormsPage extends BasePage {

    static at = {
        pageHeader.isDisplayed()
        pageHeader.text() == "Forms"
    }

    static content = {
        pageHeader                   {$(".main-header")}
        practiceFormLink             {$(By.xpath("//span[text() = 'Practice Form']"))}
    }

    static url = "https://demoqa.com/forms"

    void clickPracticeFormLink(){
        practiceFormLink.click()
    }
}
