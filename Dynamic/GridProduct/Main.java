package Dynamic.GridProduct;

import Utils.CheckRuntime;
import java.util.Scanner;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 20 오전 9:49
 *
 */
public class Main {

    static final int num = 21;  // TODO: 차후에 입력값을 받을 수 있도록 수정
    static final int targetProduct = 10001;

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        // Brute Ways
        GridProductBrute brute = new GridProductBrute();
        // recur
        GridProductRecurr recur = new GridProductRecurr();
        // dup
        GridProductImprov improv = new GridProductImprov();
        // check time
        CheckRuntime checktime = new CheckRuntime();

        boolean flag = true;

        while(flag) {
            System.out.println("1. count Grid Produt using brute");
            System.out.println("2. count Grid Produt using recur");
            System.out.println("3. count Grid Produt using improv");
            System.out.println("q. quit");

            String s = sc.next();
            int result;

            System.out.println("parameter : " + num + "  *  " + targetProduct);

            switch(s) {
                case "1" :
                    checktime.start();
                    result = brute.minProduct(num, targetProduct);
                    checktime.end();
                    System.out.println("possible ways by brute : " + result );
                    System.out.println(checktime.getResult() );
                    break;
                case "2" :
                    checktime.start();
                    result = recur.minProduct(num, targetProduct);
                    checktime.end();
                    System.out.println("possible ways by recur : " + result );
                    System.out.println(checktime.getResult() );
                    break;
                 case "3" :
                    checktime.start();
                    result = improv.minProduct(num, targetProduct);
                    checktime.end();
                    System.out.println("possible ways by improv. : " + result );
                    System.out.println(checktime.getResult() );
                    break;
                case "q" :
                    System.out.println("exit. ");
                    flag = false;
                    break;

            }
        }
    }


}