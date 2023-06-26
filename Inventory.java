import java.util.*;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }

    // Returns a list of items that match the given type.
    public List<Item> findItems(Class<? extends Item> itemType) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : this.items) {
            if (itemType.isInstance(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public String findEmptySubclass() {
        Class<?>[] classes = {Item.PaperScore.class, Item.CD.class, Item.Vinyl.class, Item.CDPlayer.class, Item.RecordPlayer.class, Item.MP3Player.class, Item.Guitar.class, Item.Bass.class, Item.Mandolin.class, Item.Flute.class, Item.Harmonica.class, Item.Shirt.class, Item.Hat.class, Item.Bandana.class, Item.Cables.class, Item.PracticeAmps.class, Item.Strings.class};
        for (Class<?> clazz : classes) {
            List<Item> foundItems = findItems(clazz.asSubclass(Item.class));

            if (foundItems.isEmpty()) {
                return clazz.getSimpleName();  // Return the name of the class that has no items in the inventory
            }
        }

        return null;  // Return null if all classes have at least one item in the inventory
    }

    // Returns the list of all items.
    public List<Item> getItems() {
        return this.items;
    }

    public double calculateTotalValue() {
        double totalValue = 0.0;

        // Iterate over all items in the inventory
        for (Item item : this.items) {
            // Add the list price of the current item to the total value
            totalValue += item.getListPrice();
        }

        return totalValue;
    }

}
