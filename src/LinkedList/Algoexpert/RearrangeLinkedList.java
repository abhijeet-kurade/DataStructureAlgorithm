package LinkedList.Algoexpert;

import Utils.LinkedList;

public class RearrangeLinkedList {
    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList smallListStart = new LinkedList(0);
        LinkedList smallListEnd = smallListStart;
        LinkedList equalListStart = new LinkedList(0);
        LinkedList equalListEnd = equalListStart;
        LinkedList largeListStart = new LinkedList(0);
        LinkedList largeListEnd = largeListStart;

        LinkedList currentNode = head;
        while(currentNode != null){
            if(currentNode.value < k){
                smallListEnd.next = currentNode;
                smallListEnd = currentNode;
            }
            else if(currentNode.value > k){
                largeListEnd.next = currentNode;
                largeListEnd = currentNode;
            }
            else{
                equalListEnd.next = currentNode;
                equalListEnd = currentNode;
            }
            currentNode = currentNode.next;
        }
        if (smallListStart.next != null && equalListStart.next != null &&  largeListStart.next != null){
            smallListEnd.next = equalListStart.next;
            equalListEnd.next = largeListStart.next;
        }
        else if (smallListStart.next != null && equalListStart.next != null &&  largeListStart.next == null){
            smallListEnd.next = equalListStart.next;
        }
        else if (smallListStart.next == null && equalListStart.next != null &&  largeListStart.next != null){
            smallListStart=equalListStart;
            equalListEnd.next = largeListStart.next;
        }
        else if (smallListStart.next == null && equalListStart.next == null &&  largeListStart.next != null){
            smallListStart = largeListStart;
        }
        else if (smallListStart.next != null && equalListStart.next == null &&  largeListStart.next != null){
            smallListEnd.next = largeListStart.next;
        }
        return smallListStart.next;
    }
    public static LinkedList rearrangeLinkedList1(LinkedList head, int k) {
        LinkedList new_start = new LinkedList(0);
        LinkedList return_start = new_start;

        LinkedList dummy_start = new LinkedList(0);
        dummy_start.next = head;

        LinkedList node;

        for(int i=0; i<2; i++){
            node = dummy_start;
            while (node.next != null){
                boolean condition = i==0 ? node.next.value < k : node.next.value == k;
                if(condition){
                    new_start.next = node.next;
                    node.next = node.next.next;
                    new_start = new_start.next;
                    new_start.next = null;
                }
                else node = node.next;
            }
        }

        new_start.next = dummy_start.next;
        return return_start.next;
    }
}
