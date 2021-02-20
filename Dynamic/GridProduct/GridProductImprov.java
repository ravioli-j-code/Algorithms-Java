package Dynamic.GridProduct;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 20 오전 9:45
 *
 * 재귀적 방식에서 한단계 더 나아감감 *
 */
public class GridProductImprov {

    int minProduct(int a, int b){
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    int minProductHelper(int smaller, int bigger) {
        if (smaller == 0 ) return 0;
        else if (smaller == 1) return bigger;

        int s = smaller >> 1; // 반으로 나눈다ㅣ
        int halfProd = minProductHelper(s, bigger);
        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }

}