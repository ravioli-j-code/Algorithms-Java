package LeetCode.CheckIfNandItsDoubleExist;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 12. 28 오후 1:07
 */
public class WithoutHashSet {
    // Runtime: 2 ms
    // Memory Usage: 39 MB
    public boolean checkIfExist(int[] arr) {

        boolean isHaving = false;
        int i = 0;
        int j = 0;
        int s = arr.length;

        while( i < s ) {
            if (arr[i] == 0 && i == j) {
                j = 0;
                i++;
                continue;
            }
            if (arr[i] * 2 == arr[j] || arr[i] == arr[j] * 2 ) {
                isHaving = true;
                break;
            }

            if ( j == s - 1) {
                j = 0;
                i++;
            } else {
                j++;
            }
        }

        return isHaving;

    }

}