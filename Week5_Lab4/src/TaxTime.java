import java.util.Scanner;

public class TaxTime {
    private static Scanner keyboard = new Scanner(System.in);

// Tax rate constants
    private static final double S_Q_TAX_RATE = 0.25;
    private static final double M_TAX_RATE = 0.10;
    private static final double A_R_TAX_RATE = 0.3;

    public static void main(String[] args) {

// Variables to hold system values
        double income = 0.0;
        double deduction = 0.0;
        double taxableIncome, taxOwed = 0.0;
        int value;
        char taxGroup;

// Gather income and deduction values
        System.out.print("Enter next amount: ");
        value = keyboard.nextInt();
        while (value != 0) {
            if (value > 0) {
                income += value;
            } else if (value < 0) {
                deduction += Math.abs(value);
            }
            System.out.print("Enter next amount: ");
            value = keyboard.nextInt();
        }

// Calculate taxable income
        if (income > deduction) {
            taxableIncome = income - deduction;
        }
        else {
            taxableIncome = 0;
        }

// Determine tax group
        if (taxableIncome >= 500000) {
            taxGroup = 'S';
        }
        else if (taxableIncome >= 200000) {
            taxGroup = 'Q';
        }
        else if (taxableIncome >= 100000) {
            taxGroup = 'M';
        }
        else if (taxableIncome >= 50000) {
            taxGroup = 'A';
        }
        else if (taxableIncome >= 20000) {
            taxGroup = 'R';
        }
        else {
            taxGroup = 'P';
        }

// Calculate tax owed
        switch (taxGroup) {
            case 'S':
                taxOwed = taxableIncome * S_Q_TAX_RATE;
                break;
            case 'Q':
                taxOwed = taxableIncome * S_Q_TAX_RATE ;
                break;
            case 'M':
                taxOwed = taxableIncome * M_TAX_RATE;
                break;
            case 'A':
                taxOwed = taxableIncome * A_R_TAX_RATE;
                break;
            case 'R':
                taxOwed = taxableIncome * A_R_TAX_RATE;
                break;
            case 'P':
                taxOwed = 0;
                break;
            default:
                System.out.println("Error!");
        }

// Line break for output
       System.out.println();

// Display tax information
        System.out.printf("Income         = $%.1f\n", income);
        System.out.printf("Deductions     = $%.1f\n", deduction);
        System.out.printf("Taxable income = $%.1f\n", taxableIncome);
        System.out.println("Tax group      = " + taxGroup);
        System.out.printf("Tax owed       = $%.1f\n", taxOwed);

    }
}

