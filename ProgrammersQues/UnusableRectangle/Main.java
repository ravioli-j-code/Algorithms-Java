package ProgrammersQues.UnusableRectangle;

import Utils.CheckRuntime;

import java.util.Scanner;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 27 오전 9:22
 */
public class Main {

    public static void main (String[] args) {

        //UnusableRectangle rec = new UnusableRectangle();
        UnusableRectancleAns rec = new UnusableRectancleAns();

        Scanner sc = new Scanner(System.in);

        // check time
        CheckRuntime checktime = new CheckRuntime();

        System.out.println("insert Width");
        int width = sc.nextInt();

        System.out.println("insert height");
        int height = sc.nextInt();

        checktime.start();
        long result = rec.getAnswer(width, height);
        checktime.end();

        System.out.println(" width : " + width + " height : " +  height + " result : " + result);
        System.out.println(checktime.getResult());
    }

}