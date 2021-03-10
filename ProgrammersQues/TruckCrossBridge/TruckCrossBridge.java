package ProgrammersQues.TruckCrossBridge;

import java.util.*;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 03. 03 오후 2:24
 * 1. 트럭이 지나가기 전에 다리에 있는 트럭의 무게를 확인.
 * 자기 무게를 더한게 가능한
 */
public class TruckCrossBridge {

    int runTrucks(int bridge_length, int weight, int[] truck_weights) {

        if (bridge_length == 0 && weight == 0) return 0;
        if (truck_weights.length == 0) return 0;

        Queue<Integer> trucksOnBridge = new LinkedList<>();
        for (int i = 0 ; i < truck_weights.length ; i++ ) {
            if ( truck_weights[i] > weight ) { // 넘어갈수 있는 트럭인지 확인
                continue;
            }
            // 넘어갈 수 있는 아이들 목록을 넣음
            trucksOnBridge.offer(truck_weights[i]);
        }

        if (trucksOnBridge.isEmpty()) {
            return 0;
        }

        int crosstime = 1;
        int onBridgeWeight = 0;
        int onCrossing = 0;
        while(!trucksOnBridge.isEmpty()){

            // 건널 트럭의 하중 예상치
            int thisTruckSum = onBridgeWeight + trucksOnBridge.peek();

            // 지금 다리위에 있는 트럭의 수가 다리의 길이보다 많은가?
            // 혹은 예상치가 하중보다 큰가?
            // 그렇다면 초기화
            if ( onCrossing > bridge_length || thisTruckSum > weight) {
                onBridgeWeight = 0;
                onCrossing = 0;
            // 예상치가 하중보다 작으면 건넌다.
            } else if ( thisTruckSum < weight ) {

                // 건너는 시간은 비어있는 다리를 건널때 length만큼 소모
                if (onBridgeWeight < 1) {
                    crosstime += bridge_length;
                } else { // 비어있지 않으면 1만큼 소모
                    crosstime += 1;
                }
                onBridgeWeight += trucksOnBridge.remove();
                onCrossing++;
            // 예상치가 하중과 같은 경우 건널 수 있다.
            } else if ( thisTruckSum == weight ) {

                // 비어있는 다리를 건널때 length만큼 소모
                if (onBridgeWeight < 1) {
                    crosstime += bridge_length;
                } else { // 비어있지 않으면 1만큼 소모
                    crosstime += 1;
                }

                trucksOnBridge.remove(); // 건넌다.
                onBridgeWeight = 0; // 건넌뒤 다리의 무게는 초기화됨
                onCrossing = 0;
            }
        }

        return crosstime;
    }

}