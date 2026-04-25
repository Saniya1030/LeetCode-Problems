class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
          int n1 = arr1.length, n2 = arr2.length;

        int[] merged = new int[n1 + n2];
        // Apply the merge step
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) merged[k++] = arr1[i++];
            else merged[k++] = arr2[j++];
        }

        // Copy the remaining 
        while (i < n1) merged[k++] = arr1[i++];
        while (j < n2) merged[k++] = arr2[j++];

        // the median
        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) merged[n / 2];
        }

        double median = ((double) merged[n / 2] + (double) merged[(n / 2) - 1]) / 2.0;
        return median;
    }
}