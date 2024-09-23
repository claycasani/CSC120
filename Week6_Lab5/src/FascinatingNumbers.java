import java.util.Scanner;

/**
 * Determine if numbers in an array from user input are prime or Fibonacci
 * @author Clay Casani
 */

public class FascinatingNumbers {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
// Initialize array
        int[] numbers = new int[10];
// Variables to hold values
        int count, num;
        boolean isFibonacci, isPrime;

// The number of integers entered into the array.
        count = getUserInput(numbers);

// Determine if numbers in array are Fibonacci or prime
        for (int i = 0; i < count; i++) {
            num = numbers[i];
            isFibonacci = isFibonacci(num);
            isPrime = isPrime(num);

// Output whether the numbers in array are prime or Fibonacci
            if (isFibonacci && isPrime) {
                System.out.println(num + " is Fibonacci and is prime");
            } else if (isFibonacci && !isPrime) {
                System.out.println(num + " is Fibonacci and is not prime");
            } else if (!isFibonacci && isPrime) {
                System.out.println(num + " is not Fibonacci and is prime");
            } else {
                System.out.println(num + " is not Fibonacci and is not prime");
            }
        }
    }

    /**
     * Gather user input and store up to 10 integers in an array.
     * @param numbers The array to store the enter integers.
     * @return The number of integers entered by the user.
     */
    private static int getUserInput(int[] numbers) {
        int count = 0;
        int input;

        do {
            System.out.println("Enter an integer (0 to stop): ");
            input = keyboard.nextInt();
            if (input == 0) {
                break;
            }
            numbers[count] = input;
            count++;
        } while (count < 10);
        return count;
    }

    // Method to determine if a number is Fibonacci

    /**
     * Determine if number is Fibonacci.
     * @param num The number to be tested.
     * @return true If the number is a Fibonacci number, false otherwise.
     */
    private static boolean isFibonacci(int num) {
        int a = 0;
        int b = 1;
        int next;

        if (num < 0) {
            return false;
        }
        while (a <= num) {
            if (a == num) {
                return true;
            }
            next = a + b;
            a = b;
            b = next;
        }
        return false;
    }

    /**
     * Determine if number is prime.
     * @param num The number to be tested.
     * @return true If the number is a prime number, false otherwise.
     */
    // Method to determine if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// End of class