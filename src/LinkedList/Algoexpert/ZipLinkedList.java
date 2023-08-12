package LinkedList.Algoexpert;

import Utils.LinkedList;

public class ZipLinkedList {
    public LinkedList zipLinkedList(LinkedList linkedList) {
        if(linkedList.next == null || linkedList.next.next == null) return linkedList;

        LinkedList slow = linkedList;
        LinkedList fast = linkedList;
        LinkedList prev = null;
        while (fast != null && fast.next != null){
            prev =slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList listOne = linkedList;
        LinkedList listTwo;
        if(fast == null){
            listTwo = slow;
            prev.next = null;
        }
        else{
            listTwo = slow.next;
            slow.next = null;
        }

        LinkedList current = listTwo;
        prev = null;
        while (current != null){
            LinkedList temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        listTwo = prev;

        LinkedList head = new LinkedList(0);
        current = head;
        int turn = 0;
        while (listOne != null || listTwo != null){
            boolean trn = turn++ % 2 == 0 ;
            if(trn){
                current.next = listOne;
                listOne = listOne.next;
            }
            else{
                current.next = listTwo;
                listTwo = listTwo.next;
            }
            current = current.next;
        }
        return head.next;
    }
}
