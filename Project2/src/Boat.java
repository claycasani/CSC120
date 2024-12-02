import java.io.Serializable;

/**
 * Boat class representing a boat in the fleet.
 *
 * @author claycasani
 */
public class Boat implements Serializable {

    /**
     * Enum representing the type of the boat.
     */
    public enum BoatType {
        SAILING, POWER
    }

    // Variables to hold boat attributes
    private BoatType type;
    private String name, makeModel;
    private int year, length;
    private double purchasePrice, expenses;

    /**
     * Constructor to initialize a Boat object.
     * @param type Type of the boat
     * @param name Name of the boat
     * @param makeModel Make and model of the boat
     * @param year Year of manufacture
     * @param length Length of the boat
     * @param price Purchase price of the boat
     * @param expenses Initial expenses of the boat
     */
    public Boat(BoatType type, String name, String makeModel, int year, int length, double price, double expenses) {
        this.type = type;
        this.name = name;
        this.makeModel = makeModel;
        this.year = year;
        this.length = length;
        this.purchasePrice = price;
        this.expenses = expenses;
    }

    /**
     * Get the type of the boat.
     * @return Type of the boat
     */
    public BoatType getType() {
        return type;
    }

    /**
     * Get the name of the boat.
     * @return Name of the boat
     */
    public String getName() {
        return name;
    }

    /**
     * Get the make and model of the boat.
     * @return Make and model of the boat
     */
    public String getMakeModel() {
        return makeModel;
    }

    /**
     * Get the year of manufacture of the boat.
     * @return Year of manufacture
     */
    public int getYear() {
        return year;
    }

    /**
     * Get the length of the boat.
     * @return Length of the boat
     */
    public int getLength() {
        return length;
    }

    /**
     * Get the purchase price of the boat.
     * @return Purchase price of the boat
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Get the expenses of the boat.
     * @return Expenses of the boat
     */
    public double getExpenses() {
        return expenses;
    }

    /**
     * Add an expense to the boat.
     * @param amount Amount to be added to the expenses
     */
    public void addExpense(double amount) {
        this.expenses += amount;
    }

    /**
     * Return a string representation of the boat.
     * @return String representation of the boat
     */
    @Override
    public String toString() {
        return String.format("%-8s %-20s %4d %-10s %3d' : Paid $ %10.2f : Spent $ %10.2f",
                type, name, year, makeModel, length, purchasePrice, expenses);
    }
} // End of Boat class