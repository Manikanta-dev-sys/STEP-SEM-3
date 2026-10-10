import java.util.Scanner;

/**
 * Problem 5: Reverse Customer Name
 * Scenario: The Customer Identity Verification System
 * 
 * Reverses a customer's name character-by-character to verify sequence processing
 * integrity in a banking system module while keeping the original string intact.
 */
public class ReverseCustomerName {

    /**
     * Reverses the given customer name using character traversal and array manipulation.
     * The original string remains immutable and unmodified.
     * 
     * @param customerName The customer's original name
     * @return The reversed customer name string
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] originalChars = customerName.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    /**
     * Helper method to display original and reversed customer names.
     * 
     * @param customerName Customer name to test
     */
    public static void displayReversal(String customerName) {
        String reversed = reverseCustomerName(customerName);
        System.out.printf("Original Name: %s%n", customerName);
        System.out.printf("Reversed Name: %s%n%n", reversed);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Customer Identity Verification System - Reversal");
        System.out.println("=================================================\n");

        System.out.println("--- Standard Verification Test Cases ---");
        // Sample test case from problem statement
        displayReversal("Sunil");
        displayReversal("Alexander");
        displayReversal("Grace Hopper");

        // Interactive verification when run in a terminal console
        if (System.console() != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a customer name to reverse (or press Enter to finish): ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    System.out.println("\n--- User Input Result ---");
                    displayReversal(input);
                }
            }
        }
    }
}
