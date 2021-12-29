package Dynamic.DupPerms;

import Utils.CheckRuntime;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 24 오전 10:50
 */
public class Main {

     public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        // Brute Ways
        DupPerms brute = new DupPerms();
        // check time
        CheckRuntime checktime = new CheckRuntime();

        boolean flag = true;

        while(flag) {
            System.out.println("1. solutions using brute");
            System.out.println("q. quit");

            String s = sc.next();
            ArrayList <String> result = new ArrayList <>();
            String inputStr;

            switch(s) {
                case "1" :
                    System.out.println("press strings:");
                    inputStr = sc.next();
                    checktime.start();
                    result = brute.pringPerms(inputStr);
                    checktime.end();
                    System.out.println("possible ways by brute : " + result );
                    System.out.println("count : " +result.size());
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