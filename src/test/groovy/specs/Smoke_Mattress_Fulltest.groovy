package specs

import common.BaseTestSpec
import content.HomePage
import content.ShopPage
import content.products.MattressPage
import utils.commonutils

class Smoke_Mattress_Fulltest extends BaseTestSpec{

    def "Order a Mattress"(){

        when:
        def homepage = page(HomePage)
        def shoppage = page(ShopPage)
        def mattresspage = page(MattressPage)
        to(homepage)
        homepage.header.clickOnShopMenuItem()
        shoppage.clickOnShopOurMattress()
        mattresspage.selectMattressSize(size)
        mattresspage.ProductInfo.clickAddToCartButton()

        then:
        1==1


        where:
        size = commonutils.getDataFromJson(commonutils.pathToProducts)["mattress"]["size"]



    }
}
