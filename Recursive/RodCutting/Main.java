package Recursive.RodCutting;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 25 오후 5:50
 */
public class Main {

    public static final int[] rodPrices = { 1, 5, 8, 9, 10, 17, 17, 20 };

    public static void main (String[] args) {
        RodCutting rodCutting = new RodCutting();
        System.out.println("rodLength : " + rodPrices.length +  "  maxPrice : " + rodCutting.cutRod(rodPrices, rodPrices.length));
    }

}