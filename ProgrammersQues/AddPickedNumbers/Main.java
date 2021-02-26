package ProgrammersQues.AddPickedNumbers;

import Utils.CheckRuntime;

import java.util.Arrays;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 26 오후 4:04
 */
public class Main {

    static final int[] TARGET_NUMBERS = {1, 3, 4, 5, 6, 7, 8, 9, 0, 14, 12, 55, 21, 32, 11, 32, 81, 73, 84, 39, 41, 44, 43, 45, 46, 54, 74, 54, 54, 23, 10, 100};
    // AddPickedNumbers took 21854 milliseconds. 어마어마하게 걸림.
    // AddPickedNumbersNoRecur took 3 milliseconds.
    // AddPickedNumbersTreeSet took 2 milliseconds.

    public static void main (String[] args) {

        // check time
        CheckRuntime checktime = new CheckRuntime();

        System.out.println(Arrays.toString(TARGET_NUMBERS));
        checktime.start();
        // AddPickedNumbers addPickedNumbers = new AddPickedNumbers();
        // AddPickedNumbersNoRecur addPickedNumbers = new AddPickedNumbersNoRecur();
        AddPickedNumbersTreeSet addPickedNumbers = new AddPickedNumbersTreeSet();

        int[] result = addPickedNumbers.addNumbers(TARGET_NUMBERS);
        checktime.end();
        System.out.println(Arrays.toString(result));
        System.out.println(checktime.getResult());
    }

}