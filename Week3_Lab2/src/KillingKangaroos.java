import java.util.Scanner;

public class KillingKangaroos {
    private static Scanner scanner = new Scanner(System.in);
// Roadkill constant
    private static final double ROADKILL_CONSTANT = 1.47;
// Average road width in km
    private static final double ROAD_WIDTH = 0.01;

    public static void main(String[] args) {

// Variables to hold system values
        double sideLand, roadLength, numKangaroos, rooDensity, area, surfaceArea, deaths, injuries;
        int expectedDeaths, expectedInjuries;

// Gather data for system values
        System.out.print("Enter side of square in km: ");
        sideLand = scanner.nextDouble();
        System.out.print("Enter roads length in km: ");
        roadLength = scanner.nextDouble();
        System.out.print("Enter number of 'roos: ");
        numKangaroos = scanner.nextDouble();

// Calculate area, surface area, and kanagroo density
        area = sideLand * sideLand;
        rooDensity = numKangaroos / area;
        surfaceArea = roadLength * ROAD_WIDTH;

// Compute deaths and injuries as decimal
        deaths = surfaceArea * rooDensity * ROADKILL_CONSTANT;

// Convert decimal into deaths and injuries integer
        expectedDeaths = (int) deaths;
        injuries = (deaths - expectedDeaths);

        expectedInjuries = (injuries > 0) ? 1 : 0;

// Display number of deaths and injuries
        System.out.println("Expected number of kills is: " + expectedDeaths);
        System.out.println("Expected number of injuries is: " + expectedInjuries);

    }
}
