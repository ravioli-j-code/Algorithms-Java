package ProgrammersQues.TruckCrossBridge;

import java.util.*;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 03. 03 오후 2:24
 */
public class TruckCrossBridge {
//
//    int getCrosstime(int bridge_length, int weight, int[] truck_weights) {
//
//        int checktime = 0; // 맨 앞은 1초부터 시작함.
//        int sum = 0;
//        int totalsum = 0;
//        // 트럭이 한대인지?
//        if (truck_weights.length == 1) {
//            sum = truck_weights[0];
//            if (sum > weight) {
//                checktime = 0;
//            } else {
//                checktime = bridge_length + 1;
//            }
//        } else {
//            for (int i = 0; i < truck_weights.length; i++) {
//                sum += truck_weights[i];
//                totalsum += truck_weights[i];
//                if (sum <= weight) { // 트럭을 연달아 보낼 수 있는지?
//                    checktime++;
//                } else {
//                    sum = truck_weights[i];
//                    checktime += (bridge_length + 1);
//                }
//            }
//            checktime = checktime + ((totalsum <= weight) ?  bridge_length : 0);
//        }
//        return checktime;
//    }

    int getCrossTime(int bridge_length, int weight, int[] truck_weights) {
        int crosstime = 0;
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0 ; i < truck_weights.length ; i++ ) {
            int sum = getSumofQueue(trucks) ;
            if (trucks.isEmpty() || (sum + truck_weights[i] <= weight)) {
                trucks.offer(truck_weights[i]);
            } else if (sum + truck_weights[i] > weight) {
                crosstime += sumUpAndFlushQueue(trucks, bridge_length);
            }
        }
        return crosstime;
    }

    int getSumofQueue(Queue<Integer> trucks) {
        int sum = 0;
        Queue<Integer> copy = trucks;
        while(!copy.isEmpty()) {
            int item = copy.remove();
            sum += item;
        }
        return sum;
    }

    int sumUpAndFlushQueue(Queue<Integer> trucks, int bridge_length) {
        int crosstime = 1 + bridge_length;
        while(!trucks.isEmpty()) {
            trucks.remove();
            crosstime++;
        }
        return crosstime;
    }

}