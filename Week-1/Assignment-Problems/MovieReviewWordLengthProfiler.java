/**
 * Week 1 Assignment - Problem 5: The Movie Review Word Length Profiler
 * Scenario: Movie-Review Platform Moderation Tool
 * 
 * Splits a submitted review into words, categorizes each word by length into:
 * - Short (1-4 letters)
 * - Medium (5-8 letters)
 * - Long (9+ letters)
 * and outputs the aggregate category counts.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits review text into words, classifies word lengths, and prints counts.
     * 
     * @param review Movie review string
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split by whitespace
        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String rawWord : words) {
            // Strip leading/trailing punctuation characters for accurate word length profiling
            String word = rawWord.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");
            if (word.isEmpty()) {
                continue;
            }

            int length = word.length();
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     Movie Review Word Length Profiler           ");
        System.out.println("=================================================\n");

        // Sample from PDF
        String review1 = "This movie was absolutely fantastic and thrilling";
        System.out.printf("Input: \"%s\"%nResult: ", review1);
        classifyWordLengths(review1);
        System.out.println();

        // Additional review sample
        String review2 = "A truly masterpiece cinema experience that captivates audiences";
        System.out.printf("Input: \"%s\"%nResult: ", review2);
        classifyWordLengths(review2);
    }
}
