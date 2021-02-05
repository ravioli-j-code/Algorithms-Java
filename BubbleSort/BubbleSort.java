package BubbleSort;

public class BubbleSort {
    
    static void sort(int arr[], int n) {
        int i, j, temp;
        boolean swapped;

        for ( i = 0 ; i < n - 1 ; i++ ) {
            // i
            swapped = false;

            for ( j = 0 ; j < n - i - 1 ; j++ ) {
                if ( arr[j] > arr[j + 1] ) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) break;
        }
    }
}
