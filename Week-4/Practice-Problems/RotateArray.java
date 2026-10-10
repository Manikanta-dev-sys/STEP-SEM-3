import java.util.Arrays;

/**
 * Week 4 Practice - Problem 5: Rotate Array
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Playlist Queue Rotation
 * 
 * Rotates an integer array to the right by k positions using modulo arithmetic
 * to compute destination positions directly.
 */
public class RotateArray {

    /**
     * Rotates an array to the right by k positions and returns the rotated array.
     * 
     * @param nums Array of integers
     * @param k    Number of positions to rotate
     * @return Newly created array with rotated elements
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return (nums == null) ? new int[0] : nums.clone();
        }

        int n = nums.length;
        // Normalize k to avoid unnecessary full rotations
        k = k % n;
        if (k < 0) {
            k += n; // Handle possible negative rotation
        }

        int[] rotated = new int[n];

        // Place each element directly at its rotated destination position
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = nums[i];
        }

        // Copy elements back into original array
        System.arraycopy(rotated, 0, nums, 0, n);

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("                 Rotate Array                    ");
        System.out.println("=================================================");

        // Test Case 1: Standard rotation (Sample from PDF)
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.printf("nums = %s, k = %d%n", Arrays.toString(nums1), k1);
        int[] res1 = rotateArray(nums1, k1);
        System.out.printf("Output: %s%n%n", Arrays.toString(res1));

        // Test Case 2: k larger than array length (Sample from PDF)
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.printf("nums = %s, k = %d (k %% length = 3 %% 2 = 1)%n", Arrays.toString(nums2), k2);
        int[] res2 = rotateArray(nums2, k2);
        System.out.printf("Output: %s%n%n", Arrays.toString(res2));

        // Test Case 3: Rotation by full length (k % length == 0)
        int[] nums3 = {10, 20, 30, 40};
        int k3 = 4;
        System.out.printf("nums = %s, k = %d%n", Arrays.toString(nums3), k3);
        int[] res3 = rotateArray(nums3, k3);
        System.out.printf("Output: %s%n", Arrays.toString(res3));
    }
}
