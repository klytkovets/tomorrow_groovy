package content.modules

import geb.Module
import org.openqa.selenium.By

class pageHeader extends Module{

    static content = {

        //top menu
        topMenuItem_Shop {$ (By.xpath("(//SPAN[text()='Shop'][text()='Shop'])[1]"))}
        //topMenuItem_Magazine
        //topMenuItem_FAQ
        //topMenuItem_Reviews


    }

    def clickOnShopMenuItem(){
        topMenuItem_Shop.click()
    }
}
