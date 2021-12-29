package Dynamic.NoDupPerms;

import Utils.CheckRuntime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 24 오전 9:51
 */
public class Main {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        // Brute Ways
        NoDupPermsBrute brute = new NoDupPermsBrute();
        // Partial
        NoDupPermsPartials partials = new NoDupPermsPartials();
        // Prefix
        NoDupPermsPrefix prefix = new NoDupPermsPrefix();

        // check time
        CheckRuntime checktime = new CheckRuntime();

        boolean flag = true;

        while(flag) {

            System.out.println("1. solution using brute");
            System.out.println("2. solution using partials");
            System.out.println("3. solution using prefix");
            System.out.println("q. quit");

            String s = sc.next();
            String inputStr;
            ArrayList<String> result = new ArrayList <>();

            switch(s) {
                case "1" :
                    System.out.println("press strings:");
                    inputStr = sc.next();
                    checktime.start();
                    result = brute.getPerms(inputStr);
                    checktime.end();
                    System.out.println("count : "+ result.size() + " possible ways by brute : " + String.join(", ", result) );
                    System.out.println(checktime.getResult() );
                    result.clear();
                    break;
                case "2" :
                    System.out.println("press strings:");
                    inputStr = sc.next();
                    checktime.start();
                    result = partials.getPerms(inputStr);
                    checktime.end();
                    System.out.println("count : "+ result.size() + " possible ways by partials : " +  String.join(", ", result) );
                    System.out.println(checktime.getResult() );
                    result.clear();
                    break;
                case "3" :
                    System.out.println("press strings:");
                    inputStr = sc.next();
                    checktime.start();
                    result = prefix.getPerms(inputStr);
                    checktime.end();
                    System.out.println("count : "+ result.size() + " possible ways by prefix : " + String.join(", ", result) );
                    System.out.println(checktime.getResult() );
                    result.clear();
                    break;
                case "q" :
                    flag = false;
                    result.clear();
                    break;

            }
        }
    }

}