package content

import geb.Page
import org.openqa.selenium.By

class ShopPage extends Page{

    static url = "shop"

    static content = {

        shopOurMattressButton {$ (By.xpath("//A[text()='Shop Our Hybrid Mattress']"))}
    }

    def clickOnShopOurMattress(){
        shopOurMattressButton.click()
    }
}
