import java.util.Arrays;

/**
 * Week 4 Practice - Problem 2: Best Time to Buy and Sell Stock
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Trainee Investor Single-Pass Profit Finder
 * 
 * Walks through stock prices in a single pass from left to right, maintaining
 * the lowest price seen so far and the maximum achievable profit.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit that can be achieved from buying and selling stock once.
     * 
     * @param prices Array of daily stock prices
     * @return Maximum profit, or 0 if no profitable transaction is possible
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int currentProfit = currentPrice - minPrice;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     Best Time to Buy and Sell Stock             ");
        System.out.println("=================================================\n");

        // Test Case 1: Profitable transaction (Sample from PDF)
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.printf("prices = %s -> %d (buy at 1, sell at 6)%n",
                Arrays.toString(prices1), maxProfit(prices1));

        // Test Case 2: Strictly decreasing prices (Sample from PDF)
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.printf("prices = %s -> %d (prices only fall)%n",
                Arrays.toString(prices2), maxProfit(prices2));

        // Test Case 3: Steady climb
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.printf("prices = %s -> %d%n",
                Arrays.toString(prices3), maxProfit(prices3));
    }
}
