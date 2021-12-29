package ProgrammersQues.DiskController;

import java.util.Arrays;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 06. 11 오후 2:12
 */
public class DiskTest {


    public static void main(String[] args) {
        // int[][] jobsArr = {{0, 3}, {1, 9}, {2, 6}};
        // int[][] jobsArr = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};

        DiskWorker h = new DiskWorker();
        int result = 0;
        int[][] jobsArr1 = {{0, 3}, {1, 9}, {2, 6}};
        result = h.working(jobsArr1);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr1), result, 9)) ;

        int[][] jobsArr2 = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
        result = h.working(jobsArr2);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr2), result, 14)) ;

        int[][] jobsArr3 ={{0, 10}, {2, 12}, {9, 19}, {15, 17}};
        result = h.working(jobsArr3);
        System.out.println( customTestResult(Arrays.deepToString( jobsArr3), result, 25) );

        int[][] jobsArr4 = {{0, 3}, {1, 9}, {2, 6}};
        result = h.working(jobsArr4);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr4) , result,9)) ;

        int[][] jobsArr5 = {{0, 1}};
        result = h.working(jobsArr5);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr5), result, 1)) ;

        int[][] jobsArr7 = {{0, 1}, {0, 1}, {0, 1}};
        result = h.working(jobsArr7);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr7) , result, 2)) ;

        int[][] jobsArr8 = {{0, 1}, {0, 1}, {0, 1}, {0, 1}};
        result = h.working(jobsArr8);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr8), result, 2) );

        int[][] jobsArr6 = {{1000, 1000}}; // false
        result = h.working(jobsArr6);
        System.out.println( customTestResult(Arrays.deepToString( jobsArr6), result, 1000)) ;

        int[][] jobsArr9 = {{0, 1}, {1000, 1000}}; // false
        result = h.working(jobsArr9);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr9) , result,500)) ;

        int[][] jobsArr10 = {{100, 100}, {1000, 1000}}; // false
        result = h.working(jobsArr10);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr10), result, 500)) ;

        int[][] jobsArr11 = {{10, 10}, {30, 10}, {50, 2}, {51, 2}}; // false
        result = h.working(jobsArr11);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr11), result, 6)) ;

        int[][] jobsArr12 = {{0, 3}, {1, 9}, {2, 6}, {30, 3}}; // false
        result = h.working(jobsArr12);
        System.out.println( customTestResult(Arrays.deepToString(jobsArr12), result, 7)) ;
    }

     static public String customTestResult (String targetStr, int testCode, int expected) {
        StringBuffer result = new StringBuffer();
        result.append("parameters : " + targetStr);
        result.append(" result is : " + testCode);
        result.append(" expected : " + expected);
        return result.toString();
    }

}