package content.modules

import geb.Module
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.spockframework.util.Assert

import content.utils.entities.ItemEntity

class pageHeader extends Module{

    static content = {

        //top menu
        topMenuItem_Shop (wait:true){$ (By.xpath("(//SPAN[text()='Shop'][text()='Shop'])[1]"))}
        topMenuItem_Magazine {$ (By.xpath("//ul[@role='menu']//a[@role='menuitem']//span[text()='Sleep']"))}
        topMenuItem_FAQ {$ By.xpath(".//*[@class='help-number-wrapper']//a[contains(text(),' HELP')]")}
        topMenuItem_Reviews {$ (By.xpath("(//SPAN[text()='REVIEWS'][text()='REVIEWS'])[1]"))}

        //minicart
        minicartIcon (wait:true){$ ("a.action.showcart")}
        minicartItems {$ "div.product-item-details"}
        minicartItemName {$ "strong.product-item-name"}
        minicartItemContent {$ "div.content"}
        minicartItemQuantity {$ By.xpath("./div/div/label[text()='Qty']/following::input[1]")}
        minicartItemPrice {$ By.xpath("./div/div[@class='price-container'][1]")}

        viewCartButton {$ "a.action.viewcart"}
        checkoutButton {$ "button#top-cart-btn-checkout"}
        deleteItemButton {$ "a.action.delete"}
        acceptDeletion {$ "button.action-primary.action-accept"}

        minicartItemDetails {$ "dl.product.options.list span"}
        minicartQuantityIcon {$ "span.counter-number"}
        closeMinicartIcon {$ "btn-minicart-close"}
        loadingSpinner {$ "div.fotorama__spinner"}

    }

    //Menu methods
    def clickOnShopMenuItem(){
        topMenuItem_Shop.click()
    }

    def clickOnMagazineMenuItem(){
        topMenuItem_Magazine.click()
    }


    //Minicart methods
    def openMinicart(){
        minicartIcon.click()
    }

    def closeMinicart(){
        closeMinicartIcon.click()
    }



    def clickOnCheckoutButton(){
        openMinicart()
        checkoutButton.click()
    }

    def clickOnViewCartButton(){
        openMinicart()
        viewCartButton.click()
    }

    public int getCountOfItemsFromMinicartIcon(){
        String result = minicartIcon.singleElement().getText().split("\n")
        return Integer.valueOf(result)
    }

    public int getCountofItemsInMinicart(){
        openMinicart()
        int count = 0
        List<WebElement> cartItemList = minicartItems.allElements()
        for (int i = 0; i < cartItemList.size(); i++){
            WebElement cartItem = cartItemList.get(i)
            count = count + Integer.valueOf(cartItem.getAttribute("data-item-qty"))
        }
        closeMinicart()
        return count
    }


}
