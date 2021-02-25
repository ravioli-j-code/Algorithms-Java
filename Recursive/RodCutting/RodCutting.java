package Recursive.RodCutting;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 25 오후 5:42
 * 막대기 자르기
 */
public class RodCutting {

    public int cutRod(int[] prices, int rodLen) {
        if ( rodLen == 0 ) return 0;

        int maxPrice = 0;
        for(int i = 0 ; i < rodLen ; i++ ) {
            System.out.println(prices[i]);
            maxPrice = Math.max(maxPrice, prices[i] + cutRod(prices, rodLen - i - 1 ));
        }
        return maxPrice;
    }

}