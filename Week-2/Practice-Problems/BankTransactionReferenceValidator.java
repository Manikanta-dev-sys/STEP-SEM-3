/**
 * Week 2 Practice - Problem 5: Bank Transaction Reference Generator & Validator
 * Scenario: Fintech Onboarding Module
 * 
 * Normalizes and validates 14-character transaction reference codes:
 * - 3 letters (Bank Code)
 * - 6 digits (Date in ddMMyy format)
 * - 5 digits (Sequence Number)
 * Normalizes via trim() and substring() uppercase concatenation, performs multi-stage
 * character validation using loops (no regex), and formats with StringBuilder.
 */
public class BankTransactionReferenceValidator {

    /**
     * Trims leading/trailing whitespace and uppercases only the first 3 characters
     * using substring() and concatenation, leaving the rest untouched.
     * 
     * @param raw Raw input reference string
     * @return Normalized reference string, or null if input is null
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase first 3 characters and preserve the rest
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates the normalized 14-character reference code and builds the formatted display line.
     * Reports specific failure reasons if invalid.
     * 
     * @param reference Normalized reference string
     * @return Formatted display string or specific validation error message
     */
    public static String validateAndFormat(String reference) {
        if (reference == null) {
            return "Invalid: reference cannot be null";
        }

        // 1. Length validation
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        // 2. Bank code letter validation (first 3 characters using Character.isLetter)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // 3. Body digit validation (remaining 11 characters using Character.isDigit in a loop - no regex)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        // Extract components using substring()
        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String sequence = reference.substring(9, 14);

        // Build formatted display line using StringBuilder
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(bankCode).append("] ");
        formatted.append("DATE: ").append(day).append("/").append(month).append("/").append(year);
        formatted.append(" | SEQ: ").append(sequence);

        return formatted.toString();
    }

    /**
     * Convenience method to normalize, validate, and format in one step.
     * 
     * @param raw Raw reference input
     * @return Formatted line or error message
     */
    public static String processTransactionReference(String raw) {
        String normalized = normalizeReference(raw);
        return validateAndFormat(normalized);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Bank Transaction Reference Validator          ");
        System.out.println("=================================================\n");

        // Test Case 1: Sample from PDF with spaces and lowercase bank code
        String input1 = " hdf03022600042 ";
        System.out.printf("Input: \"%s\"%n", input1);
        String norm1 = normalizeReference(input1);
        System.out.printf("Normalized: \"%s\"%n", norm1);
        System.out.printf("Output: %s%n%n", validateAndFormat(norm1));

        // Test Case 2: Sample from PDF with invalid bank code (digits instead of letters)
        String input2 = "12F03022600042";
        System.out.printf("Input: \"%s\"%n", input2);
        String norm2 = normalizeReference(input2);
        System.out.printf("Output: %s%n%n", validateAndFormat(norm2));

        // Test Case 3: Invalid length
        String input3 = "SBI0101";
        System.out.printf("Input: \"%s\"%n", input3);
        System.out.printf("Output: %s%n%n", processTransactionReference(input3));

        // Test Case 4: Non-digit body
        String input4 = "ICICI0302260004";
        System.out.printf("Input: \"%s\"%n", input4);
        System.out.printf("Output: %s%n%n", processTransactionReference(input4));

        // Test Case 5: Another valid reference (3 letters + 6 digits date + 5 digits seq)
        String input5 = " sbi15082699999 ";
        System.out.printf("Input: \"%s\"%n", input5);
        System.out.printf("Output: %s%n", processTransactionReference(input5));
    }
}
