// Import necessary libraries
import java.util.Random;
import java.util.List;

public abstract class Staff {
    protected String name;
    protected int consecutiveDaysWorked;

    public Staff(String name) {
        this.name = name;
        this.consecutiveDaysWorked = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getConsecutiveDaysWorked() {
        return this.consecutiveDaysWorked;
    }

    public void incrementConsecutiveDaysWorked() {
        this.consecutiveDaysWorked++;
    }

    public void resetConsecutiveDaysWorked() {
        this.consecutiveDaysWorked = 0;
    }
}

