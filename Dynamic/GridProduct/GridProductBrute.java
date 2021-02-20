package Dynamic.GridProduct;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 20 오전 9:35
 *
 *
 *
 */
public class GridProductBrute {

    int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    int minProductHelper(int smaller, int bigger) {
        if(smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        // '>>' : 시프트 연산자.
        // smaller 의 이진값을 1칸 시프트 하므로 2로 나눈 효과
        int s = smaller >> 1; // 2로 나눈다
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, bigger);
        }
        return side1 + side2;
    }

}