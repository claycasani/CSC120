import java.util.Scanner;

/**
 * DentalRecords class to manage the dental records of a family.
 *
 * @author claycasani
 */
public class DentalRecords {

    //  Constants for maximum number of people and teeth allowed, and valid teeth types.
    private static final int MAX_PEOPLE = 6;
    private static final int MAX_TEETH = 8;
    private static final char[] VALID_TEETH = {'I', 'B', 'M'};

    private static final Scanner keyboard = new Scanner(System.in);

    //  String array to hold names of family members.
    private static String[] names = new String[MAX_PEOPLE];
    //  Three-dimensional array to store teeth information for each family member
    private static char[][][] teeth = new char[MAX_PEOPLE][2][MAX_TEETH];
    private static int familySize;

    /**
     * Main method to run the Dental Records program.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");

//  Assign integer value of number of family members to familySize by calling getValidFamilySize.
        familySize = getValidFamilySize();

//  For each member of the family, store name in names array and teeth data in teeth array.
        for (int i = 0; i < familySize; i++) {
            names[i] = getValidName(i + 1);
            teeth[i][0] = getValidTeeth(names[i], "uppers");
            teeth[i][1] = getValidTeeth(names[i], "lowers");
        }

//  Call associated function depending on character inputted by user and returned by getMenuOption().
        while (true) {
            switch (getMenuOption()) {
                case 'P':
                    printRecords();
                    break;
                case 'E':
                    extractTooth();
                    break;
                case 'R':
                    reportRootCanalIndices();
                    break;
                case 'X':
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    return;
            }
        }
    } //  End of main method.

    /**
     * Get a valid family size from the user.
     * @return Valid family size
     */
    private static int getValidFamilySize() {
        int size;
        System.out.print("Please enter number of people in the family: ");

//  Obtain number of people in family from user. Loop until valid family size is entered by user.
        while (true) {
            size = keyboard.nextInt();
            keyboard.nextLine();
            if (size > 0 && size <= MAX_PEOPLE) {
                break;
            }
//  Error if invalid family size is inputted by user.
            System.out.print("Invalid number of people, try again: ");
        }

//  Return valid size of family.
        return size;
    } //  End of getValidFamilySize method.

    /**
     * Get a valid name for a family member.
     * @param memberNumber Family member number
     * @return Valid name
     */
    private static String getValidName(int memberNumber) {
        System.out.printf("Please enter the name for family member %d: ", memberNumber);

//  Obtain and return name of family member.
        return keyboard.nextLine();
    } //  End of getValidName() method.

    /**
     * Get valid teeth data for a family member.
     * @param name Name of the family member
     * @param layer Layer of teeth (uppers or lowers)
     * @return Valid teeth array
     */
    private static char[] getValidTeeth(String name, String layer) {
        char[] teethArray;
        System.out.printf("Please enter the %s for %s: ", layer, name);

//  Continuously prompt user until valid teeth data is entered for the given family member and layer.
        while (true) {
            String input = keyboard.nextLine().toUpperCase();
            if (input.length() > MAX_TEETH) {
                System.out.print("Too many teeth, try again: ");
                continue;
            }
            if (!isValidTeeth(input)) {
                System.out.print("Invalid teeth types, try again: ");
                continue;
            }
            teethArray = input.toCharArray();
            break;
        }

//  Return the valid array of teeth characters.
        return teethArray;
    } //  End of getValidTeeth method.

    /**
     * Check if the input teeth data is valid.
     * @param input Teeth data input
     * @return True if valid, false otherwise
     */
    private static boolean isValidTeeth(String input) {

//  Loop through each character of the input string to check if it is valid.
        for (char c : input.toCharArray()) {
            boolean valid = false;

//  Compare each character against valid teeth types ('I', 'B', 'M').
            for (char validChar : VALID_TEETH) {
                if (c == validChar) {
                    valid = true;
                    break;
                }
            }

//  Return false if any character is invalid.
            if (!valid) {
                return false;
            }
        }

//  Return true if all characters are valid teeth types.
        return true;
    } //  End of isValidTeeth method.

    /**
     * Get a valid menu option from the user.
     * @return Valid menu option
     */
    private static char getMenuOption() {
        System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it: ");

//  Continuously prompt the user for valid menu input.
        while (true) {
            char option = keyboard.nextLine().toUpperCase().charAt(0);

//  Return valid menu option if it matches 'P', 'E', 'R', or 'X'.
            if (option == 'P' || option == 'E' || option == 'R' || option == 'X') {
                return option;
            }
            System.out.print("Invalid menu option, try again: ");
        }
    } //  End of getMenuOption method.

    /**
     * Print the dental records of the family.
     */
    private static void printRecords() {

//  Loop through each family member and print their name and teeth data (uppers and lowers).
        for (int i = 0; i < familySize; i++) {
            System.out.println(names[i]);
            System.out.print("  Uppers: ");
            printTeeth(teeth[i][0]);
            System.out.print("  Lowers: ");
            printTeeth(teeth[i][1]);
        }
    } //  End of printRecords method.

    /**
     * Print the teeth data.
     * @param teethArray Array of teeth data
     */
    private static void printTeeth(char[] teethArray) {

//  Print each tooth's position and type in the format '1:I', '2:B', etc.
        for (int j = 0; j < teethArray.length; j++) {
            System.out.printf(" %d:%c", j + 1, teethArray[j]);
        }
        System.out.println();
    } //  End of printTeeth method.

    /**
     * Extract a tooth from a family member.
     */
    private static void extractTooth() {
        int memberIndex;

//  Prompt user to enter the name of the family member.
        System.out.print("Which family member: ");
        while (true) {
            String member = keyboard.nextLine();

//  Use getMemberIndex to retrieve the index of the family member from the names array.
            memberIndex = getMemberIndex(member);
            if (memberIndex != -1) {
                break;
            }
            System.out.print("Invalid family member, try again: ");
        }

        int layerIndex;

//  Prompt user to specify the layer (upper or lower) from which the tooth is to be extracted.
        System.out.print("Which tooth layer (U)pper or (L)ower: ");
        while (true) {
            char layer = keyboard.nextLine().toUpperCase().charAt(0);
            layerIndex = (layer == 'U') ? 0 : (layer == 'L') ? 1 : -1;
            if (layerIndex != -1) {
                break;
            }
            System.out.print("Invalid layer, try again: ");
        }

//  Prompt user to specify the tooth number to extract. Ensure valid input is provided.
        System.out.print("Which tooth number: ");
        while (true) {
            if (keyboard.hasNextInt()) {
                int toothNumber = keyboard.nextInt();
                keyboard.nextLine();

//  Ensure the tooth number is valid and that the tooth is not already missing ('M').
                if (toothNumber >= 1 && toothNumber <= teeth[memberIndex][layerIndex].length) {
                    if (teeth[memberIndex][layerIndex][toothNumber - 1] != 'M') {

//  Mark the tooth as missing ('M').
                        teeth[memberIndex][layerIndex][toothNumber - 1] = 'M';
                        break;
                    } else {
                        System.out.print("Missing tooth, try again: ");
                    }
                } else {
                    System.out.print("Invalid tooth number, try again: ");
                }
            } else {
                keyboard.nextLine();
                System.out.print("Invalid tooth number, try again: ");
            }
        }
    } //  End of extractTooth method.

    /**
     * Get the index of a family member by name.
     * @param member Name of the family member
     * @return Index of the family member, or -1 if not found
     */
    private static int getMemberIndex(String member) {

//  Loop through the names array to find the family member's index by name.
        for (int i = 0; i < familySize; i++) {
            if (names[i].equalsIgnoreCase(member)) {
                return i;
            }
        }

//  Return -1 if the family member is not found.
        return -1;
    } //  End of getMemberIndex method.

    /**
     * Report the root canal indices based on the teeth data.
     */
    private static void reportRootCanalIndices() {
        int I = 0, B = 0, M = 0;

//  Loop through all teeth of each family member, counting occurrences of 'I', 'B', and 'M'.
        for (int i = 0; i < familySize; i++) {
            for (char tooth : teeth[i][0]) { // For upper teeth
                if (tooth == 'I') I++;
                else if (tooth == 'B') B++;
                else if (tooth == 'M') M++;
            }
            for (char tooth : teeth[i][1]) { // For lower teeth
                if (tooth == 'I') I++;
                else if (tooth == 'B') B++;
                else if (tooth == 'M') M++;
            }
        }

//  Calculate the discriminant for root canal index based on tooth counts.
        double discriminant = B * B + 4 * I * M;

//  Check if the discriminant is negative (no real roots), otherwise calculate and print roots.
        if (discriminant < 0) {
            System.out.println("No real roots");
        } else {
            double root1 = (-B + Math.sqrt(discriminant)) / (2 * I);
            double root2 = (-B - Math.sqrt(discriminant)) / (2 * I);
            System.out.printf("One root canal at %.2f\n", root1);
            System.out.printf("Another root canal at %.2f\n", root2);
        }
    } //  End of reportRootCanalIndices method.
}