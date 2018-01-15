package common

import geb.spock.GebReportingSpec

class BaseTestSpec extends GebReportingSpec{
    def setup(){
        println "starting..."
        if (System.getProperty("env").equals("stage")){
            browser.driver.get("https://bettersleep:stg-tsleep-@45@staging.tomorrowsleep.com")
        }
    }
}