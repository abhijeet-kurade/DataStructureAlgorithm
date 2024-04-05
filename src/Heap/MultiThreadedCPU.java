package Heap;

import Maths.LCMArray;

import java.util.*;
import java.util.stream.Collectors;

public class MultiThreadedCPU {
    public static void main(String[] args) {

        int[] threads = {2,3,4};
        System.out.println(getTime(threads, 253));
    }

    static class Thread {
        int id;
        int time;
        int finish;

        public Thread(int id, int time, int finish) {
            this.id = id;
            this.time = time;
            this.finish = finish;
        }
    }
    public static int getTime(int[] threads, int tasks){

        int n = threads.length;
        if(tasks <= n) {
            Arrays.sort(threads);
            return threads[tasks-1];
        }

        int[] lcm = getTimeAfterLcm(threads, tasks);

        tasks = lcm[0];

        PriorityQueue<Thread> threadPool = new PriorityQueue<>(
                (o1, o2)-> {
                    if(o1.finish != o2.finish) return o1.finish - o2.finish;
                    return o1.time - o2.time;
                }
        );
        for(int i=0; i<n; i++){
            threadPool.add(new Thread(i, threads[i], 0));
        }
        int currTime = 0;
        int task = 0;
        while(!threadPool.isEmpty() && task <= tasks+1){
            if(currTime >= threadPool.peek().finish){
                while (task <= tasks+1 && !threadPool.isEmpty() && currTime >= threadPool.peek().finish){
                    Thread thread = threadPool.poll();
                    thread.finish = currTime + thread.time;
                    threadPool.add(thread);
                    task += 1;
                    if(task == tasks+1) return lcm[1]+thread.finish;
                }
            }
            else {
                currTime = threadPool.peek().finish;
            }
        }
        return -1;
    }

    public static int[] getTimeAfterLcm(int[] threads, int tasks){
        int lcm = LCMArray.findLCM(threads);

        int lcmTasks = 0;
        for (int t : threads){
            lcmTasks += lcm / t;
        }
        int cycles = tasks / lcmTasks;

        int remainTasks = tasks - (cycles * lcmTasks);
        int lcmTasksTime = lcm * cycles;

        tasks = remainTasks;
        return new int[]{tasks, lcmTasksTime};
    }
}
