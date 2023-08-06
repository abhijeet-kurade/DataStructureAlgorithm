package Heap;

import Utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int len = lists.length;
        for(int i=0; i<len; i++){
            if(lists[i] != null) heap.add(lists[i]);
        }
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode root1 = root;
        while (!heap.isEmpty()){
            ListNode node = heap.remove();
            root.next = node;
            root = root.next;
            node = node.next;
            if(node != null) heap.add(node);
        }
        return  root1.next;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        int len = lists.length;
        for(int i=0; i<len; i++){
            if(lists[i] != null) heap.add(lists[i]);
        }
        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode root1 = root;
        while (!heap.isEmpty()){
            ListNode node = heap.remove();
            root.next = node;
            root = root.next;
            node = node.next;
            if(node != null) heap.add(node);
        }
        return  root1.next;
    }

}
