package Dynamic.MagicIndex;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 19 오전 9:46
 * 정렬된 배열(중복없음)을 인자로 받아 인덱스와 값이 동일한 케이스를 찾아 인덱스 반환하기
 * 재귀적으로 중간값을 찾아 확인
 */
public class MagicIndexRecursion {

    int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    int magicFast( int[] array, int start, int end) {
        /* 배열의 범위가 넘어가면 -1 반환 */
        if (end < start) return -1;

        /* 재귀적으로 중간값을 찾아 확인함 */
        int mid = (start + end) / 2 ;
        if (array[mid] == mid) {
            return mid;
        } else if ( array[mid] > mid) { // 값이 인덱스보다 작은 경우, 왼쪽으로 탐색. 없으면 -1 반환
            return magicFast(array, start, mid -1 );
        } else {
            return magicFast(array, mid + 1, end); // 값이 인덱스보다 큰 경우, 오른쪽으로 탐색
        }
    }

}