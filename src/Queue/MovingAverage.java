package Queue;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    int maxSiz;
    int currSize;
    double sum;
    Queue<Integer> list;
    public MovingAverage(int size) {
        this.maxSiz = size;
        this.currSize =0;
        this.list = new LinkedList<>();
        this.sum =0;
    }


    public double next(int val) {
        list.add(val);
        sum += val;
        if(currSize<maxSiz){
            currSize += 1;
        }
        else {
            int last = list.remove();
            sum -= last;
        }
        return  sum/currSize;
    }
}
