package specs

import common.BaseTestSpec
import content.HomePage
import content.ShopPage
import content.products.MattressPage
import content.utils.entities.ItemEntity
import org.spockframework.util.Assert
import content.utils.commonutils
import content.utils.EntitiesFactory

class Smoke_Mattress_Fulltest extends BaseTestSpec{

    def "Order a Mattress"(){

        when:
        to(homepage)
        homepage.header.clickOnShopMenuItem()
        shoppage.clickOnShopOurMattress()
        mattresspage.selectMattressSize(size)
        mattresspage.ProductInfo.clickAddToCartButton()
        to(homepage)


        then:
        Assert.that(homepage.header.itemWasFoundInTheCart(item))


        where:
        homepage = page(HomePage)
        shoppage = page(ShopPage)
        mattresspage = page(MattressPage)
        ItemEntity item = EntitiesFactory.getItem("default_products.json")


        and:
        size = commonutils.getDataFromJson(commonutils.pathToProducts)["mattress"]["size"]


        then:
        1==1

    }
}
