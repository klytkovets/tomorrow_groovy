package content.utils.entities

class ItemEntity extends BaseEntity {

    String title
    String size
    String type
    float price
    int quantity

    @Override
    public String toString(){
        return "ItemEntity{" +
                "title = '" + title + '\'' +
                ", price = " + price +
                ", size = '" + size + '\'' +
                ", type = '" + type + '\'' +
                ",quantity = " + qty +
                '}'
    }

    public ItemEntity(String title, float price, int quantity, String size, String type){
        this.title = title
        this.price = price
        this.quantity = quantity
        this.size = size
        this.type = type
    }

    public ItemEntity(){}

    public String getSize() {return size}
    public void setSize(String size) {this.size = size}

    public String getType() {return type}
    public void setType(String type) {this.type = type}

    public String getTitle() {return title}
    public void setTitle(String title) {this.title = title}

    public float getPrice() {return price}
    public void setPrice(float price) {this.price = price}

    public int getQuantity() {return quantity}
    public void setQuantity(int quantity) {this.quantity = quantity}

}
