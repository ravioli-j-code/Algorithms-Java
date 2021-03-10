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

    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moveTruck() {
            move++;
        }

    }

    int runTrucks(int bridge_length, int weight, int[] truck_weights) {

        if (bridge_length == 0 && weight == 0) return 0;
        if (truck_weights.length == 0) return 0;

        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> moving = new LinkedList<>();

        for (int t : truck_weights) {
            waiting.offer(new Truck(t));
        }

        int answer = 0;
        int weightOnBridge = 0;

        // 기다리는 애가 있거나
        // 움직이는 애가 있으면 계속 진행
         System.out.println("==========================");
        while(!waiting.isEmpty() || !moving.isEmpty()) {
            answer++; // 최초 1 카운트..

            System.out.println("------------------");
            System.out.println(waiting.size());
            System.out.println(moving.size());
            System.out.println("------------------");

            // 만약 움직이는 트럭이 없으면
            if (moving.isEmpty()) {
                Truck t = waiting.poll();
                weightOnBridge += t.weight; // 대기에서 트럭하나를 꺼내와서 다리에 집어넣기.
                moving.offer(t);
                continue;
            }

            // 움직이는 트럭이 있으면
            for (Truck t : moving) {
                t.moveTruck(); // 한단계 더 나가기
            }

            // 한단계 나간 아이가 다리 길이보다 넘어가면
            if (moving.peek().move > bridge_length) {
                Truck t = moving.poll();
                weightOnBridge -= t.weight; // 다리 무게에서 그 아이의 무게를 빼준다.
            }

            // 기다리는 아이가 있고 그 아이의 무게와 다리위 무게가 다리의 하중보다 작으면
            if (!waiting.isEmpty() && weightOnBridge + waiting.peek().weight <= weight ) {
                Truck t = waiting.poll(); // 기다리는 아이중에 하나를 데려와서 다리에 집어넣음.
                weightOnBridge += t.weight;
                moving.offer(t);
            }

        }

        return answer;
    }

}