package content.modules

import geb.Module

class productInfo extends Module{

    static content = {

        addToCartButton {$("#product-addtocart-button")}
    }

    def clickAddToCartButton(){
        addToCartButton.click()
    }
}
