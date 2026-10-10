/**
 * Week 1 Assignment - Problem 3: The Traffic Signal Streak Analyzer
 * Scenario: City Traffic Control Department
 * 
 * Analyzes traffic signal reading logs to detect the longest continuous streak
 * of consecutive identical signal colors ('R', 'Y', 'G') to pinpoint potentially
 * malfunctioning stuck signals.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Scans through a sequence of signal readings and finds the longest streak
     * of consecutive identical characters.
     * 
     * @param signalLog String representing minute-by-minute signal readings (e.g. "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);

            if (c == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = c;
                currentStreak = 1;
            }
        }

        // Final check for trailing streak at the end of the string
        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, longestStreak);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("        Traffic Signal Streak Analyzer           ");
        System.out.println("=================================================\n");

        // Sample 1 from PDF
        String log1 = "RRGGGYRR";
        System.out.printf("Input: \"%s\" -> ", log1);
        findLongestStreak(log1);

        // Sample 2 from PDF
        String log2 = "RRRRYYGG";
        System.out.printf("Input: \"%s\" -> ", log2);
        findLongestStreak(log2);

        // Additional Test Case
        String log3 = "GGYYYYYRR";
        System.out.printf("Input: \"%s\" -> ", log3);
        findLongestStreak(log3);
    }
}
