import java.util.Scanner;

public class NitroxSCUBA {
    private static Scanner scanner = new Scanner(System.in);

// Constants
    private static final int FEET_PER_ATMOSPHERE = 33;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;
    private static final double MAX_O2_PRESSURE = 1.4;

// Variables to hold system values
    int depth, oxygenPercentage;
    double ambientPressure, partialPressure;
    boolean exceedsMaxO2Pressure, exceedsMaxContingencyPressure;
    char pressureGroup;

    public static void main(String[] args) {

        NitroxSCUBA nitroxSCUBA = new NitroxSCUBA();
// Get depth and oxygen percentage
        System.out.print("Enter depth and percentage O2: ");
        nitroxSCUBA.depth = scanner.nextInt();
        nitroxSCUBA.oxygenPercentage = scanner.nextInt();
// Calculate ambient pressure and partial pressure
        nitroxSCUBA.ambientPressure = (nitroxSCUBA.depth / FEET_PER_ATMOSPHERE) + 1;
        nitroxSCUBA.partialPressure = (nitroxSCUBA.oxygenPercentage / 100.0) * nitroxSCUBA.ambientPressure;

        nitroxSCUBA.pressureGroup = nitroxSCUBA.computePressureGroup(nitroxSCUBA.partialPressure);
// Determine pressure 
        nitroxSCUBA.exceedsMaxO2Pressure = nitroxSCUBA.partialPressure > MAX_O2_PRESSURE;
        nitroxSCUBA.exceedsMaxContingencyPressure = nitroxSCUBA.partialPressure > CONTINGENCY_O2_PRESSURE;

        System.out.println("Ambient pressure                : " + nitroxSCUBA.ambientPressure);
        System.out.println("O2 pressure                     : " + nitroxSCUBA.partialPressure);
        System.out.println("O2 group                        : " + nitroxSCUBA.pressureGroup);
        System.out.println("Exceeds maximal O2 pressure     : " + nitroxSCUBA.exceedsMaxO2Pressure);
        System.out.println("Exceeds contingency O2 pressure : " + nitroxSCUBA.exceedsMaxContingencyPressure);

    }

    private char computePressureGroup(double partialPressure) {
        int groupOffset = (int) (partialPressure /0.1);
        char group = (char) ('A' + groupOffset);

        return group;
    }
}
