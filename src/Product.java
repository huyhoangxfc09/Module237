public class Product {
    private  int id;
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product(int id, String name, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void display(){
        System.out.printf("%-15s%-30s%-20s%-20s%s",
                id,name,price,quantity,description+"\n");
    }

    @Override
    public String toString() {
        return id +","+name+","+price+","+quantity+","+description;

    }
}
