package ProgrammersQues.DiskController;

import java.util.*;

/**
 * @author : 진경인
 * @version : 1.0
 * @since : 2021. 05. 27 오전 9:20
 */
public class DiskController {

    /**
     * DiskController
     *
     * 문제 설명
     * 하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다.
     * 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
     *
     * 예를들어
     *
     * - 0ms 시점에 3ms가 소요되는 A작업 요청
     * - 1ms 시점에 9ms가 소요되는 B작업 요청
     * - 2ms 시점에 6ms가 소요되는 C작업 요청
     *
     * 한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
     * - A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
     * - B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
     * - C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
     * 이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.
     *
     * 하지만 A → C → B 순서대로 처리하면
     * - A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
     * - C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
     * - B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
     * 이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
     *
     * 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
     * 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지
     * return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
     *
     * 제한 사항
     * jobs의 길이는 1 이상 500 이하입니다.
     * jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
     * 각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
     * 각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
     * 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
     *
     * 입출력 예
     * jobs	return
     * [[0, 3], [1, 9], [2, 6]]	9
     * 입출력 예 설명
     * 문제에 주어진 예와 같습니다.
     *
     * 0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
     * 1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
     * 2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
     *
     */

    static class Job {

        int reqTime;
        int leftTime;
        int processTime;
        int startTime = 0;

        public Job(int[] param) {
            this.reqTime = param[0];
            this.leftTime = param[1];
            this.processTime = param[1];
        }

        public void process() {
           this.leftTime--;
        }

        public boolean isFinished() {
           return this.leftTime > 0 ? false : true;
        }

        public int getDuration(int endTime) {
            return endTime - this.reqTime;
        }

    }

    static class Processor {

        Queue<Job> jobList;
        Job currentJob;
        int size;
        int workingTime = 0;
        int durTime = 0;


        // init
        public Processor(int[][] jobs) {
            jobList = new LinkedList <>();
            for (int[] j : jobs) {
                jobList.add(new Job(j));
            }
            this.size = jobList.size();
        }

        public Job getShortProcessJob (int workingTime) {
            Job shortJob = null;
            Queue<Job> filteredQueue = new LinkedList <>();

            while (!jobList.isEmpty() ) {

                if ( shortJob == null) {
                    shortJob = jobList.poll();
                } else if ( shortJob.processTime > jobList.peek().processTime ){
                    filteredQueue.add(shortJob);
                    shortJob = jobList.poll();
                } else {
                    filteredQueue.add(jobList.poll());
                }
            }

            if (workingTime < shortJob.reqTime) {
                filteredQueue.add(shortJob);
                shortJob = null;
            }

            while (!filteredQueue.isEmpty() ) {
                jobList.offer(filteredQueue.poll());
            }

            return shortJob;
        }

        public Job getFirstRequestJob () {
            Job firstJob = null;
            Queue<Job> filteredQueue = new LinkedList <>();

            while (!jobList.isEmpty() ) {

                if ( firstJob == null) {
                    firstJob = jobList.poll();
                } else if ( firstJob.reqTime > jobList.peek().reqTime ){
                    filteredQueue.add(firstJob);
                    firstJob = jobList.poll();
                } else {
                    filteredQueue.add(jobList.poll());
                }
            }

            if (workingTime < firstJob.reqTime) {
                filteredQueue.add(firstJob);
                firstJob = null;
            }

            while (!filteredQueue.isEmpty() ) {
                jobList.offer(filteredQueue.poll());
            }

            return firstJob;
        }

        public int startProcess() {

            while(!jobList.isEmpty()) {

                // currentJob 갱신
                if ( currentJob == null ) {

                    Job firstJob = getFirstRequestJob();
                    if (firstJob != null ) {
                       currentJob = firstJob;
                       jobList.remove(firstJob);
                    }

                } else if (currentJob.isFinished()) {

                    Job shortJob = getShortProcessJob(workingTime);
                    if (shortJob != null ) {

                        durTime += currentJob.getDuration(workingTime);
                        System.out.println("workingTime : " + workingTime + " request : " + currentJob.reqTime + " processTime : " + currentJob.processTime + " duration time : " + durTime);

                        currentJob = shortJob;
                        jobList.remove(shortJob);

                    }
                }

                workingTime++;

                if (currentJob != null)
                    currentJob.process();

            }

            durTime += currentJob.getDuration(workingTime);
            System.out.println("workingTime : " + workingTime + " request : " + currentJob.reqTime + " processTime : " + currentJob.processTime + " duration time : " + durTime);

            return durTime / size;
        }

    }

    public static int solution(int[][] jobs) {

        Processor processor = new Processor(jobs);
        return processor.startProcess();
    }

    public static void main(String[] args) {

        int[][] jobsArr = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};

        int rInt = solution(jobsArr);
        System.out.println(rInt);

    }
}