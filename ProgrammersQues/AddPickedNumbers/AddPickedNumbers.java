package ProgrammersQues.AddPickedNumbers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 26 오후 4:01
 */
public class AddPickedNumbers {

    public int[] addNumbers(int[] numbers) {
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        doSums(numbers, sumList, 0, 1);
        Collections.sort(sumList);

        int[] answer = new int[sumList.size()];

        for (int i = 0 ; i < sumList.size(); i++ ) {
            answer[i] = sumList.get(i);
        }
        return answer;
    }

    void doSums(int[] numbers, ArrayList <Integer> sums, int firstIdx, int secondIdx) {
        if(firstIdx == secondIdx ||
           firstIdx > numbers.length - 1 ||
           secondIdx > numbers.length - 1) return;

        int sum = numbers[firstIdx] + numbers[secondIdx];
        if (!sums.contains(sum)) {
            sums.add(sum);
        }

        doSums(numbers, sums, firstIdx, secondIdx + 1);
        doSums(numbers, sums, firstIdx + 1, secondIdx);
    }

}