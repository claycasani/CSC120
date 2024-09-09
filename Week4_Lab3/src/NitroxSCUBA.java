import java.util.Scanner;

public class NitroxSCUBA {
    private static Scanner scanner = new Scanner(System.in);

// Constants
    private static final int FEET_PER_ATMOSPHERE = 33;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;
    private static final double MAX_O2_PRESSURE = 1.4;

    public static void main(String[] args) {

// Variables to hold system values
    int depth, oxygenPercentage;
    double ambientPressure, partialPressure;
    boolean exceedsMaxO2Pressure, exceedsMaxContingencyPressure;
    char pressureGroup;

// Get depth and oxygen percentage
        System.out.print("Enter depth and percentage O2: ");
        depth = scanner.nextInt();
        oxygenPercentage = scanner.nextInt();
// Calculate ambient pressure and partial pressure
       ambientPressure = (depth / FEET_PER_ATMOSPHERE) + 1;
       partialPressure = (oxygenPercentage / 100.0) * ambientPressure;

        pressureGroup =computePressureGroup(partialPressure);
// Determine pressure 
        exceedsMaxO2Pressure = partialPressure > MAX_O2_PRESSURE;
        exceedsMaxContingencyPressure = partialPressure > CONTINGENCY_O2_PRESSURE;

        System.out.println("Ambient pressure                : " + ambientPressure);
        System.out.println("O2 pressure                     : " + partialPressure);
        System.out.println("O2 group                        : " + pressureGroup);
        System.out.println("Exceeds maximal O2 pressure     : " + exceedsMaxO2Pressure);
        System.out.println("Exceeds contingency O2 pressure : " + exceedsMaxContingencyPressure);

    }

    private static char computePressureGroup(double partialPressure) {
        int groupOffset = (int) (partialPressure /0.1);
        char group = (char) ('A' + groupOffset);

        return group;
    }
}
