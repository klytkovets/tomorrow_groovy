package content

import content.modules.pageHeader
import content.products.MattressPage
import content.products.FoampillowPage
import content.products.MonitorPage
import geb.Page
import org.openqa.selenium.By

class HomePage extends Page{
    static url = ""

    static content = {
        header {module(pageHeader)}
        shopOurMattressButton { $ (By.xpath("(//a[@class='shop-button'])[1]"))}
        shopOurMonitorButton { $ (By.xpath("(//a[text()='Shop Our Monitor'])[1]"))}
        shopFoamPillowButton { $ (By.xpath("(//a[@class='shop-button'])[2]"))}
    }

    def clickOnShopOurMattress(){
        shopOurMattressButton.click()
        return MattressPage
    }

    def clickOnShopOurMonitor(){
        shopOurMonitorButton.click()
        return MonitorPage
    }

    def clickOnShopFoamPillow(){
        shopFoamPillowButton.click()
        return FoampillowPage
    }

}
