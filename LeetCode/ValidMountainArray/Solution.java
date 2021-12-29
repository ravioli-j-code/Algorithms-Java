package LeetCode.ValidMountainArray;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 12. 28 오후 1:47
 */
public class Solution {

    public static void main(String[] args) {

        int[] params = {0,1,2,3,4,5,6,7,8,9};
        Solution sol = new Solution();
        boolean r = sol.validMountainArray(params);
        System.out.println(r);
    }

    // Runtime: 1 ms
    // Memory Usage: 39.6 MB
    public boolean validMountainArray(int[] arr) {

        int size = arr.length;

        if ( size < 3 ) return false;

        int[] tmp = new int[size-1];

        for (int i = 0 ; i < size ; i++ ) {
            if (i < size - 1) {
                tmp[i] = arr[i+1] - arr[i];
            }
        }


        boolean wasUp = tmp[0] > 0 ? true : false;
        boolean wasDown = false;

        if (!wasUp) return false;

        for (int i = 0; i < size - 1; i++ ) {
            if ( tmp[i] == 0 ) {
                return false;
            }

            // first down
            if (tmp[i] < 0 && !wasDown) {
                wasDown = true;
            }
            // down and increased again
            if (tmp[i] > 0 && wasDown) {
                return false;
            }

        }

        if (!wasDown) return false;

        return true;
    }

}