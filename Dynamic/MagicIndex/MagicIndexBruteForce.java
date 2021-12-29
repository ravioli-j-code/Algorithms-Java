package Dynamic.MagicIndex;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 19 오전 9:45
 * 정렬된 배열(중복없음)을 인자로 받아 인덱스와 값이 동일한 케이스를 찾아 인덱스 반환하기
 * 루프사용
 */
public class MagicIndexBruteForce {

    /**
     * 입력받은 배열을 루프돌면서 인덱스와 값이 같은 케이스를 찾아 리턴
     * @param array
     * @return
     */
    int magicSlow(int[] array) {
        for (int i=0; i<array.length ; i++ ) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

}