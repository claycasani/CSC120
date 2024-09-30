import java.util.Scanner;

public class Practice {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] arg) {

        System.out.println("PRACTICE ARRAYS");

        // Declaring an array
        int [] myArray = new int[3];

        // update array
        int i;
        for (i = 0; i < myArray.length; i++) {
            System.out.println("At index " + i + ": Enter a number:");
            myArray[i] = keyboard.nextInt();
        }

        // Display array
        for (i = 0; i < myArray.length; i++) {
            System.out.println("At index " + i + ": The value is: " + myArray[i]);
        }

    }

    private static void updateMyArray (int [] myArray) {

        // Declaring an array
        int [] mySecondArray = new int[3];

        // update array
        int rowIndex;
        int colIndex;
        for (rowIndex = 0; rowIndex < myArray.length; rowIndex++) {
            for (colIndex = 0; colIndex < myArray.length; colIndex++) {
                System.out.println("At index [" + rowIndex + "][" + colIndex + "] : Enter a number: ");
            }

            System.out.println("At index " + rowIndex + ": Enter a number:");
            myArray[rowIndex] = keyboard.nextInt();
        }

        // Display array
        for (rowIndex = 0; rowIndex < myArray.length; rowIndex++) {
            System.out.println("At index " + rowIndex + ": The value is: " + myArray[rowIndex]);
        }

    }

}
