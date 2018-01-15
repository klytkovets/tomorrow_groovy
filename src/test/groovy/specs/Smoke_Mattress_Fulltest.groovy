package specs

import common.BaseTestSpec
import content.HomePage
import content.ShopPage
import content.products.MattressPage
import utils.commonutils

class Smoke_Mattress_Fulltest extends BaseTestSpec{

    def "Order a Mattress"(){

        when:
        to(homepage)
        homepage.header.clickOnShopMenuItem()
        shoppage.clickOnShopOurMattress()
        mattresspage.selectMattressSize(size)
        mattresspage.ProductInfo.clickAddToCartButton()


        where:
        homepage = page(HomePage)
        shoppage = page(ShopPage)
        mattresspage = page(MattressPage)


        and:
        size = commonutils.getDataFromJson(commonutils.pathToProducts)["mattress"]["size"]


        then:
        1==1

    }
}
