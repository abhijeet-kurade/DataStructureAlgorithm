package Heap.AlgoExpert;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedianHandler {
    double median = 0;

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public ContinuousMedianHandler(){
        this.low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1;
            }
        });
        this.high = new PriorityQueue<>();
    }

    public void insert(int number) {
        int lenOne = this.low.size();
        int lenTwo = this.high.size();

        int low_top = this.low.peek();
        if(lenOne == lenTwo){
            if(lenOne == 0){
                this.low.add(number);
                this.median = this.low.peek();
                return;
            }
            if(lenOne == 0)
                if(low_top >= number){
                    this.low.add(number);
                    this.median = this.low.peek();
                }
                else{
                    this.high.add(number);
                    this.median = this.high.peek();
                    this.low.add(this.high.poll());
                }
        }
        else{
            if(lenTwo == 0){
                this.high.add(number);
                this.median = (this.low.peek() + this.high.peek()) / 2;
                return;
            }
            if(low_top >= number){
                this.low.add(number);
                this.high.add(this.low.poll());
            }
            else{
                this.high.add(number);
            }
            this.median = (this.low.peek() + this.high.peek()) / 2;
        }
    }

    public double getMedian() {
        return median;
    }
}