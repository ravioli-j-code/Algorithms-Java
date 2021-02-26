package ProgrammersQues.AddPickedNumbers;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 02. 26 오후 4:16
 */
public class AddPickedNumbersTreeSet {

  public int[] addNumbers(int[] numbers) {

        Set <Integer> sumList = new TreeSet <>();

        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j < numbers.length; j++){
                sumList.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[sumList.size()];
        Iterator<Integer> itor = sumList.iterator();
        int index = 0;
        while (itor.hasNext()) {
            answer[index] = itor.next();
            index++;
        }
        return answer;
    }

}