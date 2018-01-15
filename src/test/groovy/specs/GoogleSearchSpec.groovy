package specs

import common.BaseTestSpec
import content.HomePage
import content.modules.pageHeader

class GoogleSearchSpec extends BaseTestSpec{
    def "Google Search"()
    {
        when: "Open Google Search page"
        def googlePage = page(HomePage)
        to googlePage

        and: "Search"
        def header = module(pageHeader)
        googlePage.header.shop()


        then: "Verify the search results"
        googlePage.resultsAreDisplayed()

        where:
        query    | _
        "46"     | _
        "qwerty" | _
    }
}
