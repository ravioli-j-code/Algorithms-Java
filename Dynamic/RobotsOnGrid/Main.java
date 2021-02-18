package Dynamic.RobotsOnGrid;

import Utils.CheckRuntime;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        // Brute Ways
        RobotsOnGrid robotsOnGrid = new RobotsOnGrid();
        // RobotsOnGridRevised
        RobotsOnGridRevised robotsOnGridRev = new RobotsOnGridRevised();

        // check time
        CheckRuntime checktime = new CheckRuntime();

        boolean flag = true;

        while(flag) {
            System.out.println("1. count steps using brute");
            System.out.println("2. count steps using revised");
            System.out.println("q. quit");

            String s = sc.next();
            ArrayList <Point> path;

            boolean[][] maze =
                    {
                            {true, false, true, true, true, false, true, true, true, false, true, true},
                            {true, false, true, false, true, false, true, true, true, false, true, true},
                            {false, true, true, true, true, false, true, true, true, false, true, true},
                            {false, true, true, true, true, false, true, true, true, false, true, true},
                            {true, true, true, true, true, true, true, false, true, true, true, true},
                            {true, true, true, true, true, false, true, true, true, true, true, false},
                            {false, false, true, true, true, true, true, true, true, false, true, true},
                            {false, false, true, true, true, false, true, true, true, true, true, true},
                            {true, true, true, false, true, false, true, true, true, true, true, true},
                            {true, false, true, false, true, false, true, true, true, false, true, true},
                            {false, false, true, true, true, true, true, true, true, false, true, false},
                            {false, false, true, true, true, true, false, true, true, true, true, false},
                            {true, true, true, true, true, false, true, true, true, true, true, true},
                            {true, true, true, true, true, true, true, true, true, true, true, true},
                            {false, true, false, true, true, true, true, true, true, true, true, true},
                            {true, true, false, true, true, true, true, true, true, false, true, true},
                            {true, true, false, true, true, false, true, true, true, false, true, true},
                            {false, true, false, true, true, true, true, false, true, true, true, true},
                            {true, true, true, true, true, true, true, false, true, true, true, false},
                            {true, true, true, true, true, true, true, false, true, true, true, false},
                            {true, true, true, true, true, true, true, false, false, false, true, false},
                            {false, true, true, true, true, true, true, true, true, true, true, true},
                            {false, true, true, true, true, false, true, true, true, true, true, true}
                    };
            switch(s) {
                case "1" :
                    checktime.start();
                    path = robotsOnGrid.getPath(maze);
                    checktime.end();
                    System.out.println("possible ways by brute : ");
                    for (int i = 0 ; i < path.size(); i++ ) {
                        System.out.println(path.get(i).toString());
                    }
                    System.out.println(checktime.getResult() );
                    break;
                case "2" :
                    checktime.start();
                    path = robotsOnGridRev.getPath(maze);
                    checktime.end();
                    System.out.println("possible ways by revised : ");
                    for (int i = 0 ; i < path.size(); i++ ) {
                        System.out.println(path.get(i).toString());
                    }
                    System.out.println(checktime.getResult() );
                    break;
                case "q" :
                    flag = false;
                    System.out.println("exit. ");
                    break;

            }
        }
    }
}
