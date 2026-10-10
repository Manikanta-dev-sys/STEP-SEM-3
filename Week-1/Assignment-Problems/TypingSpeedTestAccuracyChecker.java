/**
 * Week 1 Assignment - Problem 2: The Typing Speed Test Accuracy Checker
 * Scenario: Online Typing Practice Website
 * 
 * Compares a user's submitted typing attempt character-by-character against
 * an original passage to calculate accuracy and identify the position of the
 * first mismatch.
 */
public class TypingSpeedTestAccuracyChecker {

    /**
     * Compares original text with typed text, calculates accuracy percentage,
     * and reports the position of the first mismatch.
     * 
     * @param original The expected reference string
     * @param typed    The user's typed string
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: Strings cannot be null.");
            return;
        }

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;
        char originalChar = ' ';
        char typedChar = ' ';

        int compareLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < compareLength; i++) {
            char o = original.charAt(i);
            char t = typed.charAt(i);

            if (o == t) {
                matchedCharacters++;
            } else {
                if (firstMismatchPosition == -1) {
                    firstMismatchPosition = i + 1; // 1-based position as per problem sample
                    originalChar = o;
                    typedChar = t;
                }
            }
        }

        if (firstMismatchPosition == -1 && original.length() != typed.length()) {
            firstMismatchPosition = compareLength + 1;
        }

        double accuracy = (totalCharacters > 0)
                ? ((double) matchedCharacters / totalCharacters) * 100.0
                : 0.0;

        if (firstMismatchPosition != -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matchedCharacters, totalCharacters, accuracy, firstMismatchPosition, originalChar, typedChar);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matchedCharacters, totalCharacters, accuracy);
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     Typing Speed Test Accuracy Checker          ");
        System.out.println("=================================================\n");

        // Test Case 1: Sample from PDF with mismatch
        String original1 = "hello world";
        String typed1 = "hello worlt";
        System.out.printf("original=\"%s\", typed=\"%s\"%n", original1, typed1);
        checkTypingAccuracy(original1, typed1);
        System.out.println();

        // Test Case 2: Sample from PDF with perfect match
        String original2 = "coding";
        String typed2 = "coding";
        System.out.printf("original=\"%s\", typed=\"%s\"%n", original2, typed2);
        checkTypingAccuracy(original2, typed2);
        System.out.println();

        // Test Case 3: Additional test case
        String original3 = "Java Programming";
        String typed3 = "Java Proqramming";
        System.out.printf("original=\"%s\", typed=\"%s\"%n", original3, typed3);
        checkTypingAccuracy(original3, typed3);
    }
}
