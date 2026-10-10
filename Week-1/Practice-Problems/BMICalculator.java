/**
 * Problem 3: BMI Calculator for a Team
 * Scenario: The Corporate Wellness Program
 * 
 * Computes Body Mass Index (BMI) and health classification status for a team of
 * employees, presenting the results in a formatted wellness report table.
 */
public class BMICalculator {

    /**
     * Calculates BMI value from weight and height.
     * Formula: BMI = weight / (height * height)
     * 
     * @param height Height in meters
     * @param weight Weight in kilograms
     * @return Calculated BMI
     */
    public static double calculateBmi(double height, double weight) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Height and weight must be positive values.");
        }
        return weight / (height * height);
    }

    /**
     * Classifies BMI status based on standard health criteria:
     * - BMI < 18.5: Underweight
     * - 18.5 <= BMI < 25.0: Normal
     * - 25.0 <= BMI < 30.0: Overweight
     * - BMI >= 30.0: Obese
     * 
     * @param bmi Calculated BMI
     * @return Classification category
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Prints a comprehensive, clean tabular wellness report for the team.
     * 
     * @param heights Array of heights in meters
     * @param weights Array of weights in kilograms
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must be non-null and of equal length.");
        }

        System.out.println("==========================================================================");
        System.out.println("                   CORPORATE WELLNESS PROGRAM REPORT                      ");
        System.out.println("==========================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Team of 10 members with diverse representative profiles
        // (Includes sample inputs from the problem description: Person 1 (1.75m, 70kg), Person 2 (1.60m, 90kg))
        double[] heights = {
            1.75, // Person 1: Normal (BMI 22.86)
            1.60, // Person 2: Obese (BMI 35.16)
            1.82, // Person 3: Normal
            1.68, // Person 4: Overweight
            1.55, // Person 5: Underweight
            1.70, // Person 6: Overweight
            1.80, // Person 7: Obese
            1.65, // Person 8: Normal
            1.78, // Person 9: Normal
            1.50  // Person 10: Underweight
        };

        double[] weights = {
            70.0, // Person 1
            90.0, // Person 2
            74.0, // Person 3
            76.0, // Person 4
            42.0, // Person 5
            82.0, // Person 6
            102.0,// Person 7
            58.0, // Person 8
            68.0, // Person 9
            39.0  // Person 10
        };

        // Display individual sample highlights matching problem statement
        System.out.println("--- Individual Highlights ---");
        for (int i = 0; i < 2; i++) {
            double bmi = calculateBmi(heights[i], weights[i]);
            System.out.printf("Person %d \u2014 Height: %.2f m, Weight: %.2f kg -> BMI: %.2f | Status: %s%n",
                    (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
        System.out.println();

        // Print full team wellness report table
        printWellnessReport(heights, weights);
    }
}
