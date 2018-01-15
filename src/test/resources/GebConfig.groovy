import groovy.json.JsonSlurper
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import utils.commonutils

ChromeDriverManager.getInstance().setup()

def caps = {
    ChromeOptions chromeOptions = new ChromeOptions()
    //chromeOptions.addArguments("--kiosk")
    chromeOptions.addArguments("--start-maximized")
    //chromeOptions.addArguments("--start-fullscreen")
    chromeOptions
}


driver = { new ChromeDriver(caps()) }
reportsDir = new File("target/runtime_reports_dir")


def inputFile = new File(commonutils.getPathToData())

def InputJSON = new JsonSlurper().parseText(inputFile.text)
baseUrl = InputJSON.baseUrl