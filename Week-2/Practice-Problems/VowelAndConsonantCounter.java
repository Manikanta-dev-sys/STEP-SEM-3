/**
 * Week 2 Practice - Problem 1: Vowel & Consonant Counter
 * Scenario: Library Orientation Kiosk Text-Stats Display
 * 
 * Counts vowels and consonants in a book title string using charAt() and
 * case-insensitive comparisons, ignoring whitespace.
 */
public class VowelAndConsonantCounter {

    /**
     * Counts and displays the number of vowels and consonants in the given text.
     * 
     * @param text The input string (book title or phrase)
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Invalid input: Text cannot be null.");
            return;
        }

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Ignore whitespace and non-letter characters
            if (Character.isWhitespace(ch)) {
                continue;
            }

            char lowerCh = Character.toLowerCase(ch);

            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                vowelCount++;
            } else if (Character.isLetter(lowerCh)) {
                consonantCount++;
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowelCount, consonantCount);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          Vowel & Consonant Counter              ");
        System.out.println("=================================================\n");

        // Test Case 1: Sample from PDF
        String input1 = "Java Programming";
        System.out.printf("Input: \"%s\"%nOutput: ", input1);
        countVowelsAndConsonants(input1);
        System.out.println();

        // Test Case 2: Additional book title test case
        String input2 = "The Great Gatsby";
        System.out.printf("Input: \"%s\"%nOutput: ", input2);
        countVowelsAndConsonants(input2);
        System.out.println();

        // Test Case 3: Vowels and consonants with uppercase and lowercase
        String input3 = "Data Structures and Algorithms";
        System.out.printf("Input: \"%s\"%nOutput: ", input3);
        countVowelsAndConsonants(input3);
    }
}
