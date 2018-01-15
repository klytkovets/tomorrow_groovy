package content.products

import geb.Page
import org.openqa.selenium.By
import content.modules.productInfo

class MattressPage extends Page{

    static url = "mattresses"

    static content = {

        ProductInfo {module(productInfo)}
        mattressSizeBlock {$("div.bed-size-select")}
        mattressSize (wait:true){size -> $(By.xpath("//div[@class='option' and contains(text(),'" + size +"')]"))[1]}

    }

//    def clickOnMattresSize(){
//        mattressSizeBlock.click()
//    }

    def selectMattressSize(String size){
        mattressSize(size).click()
    }



}
