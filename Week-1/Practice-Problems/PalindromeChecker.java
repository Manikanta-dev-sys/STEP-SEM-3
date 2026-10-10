import java.util.Scanner;

/**
 * Problem 2: Palindrome Checker (3 Approaches)
 * Scenario: The QA Text Verification Toolkit
 * 
 * Verifies whether a given string is a palindrome using three independent methods:
 * 1. Iterative comparison (two-pointer approach)
 * 2. Recursive comparison
 * 3. Array reversal comparison
 * Confirms that all three approaches agree on the result.
 */
public class PalindromeChecker {

    /**
     * Checks palindrome using iterative two-pointer approach from both ends.
     * 
     * @param text String to verify
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Checks palindrome recursively by comparing outer characters and shrinking the substring.
     * 
     * @param text String to verify
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Checks palindrome by converting to a character array, reversing it, and comparing.
     * 
     * @param text String to verify
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runs all three checks on the given text and prints the results in standard format.
     * 
     * @param text String to evaluate
     */
    public static void displayVerification(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean rev = isPalindromeArrayReversal(text);

        String iterResult = iter ? "Palindrome" : "Not Palindrome";
        String recurResult = recur ? "Palindrome" : "Not Palindrome";
        String revResult = rev ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"%n", text);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                iterResult, recurResult, revResult);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   QA Text Verification Toolkit - Palindrome Checker");
        System.out.println("=================================================\n");

        System.out.println("--- Standard Test Cases ---");
        displayVerification("madam");
        displayVerification("hello");
        displayVerification("racecar");
        displayVerification("step");

        // Optional interactive verification when run in an interactive terminal
        if (System.console() != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your own string to verify (or press Enter to finish): ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    System.out.println("\n--- User Input Result ---");
                    displayVerification(input);
                }
            }
        }
    }
}
