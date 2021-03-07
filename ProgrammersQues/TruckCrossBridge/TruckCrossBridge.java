package ProgrammersQues.TruckCrossBridge;

import java.util.*;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 03. 03 오후 2:24
 */
public class TruckCrossBridge {

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