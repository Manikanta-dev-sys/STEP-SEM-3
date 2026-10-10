import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem 4: First Non-Repeating Character
 * Scenario: The Unique Letter Hunt Mini-Game
 * 
 * Computes frequency of all characters in a string and finds the first character
 * (from left to right) that occurs exactly once.
 */
public class FirstNonRepeatingCharacter {

    /**
     * Finds the first character in the string whose frequency is exactly 1.
     * 
     * @param text The input string
     * @return The first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Count character frequencies
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Scan from left to right to find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        return '\0'; // Sentinel when no non-repeating character exists
    }

    /**
     * Evaluates the string and prints output matching the problem specification.
     * 
     * @param text String to inspect
     */
    public static void displayResult(String text) {
        System.out.printf("Input: \"%s\"%n", text);
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'%n%n", result);
        } else {
            System.out.println("No Non-Repeating Character Found\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      Unique Letter Hunt - Character Hunter      ");
        System.out.println("=================================================\n");

        System.out.println("--- Test Cases ---");
        displayResult("swiss");
        displayResult("aabbcc");
        displayResult("programming");
        displayResult("stress");

        // Interactive mode when run in a terminal console
        if (System.console() != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your own text (or press Enter to finish): ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    System.out.println("\n--- User Input Result ---");
                    displayResult(input);
                }
            }
        }
    }
}
