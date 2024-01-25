package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueJavaWorking {
    static class Obj implements Comparable {
        int val1;
        int val2;
        int val3;

        public Obj(int val1, int val2, int val3) {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
        }



        @Override
        public String toString() {
            return "Obj{" +
                    "val1=" + val1 +
                    ", val2=" + val2 +
                    ", val3=" + val3 +
                    '}';
        }


        @Override
        public int compareTo(Object o) {
            return this.val3 - ((Obj)o).val1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Obj> pq = new PriorityQueue<>();



        pq.add(new Obj(2,3,4));
        pq.add(new Obj(12,3,7));
        pq.add(new Obj(22,13,14));
        pq.add(new Obj(4,3,6));


        while (pq.size() != 0){
            System.out.println(pq.poll());
        }
    }


}
