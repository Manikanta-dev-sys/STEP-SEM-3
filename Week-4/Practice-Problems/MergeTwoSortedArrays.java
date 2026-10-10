import java.util.Arrays;

/**
 * Week 4 Practice - Problem 4: Merge Two Sorted Arrays
 * Category C: Logic-building using arrays, loops, and conditionals
 * Scenario: Class Section Sorted Exam Scores Merger
 * 
 * Merges two already sorted integer arrays into one combined sorted array
 * using a two-pointer technique without sorting from scratch.
 */
public class MergeTwoSortedArrays {

    /**
     * Merges two sorted arrays into a new sorted array.
     * 
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return New array containing all elements in non-decreasing order
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) arr1 = new int[0];
        if (arr2 == null) arr2 = new int[0];

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for merged result

        // Compare elements and copy the smaller one
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1
        while (i < n1) {
            merged[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2
        while (j < n2) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("           Merge Two Sorted Arrays               ");
        System.out.println("=================================================\n");

        // Test Case 1: Interleaved arrays (Sample from PDF)
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};
        System.out.printf("arr1 = %s, arr2 = %s -> %s%n",
                Arrays.toString(a1), Arrays.toString(a2), Arrays.toString(mergeSortedArrays(a1, a2)));

        // Test Case 2: One empty array (Sample from PDF)
        int[] b1 = {};
        int[] b2 = {1, 2, 3};
        System.out.printf("arr1 = %s, arr2 = %s -> %s%n",
                Arrays.toString(b1), Arrays.toString(b2), Arrays.toString(mergeSortedArrays(b1, b2)));

        // Test Case 3: Unequal lengths with duplicates
        int[] c1 = {2, 5, 8, 12, 15};
        int[] c2 = {1, 5, 9};
        System.out.printf("arr1 = %s, arr2 = %s -> %s%n",
                Arrays.toString(c1), Arrays.toString(c2), Arrays.toString(mergeSortedArrays(c1, c2)));
    }
}
