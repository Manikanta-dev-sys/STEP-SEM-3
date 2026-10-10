import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Week 4 Assignment - Problem 3: 3Sum
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Budgeting Tool Transaction Triplet Canceller
 * 
 * Finds all unique triplets in an integer array that sum to zero using sorting
 * and the two-pointer technique in O(n^2) time, with systematic duplicate skipping.
 */
public class ThreeSum {

    /**
     * Finds all unique triplets [nums[i], nums[j], nums[k]] that sum to exactly 0.
     * 
     * @param nums Array of integers
     * @return 2D array of unique triplets
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // Step 1: Sort the array to enable two-pointer traversal and duplicate skipping
        Arrays.sort(nums);
        List<int[]> tripletsList = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // Early break: if smallest number is greater than 0, sum cannot be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    tripletsList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return tripletsList.toArray(new int[tripletsList.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("                     3Sum                        ");
        System.out.println("=================================================\n");

        // Test Case 1: Standard case with multiple triplets (Sample from PDF)
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.printf("nums = %s%nOutput: %s%n%n",
                Arrays.toString(nums1), Arrays.deepToString(threeSum(nums1)));

        // Test Case 2: Three zeros (Sample from PDF)
        int[] nums2 = {0, 0, 0};
        System.out.printf("nums = %s%nOutput: %s (only reported once)%n%n",
                Arrays.toString(nums2), Arrays.deepToString(threeSum(nums2)));

        // Test Case 3: No valid triplets
        int[] nums3 = {0, 1, 1};
        System.out.printf("nums = %s%nOutput: %s%n",
                Arrays.toString(nums3), Arrays.deepToString(threeSum(nums3)));
    }
}
