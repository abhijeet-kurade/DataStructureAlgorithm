package LinkedList.Algoexpert;

import Utils.LinkedList;

public class MergeLinkedLists {
    public static void main(String[] args) {

    }


    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList head = new LinkedList(0);
        LinkedList curr = head;
        while (headOne != null || headTwo != null){
            int one = headOne != null ? headOne.value : Integer.MAX_VALUE;
            int two = headTwo != null ? headTwo.value : Integer.MAX_VALUE;
            if(one <= two){
                curr.next = headOne;
                headOne = headOne.next;
            }
            else {
                curr.next = headTwo;
                headTwo = headTwo.next;
            }
            curr = curr.next;
        }
        return head.next;
    }
    public static LinkedList mergeLinkedLists1(LinkedList headOne, LinkedList headTwo) {
        LinkedList previous = null;
        LinkedList one = headOne;
        LinkedList two = headTwo;

        while (one != null && two != null){
            if(one.value < two.value){
                previous = one;
                one = one.next;
            }
            else{
                if (previous != null) previous.next = two;
                previous = two;
                two = two.next;
                previous.next = one;
            }
        }

        if(one == null) previous.next = two;
        return headOne.value < headTwo.value ? headOne : headTwo;
    }
}
