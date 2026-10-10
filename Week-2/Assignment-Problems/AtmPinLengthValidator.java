/**
 * Week 2 Assignment - Problem 1: ATM PIN Length Validator
 * Scenario: ATM Customer Input Pre-check
 * 
 * Validates that an entered PIN string is exactly 4 characters in length
 * using length() and a single if/else conditional check (no loops).
 */
public class AtmPinLengthValidator {

    /**
     * Checks the length of a PIN string and prints whether it meets the 4-digit requirement.
     * 
     * @param pin The customer-entered PIN string
     */
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN \u2014 must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("            ATM PIN Length Validator             ");
        System.out.println("=================================================\n");

        // Test Case 1: Less than 4 characters (Sample from PDF)
        String pin1 = "482";
        System.out.printf("Input: \"%s\"%nOutput: ", pin1);
        checkPinLength(pin1);
        System.out.println();

        // Test Case 2: Exactly 4 characters (Sample from PDF)
        String pin2 = "4820";
        System.out.printf("Input: \"%s\"%nOutput: ", pin2);
        checkPinLength(pin2);
        System.out.println();

        // Test Case 3: More than 4 characters
        String pin3 = "12345";
        System.out.printf("Input: \"%s\"%nOutput: ", pin3);
        checkPinLength(pin3);
        System.out.println();

        // Test Case 4: Null input
        System.out.print("Input: null\nOutput: ");
        checkPinLength(null);
    }
}
