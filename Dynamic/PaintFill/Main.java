package Dynamic.PaintFill;


import Utils.CheckRuntime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 25 오전 10:08
 */
public class Main {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            System.out.println("1. fill screen using depth");
            System.out.println("q. quit");

            String s = sc.next();

            switch (s) {
                case "1":

                    System.out.println("current screen");
                    for (PaintColor.Color[] arr : PaintColor.screen) {
                        System.out.println(Arrays.toString(arr));
                    }

                    System.out.println("select color to fill.");
                    System.out.println("1. Black");
                    System.out.println("2. White");
                    System.out.println("3. Red");
                    System.out.println("4. Yellow");
                    System.out.println("5. Green");

                    int color = sc.nextInt();

                    if (color == 1) {
                        doAction(PaintColor.Color.Black);
                    } else if (color == 2) {
                        doAction(PaintColor.Color.White);
                    } else if (color == 3) {
                        doAction(PaintColor.Color.Red);
                    } else if (color == 4) {
                        doAction(PaintColor.Color.Yellow);
                    } else if (color == 5) {
                        doAction(PaintColor.Color.Green);
                    }
                    break;
                case "q":
                    flag = false;
                    break;

            }
        }
    }

    public static void doAction(PaintColor.Color color){

        Scanner sc = new Scanner(System.in);

        System.out.println("insert row:");
        int row = sc.nextInt();
        System.out.println("insert col:");
        int col = sc.nextInt();

        // Depth Search
        PaintFillDepth depth = new PaintFillDepth();

        // check time
        CheckRuntime checktime = new CheckRuntime();

        PaintColor.Color[][] resultscreen = PaintColor.screen;

        checktime.start();
        depth.PointFillColor(resultscreen, row, col, color);
        checktime.end();

        System.out.println(checktime.getResult());

        for (PaintColor.Color[] arr : resultscreen) {
            System.out.println(Arrays.toString(arr));
        }

        return;
    }

}