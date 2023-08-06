package Utils.DataStructure.Java;

import java.util.Deque;
import java.util.LinkedList;

public class DeQueue {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(10);
        deque.offerFirst(34);
        deque.offer(66);
        deque.offerLast(55);
        System.out.println(deque);
        for(int i : deque) System.out.print(i + " <- ");
        System.out.println(deque);
    }
}
