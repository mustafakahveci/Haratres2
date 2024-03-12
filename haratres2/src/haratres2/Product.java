
package haratres2;

public class Product {
    
    String name;
    float price;
    int stock;
    float rating;

    public Product(String name, float price, int stock, float rating) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public float getRating() {
        return rating;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
}
