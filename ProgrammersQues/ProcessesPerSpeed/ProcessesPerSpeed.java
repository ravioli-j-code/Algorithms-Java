package ProgrammersQues.ProcessesPerSpeed;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 03. 10 오후 2:33
 */
public class ProcessesPerSpeed {

    class Process {
        int donePer;
        int workPer;
        int finishDays;

        public Process(int donePer, int workPer) {
            this.donePer = donePer;
            this.workPer = workPer;
            this.finishDays = ((100 - donePer) % workPer > 0) ? ((100 - donePer) / workPer + 1) : ((100 - donePer) / workPer);
        }

    }

    int[] calcProcessPerSpeed(int[] progresses, int[] speeds) {
        int[] answer = {};

        if (progresses.length != speeds.length) {
            return answer;
        }

        Queue<Integer> finishDays = new LinkedList <>();
        for (int i = 0 ; i < progresses.length ; i++ ) {
            Process p = new Process(progresses[i], speeds[i]);
            finishDays.offer(p.finishDays);
        }

        Queue<Integer> releaseDayQueue = new LinkedList <>();
        int target = 0;
        int jobs = 0;
        while (!finishDays.isEmpty()) {

            if (target == 0) {
                target = finishDays.remove();
                jobs++;
            }

            if (target < finishDays.peek()){
                releaseDayQueue.offer(jobs);
                target = finishDays.remove();
                jobs = 1; // 초기화
            } else {
                finishDays.remove();
                jobs++;
            }

            if(finishDays.isEmpty()) {
                releaseDayQueue.offer(jobs);
            }

        }

        return releaseDayQueue.stream().mapToInt(Integer::intValue).toArray();
    }


}