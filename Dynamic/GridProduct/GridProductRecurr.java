package Dynamic.GridProduct;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 20 오전 9:40
 *
 * 재귀를 이용한 격자곱셈
 *
 */
public class GridProductRecurr {

    int minProduct(int a, int b){
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        int memo[] = new int[smaller + 1];
        return minProduct(smaller, bigger, memo);
    }

    int minProduct(int smaller, int bigger, int[] memo){
        if(smaller == 0) {
            return 0;
        } else if(smaller == 1){
            return bigger;
        } else if (memo[smaller] > 0){
            return memo[smaller];
        }

        /* 절반을 구한다. 짝수가 아니라면 나머지 절반도 구한다. 짝수라면, 곱절을 한다. */
        int s = smaller >> 1;
        int side1 = minProduct(s, bigger, memo);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProduct(smaller - s, bigger, memo);
        }

        /* 더해서 캐시에 넣는다. */
        memo[smaller] = side1 + side2;
        return memo[smaller];
    }

}