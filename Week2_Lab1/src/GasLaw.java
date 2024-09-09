import java.util.Scanner;

public class GasLaw {
    private static Scanner keyboard = new Scanner(System.in);
// The gas constant in Joules/mole/ K
    private static final double GAS_CONSTANT = 8.3143;

    public static void main(String[] args) {

// Variables to hold system values
        double volume, moles, temp;
        double pressure;

// Gather data values for volume, moles, and temperature
        System.out.print("Enter volume, moles, temperature: ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temp = keyboard.nextDouble();

// Perform pressure calculation
        pressure = moles * GAS_CONSTANT * temp / volume;

// Print pressure value
        System.out.println("Pressure is " + pressure);
    }
}

