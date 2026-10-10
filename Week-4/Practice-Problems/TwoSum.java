import java.util.Arrays;

/**
 * Week 4 Practice - Problem 1: Two Sum
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Shopkeeper Item Budget Matcher
 * 
 * Checks every pair of different positions (i, j) in an integer array using
 * nested loops to find the pair that sums up to target.
 */
public class TwoSum {

    /**
     * Finds the two indices in nums that sum to the given target value.
     * 
     * @param nums   Array of integers
     * @param target Target sum
     * @return Array containing the two indices [i, j], or empty array if none found
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("                 Two Sum                         ");
        System.out.println("=================================================\n");

        // Test Case 1 (Sample from PDF)
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] res1 = twoSum(nums1, target1);
        System.out.printf("nums = %s, target = %d -> %s (nums[%d] + nums[%d] = %d + %d = %d)%n",
                Arrays.toString(nums1), target1, Arrays.toString(res1),
                res1[0], res1[1], nums1[res1[0]], nums1[res1[1]], target1);

        // Test Case 2 (Sample from PDF)
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] res2 = twoSum(nums2, target2);
        System.out.printf("nums = %s, target = %d -> %s (nums[%d] + nums[%d] = %d + %d = %d)%n",
                Arrays.toString(nums2), target2, Arrays.toString(res2),
                res2[0], res2[1], nums2[res2[0]], nums2[res2[1]], target2);

        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] res3 = twoSum(nums3, target3);
        System.out.printf("nums = %s, target = %d -> %s%n",
                Arrays.toString(nums3), target3, Arrays.toString(res3));
    }
}
