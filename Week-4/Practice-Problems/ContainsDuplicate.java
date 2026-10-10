import java.util.Arrays;

/**
 * Week 4 Practice - Problem 3: Contains Duplicate
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Exam Seating Roll Number Duplicate Verifier
 * 
 * Uses pairwise comparison with two nested loops to check if any element
 * appears at least twice in the array. Exits early when a duplicate is found.
 */
public class ContainsDuplicate {

    /**
     * Checks if any value appears more than once in the array using nested loops.
     * 
     * @param nums Array of integers
     * @return true if any duplicate exists, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("              Contains Duplicate                 ");
        System.out.println("=================================================\n");

        // Test Case 1: Duplicate present (Sample from PDF)
        int[] nums1 = {1, 2, 3, 1};
        System.out.printf("nums = %s -> %b (value 1 appears at two positions)%n",
                Arrays.toString(nums1), containsDuplicate(nums1));

        // Test Case 2: All distinct (Sample from PDF)
        int[] nums2 = {1, 2, 3, 4};
        System.out.printf("nums = %s -> %b (every value is distinct)%n",
                Arrays.toString(nums2), containsDuplicate(nums2));

        // Test Case 3: Multiple duplicates
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.printf("nums = %s -> %b%n",
                Arrays.toString(nums3), containsDuplicate(nums3));
    }
}
