package LinkedList.Algoexpert;

import Utils.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }
    public static LinkedList reverseLinkedList(LinkedList head) {
        if(head == null) return null;
        LinkedList node = head;
        LinkedList prev = null;

        while(node.next != null){
            LinkedList temp = node;
            temp.next = prev;
            node = node.next;
            prev = temp;
        }
        node.next = prev;

        return node;
    }
}
