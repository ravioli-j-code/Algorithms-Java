package ProgrammersQues.ProcessesPerSpeed;


/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 03. 10 오후 3:02
 */
public class Main {

    public static void main (String[] args) {

        ProcessesPerSpeed per = new ProcessesPerSpeed();

        int[] pros1 = { 93, 30, 55};
        int[] per1 = { 1, 30, 5 };

        int[] pros2  = { 95, 90, 99, 99, 80, 99 };
        int[] per2 = { 1, 1, 1, 1, 1, 1 };

        int[] result = per.calcProcessPerSpeed(pros2, per2);
        System.out.println("====== result =====");
        for (int i = 0 ; i < result.length ; i++ ) {
            System.out.println(result[i]);
        }

    }

}