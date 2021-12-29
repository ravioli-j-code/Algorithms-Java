package LeetCode.CheckIfNandItsDoubleExist;

import java.util.HashSet;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 12. 28 오후 1:07
 */
public class WithHashSet {
    // Runtime: 1 ms
    // Memory Usage: 38.2 MB
    public boolean checkIfExist(int[] arr) {

        HashSet <Integer> set = new HashSet<>();
        for(int i : arr){
            if(set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))){
                return true;
            }
            set.add(i);
        }
        return false;

    }

}