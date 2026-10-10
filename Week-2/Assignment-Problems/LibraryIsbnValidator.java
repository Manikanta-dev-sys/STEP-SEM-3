/**
 * Week 2 Assignment - Problem 4: Library ISBN Normalizer & Validator
 * Scenario: Library Book-Intake Scanner
 * 
 * Normalizes and validates 13-character ISBN-style codes:
 * - 3 letters (Publisher Code)
 * - 4 digits (Year)
 * - 6 digits (Catalog Number)
 * Normalizes via trim() and substring() uppercase concatenation, validates character-by-character
 * in loops without regex, and outputs formatted display string using StringBuilder.
 */
public class LibraryIsbnValidator {

    /**
     * Trims whitespace and uppercases only the first 3 characters of the code.
     * 
     * @param raw The raw scanned code string
     * @return Normalized code string, or null if raw is null
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        // Uppercase only the first 3 characters using substring() + concatenation
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates the normalized 13-character code and builds formatted output line.
     * Reports specific failure reasons if validation fails.
     * 
     * @param code The normalized code string
     * @return Formatted display line or specific validation error message
     */
    public static String validateAndFormat(String code) {
        if (code == null) {
            return "Invalid: code cannot be null";
        }

        // 1. Length validation (must be exactly 13 characters)
        if (code.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        // 2. Publisher code validation (first 3 characters must be letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // 3. Body validation (remaining 10 characters must be digits - no regex)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body (year and catalog must be digits)";
            }
        }

        // Extract components: 3 letters + 4 digits (year) + 6 digits (catalog)
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Build formatted line with StringBuilder
        StringBuilder displayLine = new StringBuilder();
        displayLine.append("[").append(pubCode).append("] ");
        displayLine.append("YEAR: ").append(year);
        displayLine.append(" | CATALOG: ").append(catalog);

        return displayLine.toString();
    }

    /**
     * Convenience method to normalize, validate, and format in a single call.
     * 
     * @param raw Raw input code
     * @return Formatted string or validation error message
     */
    public static String processCode(String raw) {
        String normalized = normalizeCode(raw);
        return validateAndFormat(normalized);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("       Library ISBN Normalizer & Validator       ");
        System.out.println("=================================================\n");

        // Test Case 1: Valid input with padding and lowercase publisher (Sample from PDF)
        String code1 = " pen2026004251 ";
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", code1, processCode(code1));

        // Test Case 2: Non-letter publisher code (Sample from PDF)
        String code2 = "12N2026004251";
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", code2, processCode(code2));

        // Test Case 3: Invalid length
        String code3 = "OXF202512";
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", code3, processCode(code3));

        // Test Case 4: Non-digit body
        String code4 = "MIT2025AB4251";
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", code4, processCode(code4));

        // Test Case 5: Another valid ISBN-style code
        String code5 = " col2024109823 ";
        System.out.printf("Input: \"%s\"%nOutput: %s%n", code5, processCode(code5));
    }
}
