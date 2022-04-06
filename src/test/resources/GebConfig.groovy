import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver

driver = {
    WebDriverManager.chromedriver().setup()
    def webDriver = new ChromeDriver()
    webDriver.manage().window().maximize()
    webDriver
}

atCheckWaiting = true

baseUrl = "https://www.amazon.com/"

reportsDir = "target/geb-reports"