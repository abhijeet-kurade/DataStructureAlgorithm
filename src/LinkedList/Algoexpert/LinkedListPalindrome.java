package LinkedList.Algoexpert;

import Utils.LinkedList;

public class LinkedListPalindrome {
    public boolean linkedListPalindrome(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        while(
                fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList listOne = head;
        LinkedList listTwo;

        if(slow == null) listTwo = null;
        else{
            LinkedList node = slow;
            LinkedList prev = null;
            while (node.next != null){
                LinkedList temp = node.next;
                node.next = prev;
                prev = node;
                node = temp;
            }
            node.next = prev;
            listTwo = node;
        }

        while(listTwo != null){
            if(listOne.value != listTwo.value) return false;
            listOne = listOne.next;
            listTwo = listTwo.next;
        }
        return true;
    }
}
