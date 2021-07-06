package Greedy;

import java.util.Arrays;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 07. 06 오후 4:11
 */
public class GymCloth {

    public int GymCloth(int n, int lost[], int reserve[]) {

        int left = n - reserve.length - lost.length; // 분실도, 여벌을 가져오지도 않은 학생의 수
        int avail = reserve.length; // 여범을 가져온 학생의 수

       for (int i = 0 ; i < reserve.length ; i++ ) {
            if (lend(lost, reserve[i])) {
                avail++;
            }
        }

        if ( n < avail ) {
            avail = n;
        }

        return left + avail;
    }

    private static boolean lend(int lost[], int reserve) {
        boolean wasLend = false;

        for (int i = 0 ; i < lost.length ; i++ ) {
            if (lost[i] < 1 ) continue;
            int diff = Math.abs(lost[i] - reserve);
            if (diff == 0) {
               wasLend = false;
            } else if (diff == 1){
               wasLend = true;
               lost[i] = 0;
               break;
            }
        }
        return wasLend;
    }

    public static void main(String args[]) {
        GymCloth gc = new GymCloth();

        int attend0 = 5;
        int lost0[] = {2, 4};
        int reserve0[] = {1, 3, 5};

        int result0 = gc.GymCloth(attend0, lost0, reserve0);
        System.out.println(result0);

        int attend1 = 5;
        int lost1[] = {2, 4};
        int reserve1[] = {3};

        int result1 = gc.GymCloth(attend1, lost1, reserve1);
        System.out.println(result1);

        int attend2 = 3;
        int lost2[] = {3};
        int reserve2[] = {1};

        int result2 = gc.GymCloth(attend2, lost2, reserve2);
        System.out.println(result2);


    }

}