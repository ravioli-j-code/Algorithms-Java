package LeetCode.MergeSortArray;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 12. 29 오후 2:34
 */
public class BruteSolution {

    /***
     *
     * Runtime: 0 ms
     * Memory Usage: 39.6 MB, 39.2 MB
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        if ( m == 0 ) {
            if ( n > 0 ) {
                while ( i < nums2.length) {
                    nums1[i] = nums2[i];
                    nums2[i] = 0;
                    i++;
                }
            }
            return;
        }

        i = nums1.length - 1;
        int j = n - 1;
        int k = m - 1;

        while( i >= 0 ) {

            if ( j < 0 ) {
                break;
            } else if ( k < 0 || nums1[k] < nums2[j] ) {
                nums1[i] = nums2[j];
                nums2[j] = 0;
                j--;
            } else {
                nums1[i] = nums1[k];
                nums1[k] = 0;
                k--;
            }
            i--;
        }
    }

}