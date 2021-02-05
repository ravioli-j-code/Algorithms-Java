package MergeSort;

public class MergeSort {
    
    /**
     * 두개의 임시 배열을 병합하는 함수
     * @param arr
     * @param left 시작점
     * @param middle
     * @param right 오른쪽 끝점
     */
    void merge(int arr[], int left, int middle, int right) {
        // 병합할 두개의 배열의 사이즈를 확인함
        int n1 = middle - left + 1; // 왼쪽 사이즈
        int n2 = right - middle; // 오른쪽 사이즈

        // 두개의 임시 배열을 생성
        int Left[] = new int[n1];
        int Right[] = new int[n2];

        // 원래 배열을 임시 배열에 저장
        for (int i = 0 ; i < n1; ++i) {
            Left[i] = arr[left + i];
        }

        for (int j = 0 ; j < n2; ++j ) {
            Right[j] = arr[middle + 1 + j];
        }

        /* 두개의 배열을 병합 */

         // 각각 서브 배열들으 최초 인덱스
        int i=0, j=0;

        // 병합할 서브 배열의 최초 시작 인덱스
        int k = left;

        while(i < n1 && j < n2) {
            if(Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            } else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        // 왼쪽 배열에 남아있는 원소를 복사
        while(i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }
        
        // 오른쪽 배열에 남아있는 원소를 복사
        while( j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

    /**
     * 실제 왼쪽, 오른쪽 배열을 정렬.
     * @param arr 원 배열
     * @param left 왼쪽 배열의 시작 포인터
     * @param right 오른쪽 배열의 마지막 포인터(오른쪽 배열 사이즈)
     */
    void sort(int arr[], int left, int right) {

        // 오른쪽 배열이 더 큰경우
        if (left < right ) {
            // 중간점 찾기
            int middle = left + (right - left) / 2;

            sort(arr, left, middle); // 왼쪽 정렬
            sort(arr, middle + 1, right); // 오른쪽 정렬

            merge(arr, left, middle, right); // 정렬된 결과를 병합
        }
    }

    /**
     * 배열 출력
     * @param arr
     */
    static void printArray(int arr[]) {
        int n = arr.length;
        for( int i = 0; i < n ; ++i ) {
            System.out.println(arr[i] + "  " );
        }
        System.out.println() ;
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Target Array") ; // 입력 배열
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array") ;
        printArray(arr);

    }

}
