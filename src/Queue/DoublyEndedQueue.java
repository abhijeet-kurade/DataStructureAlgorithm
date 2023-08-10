package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DoublyEndedQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(37);
        queue.add(1);
        System.out.println(queue);
        System.out.println(queue.peek());

        Deque<Integer> dqueue = new LinkedList<>();
        dqueue.add(13);
        dqueue.add(37);
        dqueue.add(11);
        System.out.println(dqueue);

        System.out.println(dqueue.getFirst());
        System.out.println(dqueue.getLast());


    }
}
