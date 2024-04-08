package Dequeue;

import Utils.DataStructure.Java.DoublyEndedQueue;

import java.util.*;

public class MinMaxInFixedSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {10,1,5,4,7,6};
        System.out.println(minInFixedSlidingWindow(arr, 3));
    }

    public static List<Integer> minInFixedSlidingWindow(int[] arr, int w){
        Deque<Integer> deque =  new LinkedList<>();
        List<Integer> windowMinimum =  new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i-w+1 < 0) continue;
            while (!deque.isEmpty() && deque.peekFirst() < i-w+1){
                deque.pollFirst();
            }
            if(!deque.isEmpty()){
                windowMinimum.add(arr[deque.peekFirst()]);
            }
        }
        return windowMinimum;
    }
}
