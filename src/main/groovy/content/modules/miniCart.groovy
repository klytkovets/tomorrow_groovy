package content.modules


import geb.Module
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class miniCart extends Module{

    static content = {
        viewMiniCartButton {$"a.action.viewcart"}
        closeMiniCartButton {$"#btn-minicart-close"}
        viewFullCartButton {$("a.action.viewcart")}
        checkoutButton {$(".action.primary.checkout")}

        deleteFromMiniCartButton {$("a.action.delete")}
        confirmDeletingItem {$("button.action-primary.action-accept")}

        cartItems {$"div.product-item-details"}
        cartItemName {$"strong.product-item-name"}
        cartItemContent {$"div.content"}
        cartItemQuantity {$ (By.xpath("./div/div/label[text()='Qty']/following::input[1]"))}
        cartItemPrice {$ (By.xpath("./div/div[@class='price-container'][1]"))}
    }

    def openCart(){
        viewMiniCartButton.click()
    }
}
