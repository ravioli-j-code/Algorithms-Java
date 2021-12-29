package Dynamic.MagicIndex;

import Utils.CheckRuntime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 19 오전 10:00
 */
public class MagicIndexMain {

    static final int[] TEST_ARRAY = {-3, -2, -1, 3, 4, 6, 7, 8, 12, 14, 15, 22, 43, 44, 45, 47, 50 };
    static final int[] TEST_DUP_ARRAY = {-100, 1, 3, 4, 6, 6, 6, 7, 8, 12, 14, 15, 22, 33, 33, 43, 44, 45, 47, 50 };

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        // Brute Ways
        MagicIndexBruteForce brute = new MagicIndexBruteForce();
        // recur
        MagicIndexRecursion recur = new MagicIndexRecursion();
        // dup
        MagicIndexDuplicate dup = new MagicIndexDuplicate();
        // check time
        CheckRuntime checktime = new CheckRuntime();

        boolean flag = true;

        while(flag) {
            System.out.println("1. find magic index using brute");
            System.out.println("2. find magic index using recur");
            System.out.println("3. find magic index using dup");
            System.out.println("q. quit");

            String s = sc.next();
            int resultIndex;

            switch(s) {
                case "1" :
                    checktime.start();
                    resultIndex = brute.magicSlow(TEST_ARRAY);
                    checktime.end();
                    System.out.println("original array : " + Arrays.toString(TEST_ARRAY));
                    System.out.println("possible ways by brute : " + resultIndex );
                    System.out.println(checktime.getResult() );
                    break;
                case "2" :
                    checktime.start();
                    resultIndex = recur.magicFast(TEST_ARRAY);
                    checktime.end();
                    System.out.println("original array : " + Arrays.toString(TEST_ARRAY) );
                    System.out.println("possible ways by recur : " + resultIndex );
                    System.out.println(checktime.getResult() );
                    break;
                 case "3" :
                    checktime.start();
                    resultIndex = dup.magicFast(TEST_DUP_ARRAY);
                    checktime.end();
                    System.out.println("original array : " + Arrays.toString(TEST_DUP_ARRAY) );
                    System.out.println("possible ways by recur : " + resultIndex );
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