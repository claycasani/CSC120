import java.util.Scanner;

/**
 * Determine the total sum of the age of people who live on a street
 * @author Clay Casani
 */

public class DurbanStreetPeople {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

//  Variables to hold system values
        int numHouses, numPeople, rowIndex, colIndex, totalStreetAge, houseNumber, totalHouseAge;

//  Gather number of houses on street and assign to numHouses.
        System.out.print("How many houses on the street? :  ");
        numHouses = keyboard.nextInt();

//  Initialize 2D array with numHouses of rows and 11 columns.
//  This is assuming the maximum number of people in a house is 10 with an extra column for the house number.
        int[][]  streetData = new int[numHouses][11];

// Gather the house numbers and assign to first column of each row.
        for (rowIndex = 0; rowIndex < numHouses; rowIndex++) {
            System.out.print("What is the next house number? :  ");
            streetData[rowIndex][0] = keyboard.nextInt();
        }
// Gather the number of people who live in each house and assign to numPeople.
        for (rowIndex = 0; rowIndex < numHouses; rowIndex++) {
            System.out.print("How many people live in number " + streetData[rowIndex][0] + "? :  ");
            numPeople = keyboard.nextInt();

// Gather the ages of each person in each house.
            for (colIndex = 0; colIndex < numPeople; colIndex++) {
                System.out.print("What is age of person " + (colIndex + 1) + "? :  ");
                streetData[rowIndex][colIndex + 1] = keyboard.nextInt();
            }
        }

        totalStreetAge = 0;

//  Sum ages of all people living in each house and display. Sum of ages of all houses to find total street age.
        for (rowIndex = 0; rowIndex < numHouses; rowIndex++) {
            totalHouseAge = 0;
            houseNumber = streetData[rowIndex][0];

            for (colIndex = 1; colIndex < 11; colIndex++) {
                totalHouseAge += streetData[rowIndex][colIndex];
            }
            totalStreetAge += totalHouseAge;
            System.out.println("House " + houseNumber + " has a total age of " + totalHouseAge);
        }

// Display total street age.
        System.out.println("The street has a total age of " + totalStreetAge);

    } // End of main method
}  // End of Java class
