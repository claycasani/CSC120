import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FleetManagement class to manage a fleet of boats.
 *
 * @author claycasani
 */
public class FleetManagement {

    // ArrayList to store the fleet of boats
    private static ArrayList<Boat> fleet = new ArrayList<>();
    // Variable to store the name of the database file
    private static final String DB_FILE = "Project2/FleetData.db";

    /**
     * Main method to run the Fleet Management System.
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // If user provides CSV file as command line argument, load fleet from CSV file
        if (args.length == 1) {
            loadFromCSV(args[0]);
        // If user does not include CSV file as command line argument, load fleet from database file
        } else {
            loadFromDB();
        }

        while (true) {
            // Display menu options
            System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            // Get menu option from user input
            String option = scanner.nextLine().trim().toUpperCase();
            switch (option) {
                // If menu option is P, print the fleet
                case "P":
                    printFleet();
                    break;
                // If menu option is A, add a boat to the fleet
                case "A":
                    addBoat(scanner);
                    break;
                // If menu option is R, remove a boat from the fleet
                case "R":
                    removeBoat(scanner);
                    break;
                // If menu option is E, add an expense to a boat
                case "E":
                    addExpense(scanner);
                    break;
                // If menu option is X, save the fleet to the database and exit the program
                case "X":
                    saveToDB();
                    System.out.println("Exiting the Fleet Management System");
                    return;
                // If menu option is invalid, display an error message
                default:
                    System.out.println("Invalid menu option, try again");
            }
        }
    } // End of main method

    /**
     * Load fleet data from a CSV file.
     * @param csvFile Path to the CSV file
     */
    private static void loadFromCSV(String csvFile) {
        // Open and read CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line into values
                String[] values = line.split(",");
                // Parse values to their corresponding attributes
                Boat.BoatType type = Boat.BoatType.valueOf(values[0].toUpperCase());
                String name = values[1];
                int year = Integer.parseInt(values[2]);
                String makeModel = values[3];
                int length = Integer.parseInt(values[4]);
                double purchasePrice = Double.parseDouble(values[5]);
                // Create a new boat object and add it to the fleet
                fleet.add(new Boat(type, name, makeModel, year, length, purchasePrice, 0.0));
            }
          // Catch any IOException during reading of CSV file
        } catch (IOException e) {
            // Print the stack trace of the exception
            e.printStackTrace();
        }
    } // End of loadFromCSV method

    /**
     * Load fleet data from a database file.
     */
    private static void loadFromDB() {
        // Try to open and read the database file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DB_FILE))) {
            // Read the fleet data from the file
            fleet = (ArrayList<Boat>) ois.readObject();
            // Catch and print any IOException or ClassNotFoundException that occurs
        } catch (IOException | ClassNotFoundException e) {
            // Print the stack trace of the exception
            e.printStackTrace();
        }
    } // End of loadFromDB method

    /**
     * Save fleet data to a database file.
     */
    private static void saveToDB() {
        // Open and write to the database file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DB_FILE))) {
            // Write the fleet data to the file
            oos.writeObject(fleet);
            // Catch and print any IOException that occurs
        } catch (IOException e) {
            // Print the stack trace of the exception
            e.printStackTrace();
        }
    } // End of saveToDB method

    /**
     * Print the fleet report.
     */
    private static void printFleet() {
        double totalPaid = 0.0;
        double totalSpent = 0.0;
        System.out.println("\nFleet report:");
        // Loop through each boat in fleet
        for (Boat boat : fleet) {
            // Print boat details
            System.out.println(boat);
            // Assign purchase price and expenses to totalPaid and totalSpent respectively
            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();
        }
        // Print the total amount paid and spent
        System.out.printf("Total                                             : Paid $ %10.2f : Spent $ %10.2f\n", totalPaid, totalSpent);
    } // End of printFleet method

    /**
     * Add a new boat to the fleet.
     * @param scanner Scanner object for user input
     */
    private static void addBoat(Scanner scanner) {
        // Prompt user for details of new boat
        System.out.print("Please enter the new boat CSV data          : ");
        // Read the new boat data from user input
        String line = scanner.nextLine();
        // Split the input line into values
        String[] values = line.split(",");
        // Parse values to their corresponding attributes
        Boat.BoatType type = Boat.BoatType.valueOf(values[0].toUpperCase());
        String name = values[1];
        int year = Integer.parseInt(values[2]);
        String makeModel = values[3];
        int length = Integer.parseInt(values[4]);
        double purchasePrice = Double.parseDouble(values[5]);
        // Create a new boat object and add it to the fleet
        fleet.add(new Boat(type, name, makeModel, year, length, purchasePrice, 0.0));
    } // End of addBoat method

    /**
     * Remove a boat from the fleet.
     * @param scanner Scanner object for user input
     */
    private static void removeBoat(Scanner scanner) {
        // Prompt user for name of boat to remove
        System.out.print("Which boat do you want to remove?           : ");
        // Read the name of the boat to remove from user input
        String name = scanner.nextLine().trim();
        Boat boatToRemove = null;
        // Find the boat with the specified name in the fleet
        for (Boat boat : fleet) {
            if (boat.getName().equalsIgnoreCase(name)) {
                // Assign name of boat to remove to boatToRemove
                boatToRemove = boat;
                break;
            }
        }
        // If boat is found, remove it from  fleet
        if (boatToRemove != null) {
            fleet.remove(boatToRemove);
        } else {
            // If boat is not found, print an error message
            System.out.println("Cannot find boat " + name);
        }
    } // End of removeBoat method

    /**
     * Add an expense to a boat.
     * @param scanner Scanner object for user input
     */
    private static void addExpense(Scanner scanner) {
        // Prompt user for name of boat to spend on
        System.out.print("Which boat do you want to spend on?         : ");
        // Read the name of the boat to add an expense to from user input
        String name = scanner.nextLine().trim();
        Boat boatToSpendOn = null;
        // Find the boat with the specified name in the fleet
        for (Boat boat : fleet) {
            if (boat.getName().equalsIgnoreCase(name)) {
                // Assign name of boat to spend on to boatToSpendOn
                boatToSpendOn = boat;
                break;
            }
        }
        // If the boat is found, prompt for the expense amount
        if (boatToSpendOn != null) {
            System.out.print("How much do you want to spend?              : ");
            // Read the expense amount from user input
            double amount = Double.parseDouble(scanner.nextLine());
            // Check if the expense is within the allowed limit
            if (boatToSpendOn.getExpenses() + amount <= boatToSpendOn.getPurchasePrice()) {
                // Add expense to boat
                boatToSpendOn.addExpense(amount);
                // Print message that expense is authorized
                System.out.printf("Expense authorized, $%.2f spent.\n", amount);
            } else {
                // Calculate the remaining amount that can be spent on boat
                double remaining = boatToSpendOn.getPurchasePrice() - boatToSpendOn.getExpenses();
                // Print message that expense is not permitted
                System.out.printf("Expense not permitted, only $%.2f left to spend.\n", remaining);
            }
        } else {
            // If boat is not found, print error message
            System.out.println("Cannot find boat " + name);
        }
    } // End of addExpense method
} // End of FleetManagement class