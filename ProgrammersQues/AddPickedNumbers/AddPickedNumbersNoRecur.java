package ProgrammersQues.AddPickedNumbers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 02. 26 오후 4:11
 */
public class AddPickedNumbersNoRecur {

    public int[] addNumbers(int[] numbers) {

        ArrayList <Integer> sumList = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length ; i++ ){
            for (int j = 1; j < numbers.length ; j++ ){
                if ( i == j ) continue;
                int sum = numbers[i] + numbers[j];
                if (!sumList.contains(sum)) {
                    sumList.add(sum);
                }
            }
        }

        Collections.sort(sumList);

        int[] answer = new int[sumList.size()];

        for (int i = 0 ; i < sumList.size(); i++ ) {
            answer[i] = sumList.get(i);
        }
        return answer;
    }

}