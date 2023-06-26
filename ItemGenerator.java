import java.util.Random;

public class ItemGenerator {

    private static final Random random = new Random();
    private static final String[] conditions = {"poor", "fair", "good", "very good", "excellent"};

    public static Item generateRandomItem(int itemType) {

        String name = "Item" + random.nextInt(10000);
        double purchasePrice = 1 + (50 - 1) * random.nextDouble();
        double listPrice = 2 * purchasePrice;
        boolean isNew = random.nextBoolean();
        int dayArrived = 0;
        String condition = conditions[random.nextInt(conditions.length)];
        double salePrice = 0; // These two will be set when the item is sold
        int daySold = 0;

        switch (itemType) {
            case 0:
                return new Item.PaperScore(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Band"+random.nextInt(1000), "Album"+random.nextInt(1000));
            case 1:
                return new Item.CD(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Band"+random.nextInt(1000), "Album"+random.nextInt(1000));
            case 2:
                return new Item.Vinyl(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Band"+random.nextInt(1000), "Album"+random.nextInt(1000));
            case 3:
                return new Item.CDPlayer(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
            case 4:
                return new Item.RecordPlayer(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
            case 5:
                return new Item.MP3Player(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
            case 6:
                return new Item.Guitar(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Type"+random.nextInt(100), random.nextBoolean());
            case 7:
                return new Item.Bass(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Type"+random.nextInt(100), random.nextBoolean());
            case 8:
                return new Item.Mandolin(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Type"+random.nextInt(100), random.nextBoolean());
            case 9:
                return new Item.Flute(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Type"+random.nextInt(100), "WindType"+random.nextInt(100), "Type"+random.nextInt(100));
            case 10:
                return new Item.Harmonica(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Type"+random.nextInt(100), "WindType"+random.nextInt(100), "Key"+random.nextInt(100));
            case 11:
                return new Item.Shirt(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "ClothingType"+random.nextInt(100), "Shirt size"+random.nextInt(100));
            case 12:
                return new Item.Hat(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "ClothingType"+random.nextInt(100), "Hat size"+random.nextInt(100));
            case 13:
                return new Item.Bandana(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "ClothingType"+random.nextInt(100));
            case 14:
                return new Item.Cables(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, random.nextInt(50));
            case 15:
                return new Item.PracticeAmps(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, random.nextInt(50));
            case 16:
                return new Item.Strings(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, "Type"+random.nextInt(100));
            default:
                throw new IllegalStateException("Unexpected value: " + itemType);
        }
    }
}
