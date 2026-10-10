/**
 * Week 2 Assignment - Problem 2: Word Reversal Encoder
 * Scenario: Coding Club "Mirror Text" Mini-Game
 * 
 * Reverses every word in a sentence individually while keeping the word order unchanged.
 * Uses split(" "), loops, and StringBuilder for each word reversal.
 */
public class WordReversalEncoder {

    /**
     * Reverses each individual word in the sentence while preserving overall word order.
     * 
     * @param sentence A sentence of space-separated words
     * @return Transformed string with each word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return null;
        }

        if (sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Reverse the individual word using a loop and StringBuilder
            StringBuilder wordReversed = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                wordReversed.append(word.charAt(j));
            }

            resultBuilder.append(wordReversed);

            // Append space delimiter between words (not after the last word)
            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("             Word Reversal Encoder               ");
        System.out.println("=================================================\n");

        // Test Case 1: Sample from PDF
        String input1 = "hello club";
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", input1, reverseEachWord(input1));

        // Test Case 2: Multi-word sentence
        String input2 = "Java is great fun";
        System.out.printf("Input: \"%s\"%nOutput: %s%n%n", input2, reverseEachWord(input2));

        // Test Case 3: Single word
        String input3 = "programming";
        System.out.printf("Input: \"%s\"%nOutput: %s%n", input3, reverseEachWord(input3));
    }
}
