package DemoQA

import geb.Page
import org.openqa.selenium.By

class SelectMenuPage extends Page{
    static at = {
        mainHeader.isDisplayed()
        dropdownMenu.isDisplayed()
        mainHeader.text() == "Select Menu"
    }

    static content = {
        mainHeader          {$(By.className("main-header"))}
        dropdownMenu        {$("#oldSelectMenu")}
    }

    static url = "https://demoqa.com/select-menu"

    void chooseRandomColor() {
        Random random = new Random()
        int randomNumber = random.nextInt(10) + 1

        dropdownMenu.click()
        dropdownMenu.find("option").find{it.value() == randomNumber.toString()}.click()
    }
}
