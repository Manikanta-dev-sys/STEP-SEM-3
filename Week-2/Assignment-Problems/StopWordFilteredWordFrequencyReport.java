import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Week 2 Assignment - Problem 5: Stop-Word-Filtered Word Frequency Report
 * Scenario: T&P Team Feedback Analysis
 * 
 * Cleans feedback text, filters out common filler stop words ("the", "was", "and",
 * "a", "is", "of", "in"), counts frequencies of meaningful words, and prints
 * the report sorted by frequency in descending order.
 */
public class StopWordFilteredWordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Cleans feedback text, removes punctuation and stop-words, counts word frequencies,
     * and prints words sorted by occurrence count descending.
     * 
     * @param feedback Paragraph of feedback text
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No feedback content provided.");
            return;
        }

        // 1. Normalize: lowercase and strip punctuation using replace()
        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", "")
                         .replace(",", "")
                         .replace("!", "")
                         .replace("?", "")
                         .replace(";", "")
                         .replace(":", "")
                         .replace("\"", "");

        // 2. Split cleaned text into words by whitespace
        String[] words = cleaned.trim().split("\\s+");

        // 3. Count frequencies, skipping stop words
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            String trimmedWord = word.trim();
            if (trimmedWord.isEmpty() || STOP_WORDS.contains(trimmedWord)) {
                continue;
            }
            frequencyMap.put(trimmedWord, frequencyMap.getOrDefault(trimmedWord, 0) + 1);
        }

        // 4. Sort unique words by count descending
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // 5. Print results
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Stop-Word-Filtered Word Frequency Report      ");
        System.out.println("=================================================\n");

        // Test Case 1: Sample from PDF
        String feedback1 = "The mentor was great, the session was great and clear.";
        System.out.printf("Input: \"%s\"%nOutput:%n", feedback1);
        printFilteredWordFrequency(feedback1);
        System.out.println();

        // Test Case 2: Additional test case
        String feedback2 = "Java is powerful, Java is versatile, and programming in Java is enjoyable.";
        System.out.printf("Input: \"%s\"%nOutput:%n", feedback2);
        printFilteredWordFrequency(feedback2);
    }
}
