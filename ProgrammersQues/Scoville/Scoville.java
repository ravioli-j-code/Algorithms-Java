package ProgrammersQues.Scoville;

import java.util.*;

/**
 * @author : JKI
 * @version : 1.0
 * @since : 2021. 05. 23 오후 1:44
 */
public class Scoville {

    /*

        스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
        섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복

        제한 사항
        scoville의 길이는 2 이상 1,000,000 이하입니다.
        K는 0 이상 1,000,000,000 이하입니다.
        scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
        모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.

        입출력 예
        scoville	K	return
        [1, 2, 3, 9, 10, 12]	7	2

        스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
        새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
        가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

        스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
        새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
        가진 음식의 스코빌 지수 = [13, 9, 10, 12]

        모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.

        mixedScov = lowScov + secondLowScov * 2

        1 시행
        가장 작은, 두번째로 작은 값을 찾음.
        계산값이 스코빌 값보다 작음 : 정렬 , 횟수 + 1
        큼 > 리턴

    */

    public static int ScovilleRun(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while(q.size() > 1 && q.peek() < K){
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }

        if(q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }


    public static void main (String[] args) {

        int[] inputArr = { 1, 2, 3, 9, 10, 12, 31, 2, 3,  2, 3, 9, 10, 12, 31, 11222, 11223,  32122, 22223,
                123123, 221110, 345312, 334331, 222, 352433,  234232, 523423, 252349, 234210, 23212, 343231, 234232, 323423,  244,
                3433, 56759, 45610, 34512, 67831, 2432, 2343,  2342, 2343, 4569, 45610, 2312, 4531, 22, 433 };
        int returnInt = ScovilleRun(inputArr, 1000);

        System.out.println("the result is : " + returnInt);

    }


}