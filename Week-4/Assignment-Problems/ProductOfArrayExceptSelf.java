import java.util.Arrays;

/**
 * Week 4 Assignment - Problem 1: Product of Array Except Self
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Pricing Engine Combined Product Value
 * 
 * Computes an array where answer[i] is the product of every element in nums
 * except nums[i], solved in O(n) time using two passes (prefix and suffix products)
 * with O(1) auxiliary space beyond the output array and strictly no division.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Calculates product of all array elements except the current element at each index.
     * 
     * @param nums Array of integers
     * @return Output array answer where answer[i] is product of all elements except nums[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] answer = new int[n];

        // First pass (Prefix products): answer[i] contains product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Second pass (Suffix products): multiply running product of all elements to the right of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("         Product of Array Except Self            ");
        System.out.println("=================================================\n");

        // Test Case 1: Standard array (Sample from PDF)
        int[] nums1 = {1, 2, 3, 4};
        System.out.printf("nums = %s%nOutput: %s%n%n",
                Arrays.toString(nums1), Arrays.toString(productExceptSelf(nums1)));

        // Test Case 2: Array containing zero (Sample from PDF)
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.printf("nums = %s%nOutput: %s%n%n",
                Arrays.toString(nums2), Arrays.toString(productExceptSelf(nums2)));

        // Test Case 3: Multiple zeros
        int[] nums3 = {0, 4, 0};
        System.out.printf("nums = %s%nOutput: %s%n",
                Arrays.toString(nums3), Arrays.toString(productExceptSelf(nums3)));
    }
}
