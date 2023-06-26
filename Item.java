public abstract class Item {
    private String name;
    private double purchasePrice;
    private double listPrice;
    private boolean newOrUsed;
    private int dayArrived;
    private String condition;
    private double salePrice;
    private int daySold;

    public Item(String name, double purchasePrice, double listPrice, boolean newOrUsed,
                int dayArrived, String condition, double salePrice, int daySold) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.listPrice = listPrice;
        this.newOrUsed = newOrUsed;
        this.dayArrived = dayArrived;
        this.condition = condition;
        this.salePrice = salePrice;
        this.daySold = daySold;
    }

    public String getName() {
        return this.name;
    }

    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    public double getListPrice() {
        return this.listPrice;
    }

    public boolean isNewOrUsed() {
        return this.newOrUsed;
    }

    public int getDayArrived() {
        return this.dayArrived;
    }

    public String getCondition() {
        return this.condition;
    }

    public double getSalePrice() {
        return this.salePrice;
    }

    public int getDaySold() {
        return this.daySold;
    }
    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
    public void setDaySold(int daySold) {
        this.daySold = daySold;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public static abstract class Music extends Item {
        private String band;
        private String album;

        public Music(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String band, String album) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
            this.band = band;
            this.album = album;
        }

        public String getBand() {
            return band;
        }

        public void setBand(String band) {
            this.band = band;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }
    }

    public static class PaperScore extends Music {
        public PaperScore(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String band, String album) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, band, album);
        }
    }

    public static class CD extends Music {
        public CD(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String band, String album) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, band, album);
        }
    }

    public static class Vinyl extends Music {
        public Vinyl(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String band, String album) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, band, album);
        }
    }

    public static abstract class Player extends Item {
        public Player(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
        }
    }

    public static class CDPlayer extends Player {
        public CDPlayer(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
        }
    }

    public static class RecordPlayer extends Player {
        public RecordPlayer(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
        }
    }

    public static class MP3Player extends Player {
        public MP3Player(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
        }
    }


    public static class Instrument extends Item {
        protected String type;

        public Instrument(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class StringedInstrument extends Instrument {
        private boolean isElectric;

        public StringedInstrument(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type, boolean isElectric) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, type);
            this.isElectric = isElectric;
        }

        public boolean getIsElectric() {
            return this.isElectric;
        }

        public void setIsElectric(boolean isElectric) {
            this.isElectric = isElectric;
        }
    }

    public static class Guitar extends StringedInstrument {

        public Guitar(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type, boolean isElectric) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, type, isElectric);
        }
    }

    public static class Bass extends StringedInstrument {

        public Bass(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type, boolean isElectric) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, type, isElectric);
        }
    }

    public static class Mandolin extends StringedInstrument {

        public Mandolin(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type, boolean isElectric) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, type, isElectric);
        }
    }

    public static class WindInstrument extends Instrument {
        private String windType;

        public WindInstrument(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type, String windType) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, type);
            this.windType = windType;
        }

        public String getWindType() {
            return this.windType;
        }

        public void setWindType(String windType) {
            this.windType = windType;
        }
    }


    public static class Flute extends WindInstrument {
        private String fluteType;

        public Flute(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type, String windType, String fluteType) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, type, windType);
            this.fluteType = fluteType;
        }

        public String getFluteType() {
            return this.fluteType;
        }

        public void setFluteType(String fluteType) {
            this.fluteType = fluteType;
        }
    }

    public static class Harmonica extends WindInstrument {
        private String harmonicaKey;

        public Harmonica(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String type, String windType, String harmonicaKey) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, type, windType);
            this.harmonicaKey = harmonicaKey;
        }

        public String getHarmonicaKey() {
            return this.harmonicaKey;
        }

        public void setHarmonicaKey(String harmonicaKey) {
            this.harmonicaKey = harmonicaKey;
        }
    }


    public static class Clothing extends Item {
        private String clothingType;

        public Clothing(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String clothingType) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
            this.clothingType = clothingType;
        }

        public String getClothingType() {
            return this.clothingType;
        }

        public void setClothingType(String clothingType) {
            this.clothingType = clothingType;
        }
    }

    public static class Hat extends Clothing {
        private String hatSize;

        public Hat(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String clothingType, String hatSize) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, clothingType);
            this.hatSize = hatSize;
        }

        public String getHatSize() {
            return this.hatSize;
        }

        public void setHatSize(String hatSize) {
            this.hatSize = hatSize;
        }
    }

    public static class Shirt extends Clothing {
        private String shirtSize;

        public Shirt(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String clothingType, String shirtSize) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, clothingType);
            this.shirtSize = shirtSize;
        }

        public String getShirtSize() {
            return this.shirtSize;
        }

        public void setShirtSize(String shirtSize) {
            this.shirtSize = shirtSize;
        }
    }

    public static class Bandana extends Clothing {
        public Bandana(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition, double salePrice, int daySold, String clothingType) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold, clothingType);
        }
    }


    public static class Accessory extends Item {
        public Accessory(String name, double purchasePrice, double listPrice, boolean isNew, int dayArrived, String condition,double salePrice, int daySold) {
            super(name, purchasePrice, listPrice, isNew, dayArrived, condition, salePrice, daySold);
        }
    }

    public static class PracticeAmps extends Accessory {
        private int wattage;

        public PracticeAmps(String name, double purchasePrice, double listPrice, boolean newOrUsed, int dayArrived, String condition,double salePrice, int daySold, int wattage) {
            super(name, purchasePrice, listPrice, newOrUsed, dayArrived, condition, salePrice, daySold);
            this.wattage = wattage;
        }

        public int getWattage() {
            return wattage;
        }

        public void setWattage(int wattage) {
            this.wattage = wattage;
        }
    }

    public static class Cables extends Accessory {
        private int length;

        public Cables(String name, double purchasePrice, double listPrice, boolean newOrUsed, int dayArrived, String condition,double salePrice, int daySold, int length) {
            super(name, purchasePrice, listPrice, newOrUsed, dayArrived, condition, salePrice, daySold);
            this.length = length;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

    public static class Strings extends Accessory {
        private String type;

        public Strings(String name, double purchasePrice, double listPrice, boolean newOrUsed, int dayArrived, String condition,double salePrice, int daySold, String type) {
            super(name, purchasePrice, listPrice, newOrUsed, dayArrived, condition, salePrice, daySold);
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
