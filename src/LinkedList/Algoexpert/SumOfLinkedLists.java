package LinkedList.Algoexpert;

import Utils.LinkedList;

public class SumOfLinkedLists {
    public static void main(String[] args) {

    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {

        LinkedList new_head = new LinkedList(0);
        LinkedList current = new_head;

        LinkedList listOne = linkedListOne;
        LinkedList listTwo = linkedListTwo;

        int carry = 0;

        while (listOne != null || listTwo != null || carry != 0){

            int one = listOne != null ? listOne.value : 0;
            int two = listTwo != null ? listTwo.value : 0;

            int sum = one + two + carry;
            carry = sum / 10;
            sum %= 10;

            LinkedList new_node = new LinkedList(sum);
            current.next = new_node;
            current = current.next;

            listOne = listOne != null ? listOne.next : null;
            listTwo = listTwo != null ? listTwo.next : null;

        }

        return new_head.next;

    }
}
