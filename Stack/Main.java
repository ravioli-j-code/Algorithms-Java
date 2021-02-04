package Stack;

import java.util.Scanner;

public class Main {
    
    public static void menu()  {
        System.out.println("1. push");
        System.out.println("2. pop");
        System.out.println("3. stack");
        System.out.println("q. exit");

    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StackImpl stack = new StackImpl(T);
        boolean flag = true;

        while(flag) {
            menu();
            String s = sc.next();

            switch(s) {
                case "1" : 
                    System.out.println();
                    String data = sc.next();
                    stack.push(data);
                    break;
                case "2" : 
                    System.out.print("Pop : " + stack.pop());
                    break;
                case "3" : 
                    stack.printStack(stack);
                    break;
                case "Q" : 
                case "q" :
                    flag = false;
                    break; 

            }
        }

        sc.close();

    }


}
