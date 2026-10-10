import java.util.Arrays;

/**
 * Week 4 Assignment - Problem 5: Find Minimum in Rotated Sorted Array
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Circular Duty Roster Earliest Join Date Finder
 * 
 * Finds the minimum element in an originally sorted ascending array of unique elements
 * that has been rotated at an unknown pivot, using modified binary search in O(log n) time.
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array using binary search.
     * 
     * @param nums Rotated sorted array of unique integers
     * @return The minimum element in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must contain at least one element.");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is strictly greater than right element,
            // the inflection point (minimum) lies in the right half (mid + 1 to right)
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // If mid element is less than or equal to right element,
                // the minimum is at mid or in the left half (left to mid)
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Find Minimum in Rotated Sorted Array          ");
        System.out.println("=================================================\n");

        // Test Case 1: Standard rotated array (Sample from PDF)
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.printf("nums = %s -> Minimum: %d%n%n",
                Arrays.toString(nums1), findMin(nums1));

        // Test Case 2: Pivot near middle (Sample from PDF)
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.printf("nums = %s -> Minimum: %d%n%n",
                Arrays.toString(nums2), findMin(nums2));

        // Test Case 3: Already sorted array / no rotation (Sample from PDF)
        int[] nums3 = {11, 13, 15, 17};
        System.out.printf("nums = %s -> Minimum: %d (no rotation occurred)%n%n",
                Arrays.toString(nums3), findMin(nums3));

        // Test Case 4: Two elements rotated
        int[] nums4 = {2, 1};
        System.out.printf("nums = %s -> Minimum: %d%n",
                Arrays.toString(nums4), findMin(nums4));
    }
}
