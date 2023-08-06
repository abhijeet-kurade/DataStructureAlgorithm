package Heap;


import java.util.Collections;
import java.util.PriorityQueue;

class RunningMedian{
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public RunningMedian(){
        this.minHeap = new PriorityQueue<>();
        this.minHeap.add(Integer.MAX_VALUE);
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.maxHeap.add(Integer.MIN_VALUE);
    }
    public double insert(int num){
        double median = 0;
        if(this.maxHeap.size() == this.minHeap.size()){
            int mx = this.maxHeap.peek();
            int mn = this.minHeap.poll();
            if(num <= mn){
                median = num <= mx ? mx : num;
                this.maxHeap.add(num);
                this.minHeap.add(mn);
            }
            else {
                median = mn;
                this.maxHeap.add(mn);
                this.minHeap.add(num);
            }
        }
        else{
            int mx = this.maxHeap.poll();
            int anotherNum;
            if(num <= mx){
                this.maxHeap.add(num);
                this.minHeap.add(mx);
                anotherNum = this.maxHeap.peek();
            }
            else{
                this.maxHeap.add(mx);
                this.minHeap.add(num);
                anotherNum = this.minHeap.peek();
            }
            median = (double) ( mx + anotherNum ) / 2;
        }
        return median;
    }
}