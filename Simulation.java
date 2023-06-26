import java.util.List;
import java.util.Random;

public class Simulation {
    private static final int NUM_DAYS = 30;

    private Inventory inventory;
    private Inventory soldItems;
    private Clerk clerkg;
    private Clerk clerkf;
    private CashRegister cashRegister;

    public Simulation() {
        inventory = new Inventory();
        soldItems = new Inventory();
        cashRegister = new CashRegister();
        clerkg = new Clerk("Ginger");
        clerkf = new Clerk("Fred");
    }

    public void run() {

        for (int itemType = 0; itemType <= 16; itemType++) {
            for (int j = 0; j < 3; j++) {
                Item item = ItemGenerator.generateRandomItem(itemType);
                inventory.addItem(item);
            }
        }
//        System.out.println(inventory.getItems());

        Random rand = new Random();
        StringBuilder output = new StringBuilder();
        // Simulate the store operations for 30 days
        for (int day = 1; day <= NUM_DAYS; day++) {
            Clerk clerk = clerkg;
            output.append("Day ").append(day).append(":\n");

            // Clerk arrives at the store
            if (rand.nextBoolean()) {
                //Ginger works
                if (clerkg.getConsecutiveDaysWorked() < 3){
                    clerk = clerkg;
                    clerk.arriveAtStore(day);
                    clerkf.resetConsecutiveDaysWorked();
//                    System.out.println(" Consecutive days worked " + clerk.getConsecutiveDaysWorked() + ".");

                }
            } else {
                //Fred works
                clerk = clerkf;
                clerk.arriveAtStore(day);
                clerkg.resetConsecutiveDaysWorked();
//                System.out.println(" Consecutive days worked " + clerk.getConsecutiveDaysWorked() + ".");
            }
            clerk.checkRegister();

            clerk.doInventory(inventory);

            clerk.openTheStore(inventory, soldItems, day);

            clerk.cleanTheStore(inventory);

            clerk.leaveTheStore();
        }

    }
}

