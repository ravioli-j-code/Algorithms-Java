package Dynamic.CountSteps;

import java.util.Scanner;

import Utils.CheckRuntime;

public class Main {
    
    public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // Brute Ways
        CountStepsBrute bruteSteps = new CountStepsBrute();
        // Memoization
        CountStepsMemo memoSteps = new CountStepsMemo();

        // check time
        CheckRuntime checktime = new CheckRuntime();
        
        boolean flag = true;

        while(flag) {
            System.out.println("1. count steps using brute");
            System.out.println("2. count steps using memoization");
            System.out.println("q. quit");

            String s = sc.next();
            int countInt = 0;
            int ways = 0;

            switch(s) {
                case "1" : 
                    System.out.println("press steps:");
                    countInt = sc.nextInt();
                    checktime.start();
                    ways = bruteSteps.countWays(countInt);
                    checktime.end();
                    System.out.println("possible ways by brute : " + ways );
                    System.out.println(checktime.getResult() );
                    break;
                case "2" : 
                    System.out.println("press steps:");
                    countInt = sc.nextInt();
                    checktime.start();
                    ways = memoSteps.countWays(countInt);
                    checktime.end();
                    System.out.println("possible ways by memoization : " + ways );
                    System.out.println(checktime.getResult() );
                    break;
                case "q" :
                    flag = false;
                    break; 

            }
        }
    }

}
