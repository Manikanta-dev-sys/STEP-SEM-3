import java.util.Arrays;

/**
 * Week 4 Assignment - Problem 2: Maximum Subarray
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Stock Trading Best Consecutive Active Trading Days
 * 
 * Finds the contiguous subarray having the largest sum using Kadane's algorithm
 * in O(n) time and O(1) space, correctly deciding whether to extend the current
 * running subarray or restart fresh at each element.
 */
public class MaximumSubarray {

    /**
     * Computes the maximum contiguous subarray sum using Kadane's algorithm.
     * 
     * @param nums Array of integers (may contain negative numbers)
     * @return The maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must contain at least one element.");
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend running subarray or start fresh from current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track the overall maximum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("              Maximum Subarray                   ");
        System.out.println("=================================================\n");

        // Test Case 1: Mixed positive and negative (Sample from PDF)
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.printf("nums = %s%nOutput: %d (subarray [4, -1, 2, 1] sums to 6)%n%n",
                Arrays.toString(nums1), maxSubArray(nums1));

        // Test Case 2: All negative numbers (Sample from PDF)
        int[] nums2 = {-3, -1, -2};
        System.out.printf("nums = %s%nOutput: %d (single largest negative element)%n%n",
                Arrays.toString(nums2), maxSubArray(nums2));

        // Test Case 3: Single element
        int[] nums3 = {5};
        System.out.printf("nums = %s%nOutput: %d%n",
                Arrays.toString(nums3), maxSubArray(nums3));
    }
}
