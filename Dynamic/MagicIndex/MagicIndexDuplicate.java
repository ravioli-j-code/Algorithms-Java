package Dynamic.MagicIndex;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 19 오전 9:54
 * 정렬된 배열(중복있음)을 인자로 받아 인덱스와 값이 동일한 케이스를 찾아 인덱스 반환하기
 * 재귀적으로 중간값을 찾아 확인.
 * 중간값은 좌우 범위의 최소 혹은 최대값으로 설정되어 다시 그 안에서 중간값을 찾게 됨
 */
public class MagicIndexDuplicate {

    int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    int magicFast( int[] array, int start, int end) {
        /* 배열의 범위가 넘어가면 -1 반환 */
        if (end < start) return -1;

        int minIndex = (start + end) / 2;
        int minValue = array[minIndex];
        if (minValue == minIndex) {
            return minIndex;
        }

        /* 왼쪽 탐색 */
        int leftIndex = Math.min(minIndex - 1, minValue);
        int left = magicFast(array, start, leftIndex);
        if ( left >= 0){
            return left;
        }

        /* 오른쪽 탐색 */
        int rightIndex = Math.max(minIndex + 1, minValue);
        int right = magicFast(array, rightIndex, end);
        return right;
    }

}