import java.util.Random;
import java.util.List;

public class Clerk extends Staff {
    private double registerMoney;
    private double bankWithdrawnMoney;

    public Clerk(String name) {
        super(name);
        this.registerMoney = 0.0;
        this.bankWithdrawnMoney = 0.0;
    }

    public void arriveAtStore(int day) {
        System.out.println(getName() + " arrives at the store on Day " + day + ".");
        this.incrementConsecutiveDaysWorked();
    }


    public void checkRegister() {
        System.out.println(getName() + " is counting the money in the register.");

        if (registerMoney < 75.0) {
            System.out.println("Insufficient money in the register. Going to the bank.");
            goToBank();
        } else {
            System.out.println("Money in the register: $" + registerMoney);
        }
    }

    public void goToBank() {
        System.out.println(getName() + " is going to the bank.");

        // Simulating bank withdrawal of $1000
        double withdrawalAmount = 1000.0;
        registerMoney += withdrawalAmount;
        bankWithdrawnMoney += withdrawalAmount;

        System.out.println(getName() + " withdrew $" + withdrawalAmount + " from the bank.");
        System.out.println("Money in the register after bank withdrawal: $" + registerMoney);
    }

    public void doInventory(Inventory inventory) {
        System.out.println(getName() + " is performing the inventory.");

        // Calculate the total value of all items in the store based on purchase price
        double totalValue = inventory.calculateTotalValue();
        System.out.println("Total value of items in the store: $" + totalValue);

        boolean fullItems = checkZeroCountItems(inventory);
        if (fullItems != true){
            placeAnOrder();
        }

    }



    public boolean checkZeroCountItems(Inventory inventory) {
        String emptyClassName = inventory.findEmptySubclass();
        if (emptyClassName != null) {
            System.out.println("No items found for class: " + emptyClassName);
            return true;
        } else {
            System.out.println("All classes have at least one item.");
            return false;
        }
    }

    public void placeAnOrder() {
        System.out.println(getName() + " is placing an order.");


        System.out.println(getName() + " placed the order.");
    }

    public void openTheStore(Inventory inventory, Inventory soldItems, int day) {
        System.out.println(getName() + " is opening the store.");

        int buyingCustomers = new Random().nextInt(7) + 4;
        int sellingCustomers = new Random().nextInt(4) + 1;
        int totalCustomers = buyingCustomers + sellingCustomers;

        for (int i = 1; i <= totalCustomers; i++) {
            Item item = ItemGenerator.generateRandomItem(new Random().nextInt(17));
            boolean isBuyingCustomer = new Random().nextInt(2) == 1;

            if (isBuyingCustomer && buyingCustomers > 0) {
                List<Item> items = inventory.findItems(item.getClass());
                if (!items.isEmpty()) {
                    boolean willBuy = new Random().nextInt(2) == 1;
                    if (willBuy) {
                        Item selectedItem = items.get(0);
                        soldItems.addItem(selectedItem);
                        selectedItem.setSalePrice(selectedItem.getListPrice());
                        selectedItem.setDaySold(day);
                        System.out.println(getName() + " sold a " + item.getClass().getSimpleName() + " to Customer " + i + " for $" + selectedItem.getListPrice() + ".");
                        registerMoney += selectedItem.getListPrice();
                        inventory.removeItem(selectedItem);
                    } else {
                        boolean willBuyWithDiscount = new Random().nextInt(4) != 3;
                        if (willBuyWithDiscount) {
                            Item selectedItem = items.get(0);
                            soldItems.addItem(selectedItem);
                            double discountedPrice = 0.9 * selectedItem.getListPrice();
                            selectedItem.setSalePrice(discountedPrice);
                            selectedItem.setDaySold(day);
                            System.out.println(getName() + " sold a " + item.getClass().getSimpleName() + " to Customer " + i + " for $" + discountedPrice + " after a 10% discount.");
                            registerMoney += selectedItem.getListPrice();
                            inventory.removeItem(selectedItem);
                        }
                    }
                } else {
                    System.out.println("Customer " + i + " wanted to buy a " + item.getClass().getSimpleName() + " but none were in inventory, so they left.");
                }
                buyingCustomers--;
            } else if (!isBuyingCustomer && sellingCustomers > 0) {
                double purchasePrice = item.getPurchasePrice();
                boolean willSell = new Random().nextInt(2) == 1;
                if (willSell) {
                    inventory.addItem(item);
                    System.out.println(getName() + " bought a " + item.getCondition() + " condition " + (item.isNewOrUsed() ? "new" : "used") + " " + item.getClass().getSimpleName() + " from Customer " + i + " for $" + purchasePrice + ".");
                } else {
                    boolean willSellWithIncrease = new Random().nextInt(4) != 3;
                    if (willSellWithIncrease) {
                        double increasedPrice = 1.1 * purchasePrice;
                        inventory.addItem(item);
                        System.out.println(getName() + " bought a " + item.getCondition() + " condition " + (item.isNewOrUsed() ? "new" : "used") + " " + item.getClass().getSimpleName() + " from Customer " + i + " for $" + increasedPrice + " after adding 10% to the offered price.");
                    }
                }
                sellingCustomers--;
            }
        }
    }

    public void cleanTheStore(Inventory inventory) {
        System.out.println(getName() + " is cleaning the store.");

        double damageChance;
        if (getName().equals("Ginger")) {
            damageChance = 0.05;
        } else if (getName().equals("Fred")) {
            damageChance = 0.20;
        } else {
            // default
            damageChance = 0.10;
        }

        if (new Random().nextDouble() < damageChance) {
            List<Item> items = inventory.getItems();
            if (!items.isEmpty()) {
                int damagedItemIndex = new Random().nextInt(items.size());
                Item damagedItem = items.get(damagedItemIndex);

                switch (damagedItem.getCondition()) {
                    case "New":
                        damagedItem.setCondition("Good");
                        break;
                    case "Good":
                        damagedItem.setCondition("Fair");
                        break;
                    case "Fair":
                        damagedItem.setCondition("Poor");
                        break;
                    case "Poor":
                        inventory.removeItem(damagedItem);
                        System.out.println(getName() + " damaged a " + damagedItem.getClass().getSimpleName() + " beyond repair while cleaning and it was removed from inventory.");
                        return;
                }

                double newListPrice = damagedItem.getListPrice() * 0.80;
                damagedItem.setListPrice(newListPrice);

                System.out.println(getName() + " accidentally damaged a " + damagedItem.getClass().getSimpleName() + " while cleaning. Its condition was lowered to " + damagedItem.getCondition() + " and its list price was reduced to $" + newListPrice + ".");
            }
        }
    }


    public void leaveTheStore() {
        System.out.println(getName() + " is leaving the store for the day.");
    }


}