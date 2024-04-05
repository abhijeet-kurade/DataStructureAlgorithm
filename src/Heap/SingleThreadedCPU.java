package Heap;

//https://leetcode.com/problems/single-threaded-cpu/

import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    static class Task{
        int idx;
        int enqueueTime;
        int processingTime;

        public Task(int idx, int enqueueTime, int processingTime) {
            this.idx = idx;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
    public int[] getOrder(int[][] tks) {
        PriorityQueue<Task> tasks = new PriorityQueue<>(
                (o1, o2)->{
                    return o1.enqueueTime - o2.enqueueTime;
                }
        );
        PriorityQueue<Task> sysQueue = new PriorityQueue<>(
                (o1, o2)->{
                    if(o1.processingTime != o2.processingTime) return o1.processingTime = o2.processingTime;
                    return o1.idx - o2.idx;
                }
        );
        for(int i=0; i<tks.length; i++){
            tasks.add(new Task(i, tks[i][0], tks[i][1]));
        }

        int[] ans = new int[tks.length];
        int idx = 0;
        int currTime = 0;
        while (!tasks.isEmpty() || !sysQueue.isEmpty()){
            while (!tasks.isEmpty() && currTime >= tasks.peek().enqueueTime){
                sysQueue.add(tasks.poll());
            }
            if(sysQueue.isEmpty() && tasks.isEmpty()) {
                break;
            }
            if(sysQueue.isEmpty()){
                currTime = tasks.peek().enqueueTime;
            }
            else {
                Task t = sysQueue.poll();
                currTime += t.processingTime;
                ans[idx++] = t.idx;
            }
        }
        return ans;
    }
}
