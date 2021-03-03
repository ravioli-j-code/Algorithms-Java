package Dynamic.MakeChange;

import Utils.CheckRuntime;

import java.util.Scanner;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 03. 03 오후 1:29
 */
public class Main {

    public static void main (String[] args) {

        MakeChangeTypeOne one = new MakeChangeTypeOne();
        MakeChangeTypeTwo two = new MakeChangeTypeTwo();

        // check time
        CheckRuntime checktime = new CheckRuntime();

        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;
        while(isContinue) {
            System.out.println("insert coins : ");
            int insert = sc.nextInt();
            if (insert > 0) {
                System.out.println("first type");
                checktime.start();
                int result1 = one.makeChange(insert);
                checktime.end();
                System.out.println("input numbr : " +insert+ "  result : " + result1 + " took time : " + checktime.getResult());
                // input numbr : 19823  result : 1041664083 took time : runtime is : 4685 milliseconds.

                System.out.println("second type");
                checktime.start();
                int result2 = two.makeChange(insert);
                checktime.end();
                System.out.println("input numbr : " +insert+ "  result : " + result2 + " took time : " + checktime.getResult());
                // input numbr : 19823  result : 1041664083 took time : runtime is : 38 milliseconds.

            }
            System.out.println("Do You want to quit? (Y: Yes) ");
            String type = sc.next();
            if ("Y".equals(type)) {
                isContinue = false;
            }
        }


    }

}