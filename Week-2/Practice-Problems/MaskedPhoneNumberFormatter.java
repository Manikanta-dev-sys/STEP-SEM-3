/**
 * Week 2 Practice - Problem 4: Masked Phone Number Formatter
 * Scenario: Student-Support Call Center Privacy Masking
 * 
 * Validates a 10-digit phone number and builds a masked display string ("XXXXXX-1234")
 * using StringBuilder and insert() for identity verification while preserving privacy.
 */
public class MaskedPhoneNumberFormatter {

    /**
     * Validates and creates a masked representation of a 10-digit phone number.
     * 
     * @param phone The input phone number string
     * @return Formatted masked string "XXXXXX-XXXX" or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate that all characters are numeric digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Build masked string using StringBuilder
        StringBuilder maskedBuilder = new StringBuilder();
        maskedBuilder.append("XXXXXX");
        maskedBuilder.append(phone.substring(6)); // Last 4 digits

        // Insert hyphen delimiter between mask and last 4 digits using StringBuilder insert()
        maskedBuilder.insert(6, "-");

        return maskedBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("         Masked Phone Number Formatter           ");
        System.out.println("=================================================\n");

        // Test Case 1: Valid 10-digit number (Sample from PDF)
        String phone1 = "9876543210";
        System.out.printf("Input: \"%s\" -> Output: %s%n", phone1, maskPhoneNumber(phone1));

        // Test Case 2: Incomplete phone number (Sample from PDF)
        String phone2 = "98765";
        System.out.printf("Input: \"%s\" -> Output: %s%n", phone2, maskPhoneNumber(phone2));

        // Test Case 3: Phone number containing non-digits
        String phone3 = "987654321A";
        System.out.printf("Input: \"%s\" -> Output: %s%n", phone3, maskPhoneNumber(phone3));

        // Test Case 4: Another valid 10-digit number
        String phone4 = "9123456789";
        System.out.printf("Input: \"%s\" -> Output: %s%n", phone4, maskPhoneNumber(phone4));
    }
}
