package content.modules

import geb.Module
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.spockframework.util.Assert

import content.utils.entities.ItemEntity

class pageHeader extends Module{

    static content = {

        //top menu
        topMenuItem_Shop {$ (By.xpath("(//SPAN[text()='Shop'][text()='Shop'])[1]"))}
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
    static def openMinicart(){
        minicartIcon.click()
    }

    def closeMinicart(){
        closeMinicartIcon.click()
    }

    boolean validateItemByTitle(String title, String... expectedContent){
        boolean result = true
        List currentCartItems = new ArrayList<WebElement>()
        String itemName = title

        openMinicart()
        for (String expectedField : expectedContent){
            currentCartItems = minicartItems.allElements()
            for (WebElement cartItem : currentCartItems){
                if ( cartItem.getText().contains(itemName)){
                    String currentContent = cartItem.getText()
                    if (currentContent.contains(expectedField)){
                        result = result && true
                    } else{
                        result = result && false
                    }
                }
            }
        }
        if (currentCartItems.size() == 0){
            return false
        }
        return result
    }

    public ArrayList<ItemEntity> getAllCartItems(){
        ArrayList<ItemEntity> result = new ArrayList<>()

        openMinicart()

        List <WebElement> cartItemsList = minicartItems.allElements()
        for ( WebElement minicartItems : cartItemsList){

            ItemEntity currentItem = new ItemEntity()

            currentItem.setTitle(minicartItems.getText())
            currentItem.setQuantity(Integer.valueOf(minicartItemQuantity.getAttribute("data-item-qty")))
            currentItem.setPrice(utils.convertStringPriceToFloat(minicartItems.(minicartItemPrice).getText()))
            currentItem.setSize("")
            currentItem.setType("")

            List <WebElement> details = minicartItems.(minicartItemDetails)

            for (WebElement element : details){
                String value = element.getText()
                if (value.contains("(") && value.contains(")")){
                    currentItem.setSize(value)
                }
                else
                    currentItem.setType(value)
            }

            result.add(currentItem)
        }

        if (cartItemsList.size() == 0){
            Assert.fail("No cart items were found")
        }

        return result
    }

    boolean itemWasFoundInTheCart (ItemEntity item){
        ArrayList<ItemEntity> items = getAllCartItems()
        return items.stream()
            .filter{cur -> item.getTitle().equals(cur.getTitle())}
            .filter{cur -> item.getQuantity() == cur.getQuantity()}
            .filter{cur -> item.getPrice() == cur.getPrice()}
            .filter{cur -> cur.getType().contains(item.getType())}
            .filter{cur -> cur.getSize().contains(item.getSize())}.count() > 0
    }

    def clickOnCheckoutButton(){
        openMinicart()
        checkoutButton.click()
    }

    def clickOnViewCartButton(){
        openMinicart()
        viewCartButton.click()
    }

    def clickOnDeleteItemButton(ItemEntity item){
        openMinicart()
        List <WebElement> cartItemList = minicartItems.allElements()
        for (int i = 0; i < cartItemList.size(); i++){
            WebElement cartItem = cartItemList.get(i)
            if (cartItem.getText().contains(item.getTitle()) &&
                    utils.convertStringPriceToFloat(cartItem.(minicartItemPrice).getText()) == item.getPrice() &&
                    cartItem.getAttribute("data-item-qty").equals(String.valueOf(item.getQuantity()))){
                cartItem.click()
                clickOnAcceptDeletion()
            }
        }
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
