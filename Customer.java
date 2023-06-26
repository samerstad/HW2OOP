import java.util.ArrayList;
import java.util.List;

//Unimplemented, but saving for future

public class Customer {
    private String name;
    private List<Item> items;

    public Customer(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    // Returns the customer's name
    public String getName() {
        return this.name;
    }

    // Adds an item to the customer's list of items
    public void addItem(Item item) {
        this.items.add(item);
    }

    // Removes an item from the customer's list of items
    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }

    // Returns the total cost of all items the customer is purchasing
    public double getTotalCost() {
        double totalCost = 0.0;

        for(Item item : this.items) {
            totalCost += item.getSalePrice();
        }

        return totalCost;
    }

    // Returns the list of items the customer is purchasing
    public List<Item> getItems() {
        return this.items;
    }
}
