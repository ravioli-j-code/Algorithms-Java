package CombSort;

import java.util.Arrays;

public class CombSort {
    
    void ComnbSort(int nums[]) {
        int gap_length = nums.length;
        float shrinkFactor = 1.3f;

        boolean swapped = false;
        while(gap_length > 1 || swapped) {
            if(gap_length > 1 ) {
                gap_length = (int) (gap_length / shrinkFactor);
            }

            swapped = false;

            for (int i=0; gap_length + i < nums.length; i++) {
                if(nums[i] > nums[i+gap_length]) {
                    swap(nums, i, i+gap_length) ;
                    swapped = true;
                }
            }
        }
    }

    private static void swap(int nums[], int x, int y) {
        Integer temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String args[]) {
        CombSort ob = new CombSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        
        System.out.println("before sort array : ");
        System.out.println(Arrays.toString(nums));

        ob.ComnbSort(nums);

        System.out.println("after sort array : ");
        System.out.println(Arrays.toString(nums));

    }

}
