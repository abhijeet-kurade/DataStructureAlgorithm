package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque();
        deque.add(6);
        deque.add(7);
        deque.add(8);
        deque.addFirst(9);
        deque.addLast(10);
        System.out.println(deque);
    }
}
