import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Week 4 Assignment - Problem 4: Subarray Sum Equals K
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Hostel Attendance Net Change Analyzer
 * 
 * Computes the total number of contiguous subarrays whose sum equals k using
 * running prefix sums combined with a hash map of prefix-sum frequencies in O(n) time.
 */
public class SubarraySumEqualsK {

    /**
     * Returns the total count of contiguous subarrays whose sum equals k.
     * 
     * @param nums Array of integers (may contain positive and negative numbers)
     * @param k    Target subarray sum
     * @return Number of contiguous subarrays with sum equal to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Map stores running prefixSum -> frequency
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        // Base case: prefix sum of 0 appears once (representing an empty prefix before index 0)
        prefixSumFrequency.put(0, 1);

        int currentRunningSum = 0;
        int count = 0;

        for (int num : nums) {
            currentRunningSum += num;

            // If (currentRunningSum - k) exists in the map, add its frequency
            int complement = currentRunningSum - k;
            if (prefixSumFrequency.containsKey(complement)) {
                count += prefixSumFrequency.get(complement);
            }

            // Update frequency of current running prefix sum
            prefixSumFrequency.put(currentRunningSum, prefixSumFrequency.getOrDefault(currentRunningSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("           Subarray Sum Equals K                 ");
        System.out.println("=================================================\n");

        // Test Case 1: Standard positive values (Sample from PDF)
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.printf("nums = %s, k = %d%nOutput: %d (subarrays [1, 1] at 0-1 and 1-2)%n%n",
                Arrays.toString(nums1), k1, subarraySum(nums1, k1));

        // Test Case 2: Array containing negative numbers and zero (Sample from PDF)
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.printf("nums = %s, k = %d%nOutput: %d (subarrays [1, -1], [0], [1, -1, 0])%n%n",
                Arrays.toString(nums2), k2, subarraySum(nums2, k2));

        // Test Case 3: Multiple overlapping matches
        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        System.out.printf("nums = %s, k = %d%nOutput: %d%n",
                Arrays.toString(nums3), k3, subarraySum(nums3, k3));
    }
}
