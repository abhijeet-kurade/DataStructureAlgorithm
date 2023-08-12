package LinkedList.Algoexpert;

import Utils.LinkedList;

public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {

    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList head) {
        LinkedList current = head;
        LinkedList nextNode = head.next;

        while (nextNode != null){
            if(current.value != nextNode.value){
                current.next = nextNode;
                current = nextNode;
            }
            nextNode = nextNode.next;
        }

        current.next = null;

        return head;
    }

}
