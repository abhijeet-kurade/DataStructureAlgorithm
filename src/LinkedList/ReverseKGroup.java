package LinkedList;

import Utils.LinkedList;

public class ReverseKGroup {
    LinkedList reverseKGroup(LinkedList head, int k) {
        LinkedList node = head;
        for(int i=0; i<k; i++){
            if(node == head) return head;
            node = node.next;
        }

        LinkedList current = reverseKGroup(node, k);


        while (node != head){

        }
        /*
        LinkedList node = head;

        for(int i=0; i<k; i++){
            if(node == null) return head;
            node = node.next;
        }
        LinkedList current = reverseKGroup(node, k);

        while(head != node){
            LinkedList next = head.next;
            head.next = current;
            current = head;
            head= next;
        }
        return current;
        */

        return null;
    }

}
